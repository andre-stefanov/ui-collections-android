package com.jambit.advancelearningcontainers;

import android.graphics.Color;

import java.util.Random;

public class Content {

    public static class ColorSection {

        public String name;

        public String[] colors;

    }

    public static ColorSection[] SECTIONS;

    static {
        SECTIONS = new ColorSection[10];
        Random rnd = new Random();
        for (int i = 0; i < SECTIONS.length; i++) {
            SECTIONS[i] = new ColorSection();
            SECTIONS[i].name = "Section " + (i + 1);
            SECTIONS[i].colors = new String[9];
            for (int j = 0; j < SECTIONS[i].colors.length; j++) {
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                SECTIONS[i].colors[j] = String.format("#%06X", (0xFFFFFF & color));
            }
        }
    }

}
