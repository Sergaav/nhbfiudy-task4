package com.savaz.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;

public class Part2 {

    public static void main(String[] args) {
        String input;
        StringBuilder stringBuilder = new StringBuilder();
        createAndFillFile();
        input = readFile(createAndFillFile()).trim();
        String[] temp = input.split(" ");
        int[] masInt = new int[temp.length];
        for (int i = 0; i < masInt.length; i++) {
            masInt[i] = Integer.parseInt(temp[i]);
        }
        sort(masInt);
        for (int j : masInt) {
            stringBuilder.append(j).append(" ");
        }
        writeFile(stringBuilder.substring(0, stringBuilder.lastIndexOf(" ")), "part2_sorted.txt");
        System.out.println("input ==> " + readFile("part2.txt"));
        System.out.println("output ==> " + readFile("part2_sorted.txt"));
    }


    private static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    private static void writeFile(String s, String fileName) {
        try (OutputStream out = Files.newOutputStream(Paths.get(fileName))) {
            out.write(s.getBytes(Charset.forName("cp1251")));
            out.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String readFile(String fileName) {
        String output = "";
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            output = new String(bytes, Charset.forName("cp1251"));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

    private static String createAndFillFile() {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(new SecureRandom().nextInt(50)).append(" ");
        }
        String fileName = "part2.txt";
        writeFile(stringBuffer.substring(0, stringBuffer.lastIndexOf(" ")), fileName);

        return fileName;
    }

}
