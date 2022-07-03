package com.java_graphic.test;

import com.java_graphic.core.EngineManager;
import com.java_graphic.core.WindowManager;
import com.java_graphic.core.utils.Constants;
import org.lwjgl.Version;

public class Launcher {
   private static WindowManager window;
   private static EngineManager engineManager;

    public static void main(String[] args) {

        window = new WindowManager(Constants.TITLE,1600,900,false);
        engineManager = new EngineManager();

        try {
            engineManager.start();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static WindowManager getWindow() {
        return window;
    }
}
