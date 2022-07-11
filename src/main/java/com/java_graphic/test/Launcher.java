package com.java_graphic.test;

import com.java_graphic.core.EngineManager;
import com.java_graphic.core.WindowManager;
import com.java_graphic.core.utils.Constants;
import org.lwjgl.Version;

public class Launcher {
   private static WindowManager window;
   private static TestGame game;

    public static void main(String[] args) {
        System.out.println("program starting...");
        window = new WindowManager(Constants.TITLE,Constants.WIDTH,Constants.HEIGHT,false);
        game = new TestGame();

        EngineManager engineManager = new EngineManager();
        try {
            engineManager.start();
            System.out.println("program started");
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("program closing...");
    }

    public static WindowManager getWindow() {
        return window;
    }

    public static TestGame getGame() {
        return game;
    }
}
