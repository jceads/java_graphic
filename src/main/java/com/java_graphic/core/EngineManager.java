package com.java_graphic.core;

import com.java_graphic.core.utils.Constants;
import com.java_graphic.test.Launcher;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

public class EngineManager {
    public static final long NANO_SECOND = 1000000000L;
    public static final float FRAME_RATE = 1000;

    private static int fps;
    private static float frameTime = 1.0f / FRAME_RATE;

    private boolean isRunning;

    private WindowManager windowManager;
    private GLFWErrorCallback errorCallback;

    private void init() throws Exception {
        GLFW.glfwSetErrorCallback(errorCallback = GLFWErrorCallback.createPrint(System.err));
        windowManager = Launcher.getWindow();
        windowManager.init();
    }

    public void start() throws Exception {
        init();
        if (isRunning)
            return;
        run();
    }

    public void run() {
        this.isRunning = true;
        int frames = 0;
        long frameCounter = 0;
        long lastTime = System.nanoTime();
        double unprocessedTime = 0;

        while (isRunning){
            boolean render = false;
            long startTime = System.nanoTime();
            long passedTime = startTime - lastTime;
            lastTime = startTime;

            unprocessedTime += passedTime /(double) NANO_SECOND;
            frameCounter += passedTime;
            frameCounter += passedTime;

            input();

            while (unprocessedTime >frameTime){
                render = true;
                unprocessedTime -= frameTime;

                if (windowManager.windowShouldClose()){
                    stop();
                }
                if (frameCounter>NANO_SECOND){
                    setFps(frames);
                    windowManager.setTitle(Constants.TITLE +getFps());
                    frames = 0;
                    frameCounter = 0;


                }
            }

            if (render){
                update();
                render();
                frames++;

            }
        }
        cleanUp();

    }

    private void stop() {
        if (!isRunning)
            return;
        isRunning = false;
    }

    private void input() {

    }

    private void update() {
    }

    private void render() {
        windowManager.update();
    }

    private void cleanUp() {
        windowManager.cleanUp();
        errorCallback.free();
        GLFW.glfwTerminate();
    }

    public static int getFps() {
        return fps;
    }

    public static void setFps(int fps) {
        EngineManager.fps = fps;
    }
}
