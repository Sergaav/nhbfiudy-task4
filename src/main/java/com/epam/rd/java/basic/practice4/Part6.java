package com.epam.rd.java.basic.practice4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        String input = getInputFromFile();
        Scanner scanner = new Scanner(System.in);
        String query;
        String patternLatin = "\\p{IsLatin}+";
        String patternCyrl = "[^\\p{IsLatin}]+";
        while (!(query = scanner.nextLine()).equals("stop")) {
            switch (query) {
                case "Latn":
                    parseString(input, patternLatin,"Latn");
                    break;
                case "Cyrl":
                    parseString(input, patternCyrl,"Cyrl");
                    break;
                default:
                    System.out.println("Incorrect input");
            }
        }

    }

    private static void parseString(String string, String r,String lang) {
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder();
        String prefix = lang+": ";
        while (matcher.find()) {
            stringBuilder.append(matcher.group().trim()).append(" ");
        }
        System.out.println(prefix+stringBuilder.toString().trim());
    }

    private static String getInputFromFile() {
        String output = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("part6.txt"));
            output = new String(bytes, Charset.forName("cp1251"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

}
