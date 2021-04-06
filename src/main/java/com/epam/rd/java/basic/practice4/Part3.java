package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static void main(String[] args) {
        String inputData = readContentFromFile();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String choice;
        try {
            while (!(choice = bufferedReader.readLine()).equals("stop")) {
                switch (choice) {
                    case "char":
                        findAndPrint(inputData, "(^| =?)\\p{IsAlphabetic}{1}(?= )");
                        break;
                    case "String":
                        findAndPrint(inputData, "(?mU)\\p{IsAlphabetic}{2,}");
                        break;
                    case "int":
                        findAndPrint(inputData, " [0-9]+ ");
                        break;
                    case "double":
                        findAndPrint(inputData, " ([0-9]| )*\\.[0-9]+? ");
                        break;
                    default:
                        System.out.println("Incorrect input");
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void findAndPrint(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group()).append(" ");
        }
        if (stringBuilder.length() > 1) {
            System.out.println(stringBuilder.substring(0, stringBuilder.lastIndexOf(" ")));
        }
    }

    private static String readContentFromFile() {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("part3.txt", Charset.forName("cp1251")))) {
            while (bufferedReader.ready()) {
                stringBuilder.append(bufferedReader.readLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.substring(0, stringBuilder.lastIndexOf(System.lineSeparator()));
    }


}
