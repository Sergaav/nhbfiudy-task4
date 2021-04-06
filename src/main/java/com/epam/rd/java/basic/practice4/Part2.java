package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Random;

public class Part2 {

    public static void main(String[] args) {


    }


    private static int[] sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

    private static File createAndFillFile() {
        File fileName = new File("part2.txt");
        Charset charset = Charset.forName("cp1251");
        if (!fileName.exists()){
            fileName.
        }

    }

}
