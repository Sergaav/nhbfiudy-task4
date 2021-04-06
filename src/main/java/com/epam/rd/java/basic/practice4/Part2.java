package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Random;

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
        writeFile(stringBuilder.substring(0,stringBuilder.lastIndexOf(" ")), "part2_sorted.txt");
        System.out.print("input ==> "+ readFile("part2.txt"));
        System.out.print("output ==> "+ readFile("part2_sorted.txt"));
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
        File file = new File(fileName);
        boolean isExist = file.exists();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, Charset.forName("cp1251")))) {
            if (!isExist) {
                isExist = file.createNewFile();
            }
            if (isExist) {
                bufferedWriter.write(s);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String fileName) {
        File file = new File(fileName);
        StringBuilder stringBuffer = new StringBuilder();
        boolean isExist = file.exists();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file, Charset.forName("cp1251")))) {
            if (!isExist) {
                isExist = file.createNewFile();
            }
            if (isExist) {
                while (bufferedReader.ready()) {
                    stringBuffer.append(bufferedReader.readLine()).append(System.lineSeparator());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static String createAndFillFile() {
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            stringBuffer.append(new Random().nextInt(50)).append(" ");
        }
        String fileName = "part2.txt";
        writeFile(stringBuffer.substring(0, stringBuffer.lastIndexOf(" ")), fileName);

        return fileName;
    }

}
