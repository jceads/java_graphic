package com.java_graphic.core.utils;

import org.lwjgl.system.MemoryUtil;

import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Utils {
    public static FloatBuffer storeDataInFloatBuffer(float[] data) {
        FloatBuffer buffer = MemoryUtil.memAllocFloat(data.length);
        buffer.put(data).flip();
        return buffer;
    }

    public static IntBuffer storeDataInIntBuffer(int[] data) {
        IntBuffer buffer = MemoryUtil.memAllocInt(data.length);
        buffer.put(data).flip();
        return buffer;
    }

    public static String loadResource(String fileName) throws Exception {
        String result = null;
        try {
            InputStream inputStream = Utils.class.getClass().getResourceAsStream(fileName);
            Scanner scanner = new Scanner(inputStream,StandardCharsets.UTF_8.name());
            result = scanner.useDelimiter("\\A").next();
        }
        catch (Exception e){
            System.out.println("error: "+e.getMessage());
        }
        return result;

    }
    }


