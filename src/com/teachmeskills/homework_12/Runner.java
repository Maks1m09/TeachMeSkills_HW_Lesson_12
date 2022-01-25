package com.teachmeskills.homework_12;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) {
        try {
            Task12.readAndWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
