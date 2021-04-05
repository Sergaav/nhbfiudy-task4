package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

public class Part2 {

    public static void main(String[] args) {
        try {
            File fileIn = createAndFillFile("src/part2.txt");
            File fileOut = File.createTempFile("src","part2_sorted.txt");
            writeFile(fileOut,sort(readFile(fileIn)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int [] readFile(File file) {

   return null; }

    private static void writeFile(File file, int [] arr) {

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

    private static File createAndFillFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (Writer fileWriter = new FileWriter(file, Charset.forName("cp1251"))) {
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                int number = (random.nextInt(50));
                fileWriter.write(number + " ");
            }
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
