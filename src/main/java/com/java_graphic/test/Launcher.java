package com.java_graphic.test;

import com.java_graphic.core.WindowManager;
import org.lwjgl.Version;

public class Launcher {
    private  static final String title = "First window";
    public static void main(String[] args) {
        System.out.println(Version.getVersion());
        WindowManager window = new WindowManager(title,1600,900,false);
        window.init();

        while (!window.windowShouldClose()){
            window.update();
        }


        window.cleanUp();
    }
}
