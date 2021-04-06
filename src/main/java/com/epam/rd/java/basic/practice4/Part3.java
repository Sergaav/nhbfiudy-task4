package com.epam.rd.java.basic.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                        findAndPrint(inputData, "\\b\\p{IsAlphabetic}{1}(?=\\s)");
                        break;
                    case "String":
                        findAndPrint(inputData, "(?mU)\\p{IsAlphabetic}{2,}");
                        break;
                    case "int":
                        findAndPrint(inputData, "(?>\\s)[0-9]+(?=\\s)");
                        break;
                    case "double":
                        findAndPrint(inputData, "([0-9]|)*\\.[0-9\\.]+");
                        break;
                    default:
                        System.out.println("Incorrect input");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }

    private static void findAndPrint(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group().trim()).append(" ");
        }
        if (stringBuilder.length() > 1) {
            System.out.println(stringBuilder);
        }
    }

    private static String readContentFromFile() {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("part3.txt"));
            res = new String(bytes, Charset.forName("cp1251"));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return res;
    }


}
