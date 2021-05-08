package com.savaz.rd.java.basic.practice4;

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
        String patternLatin = "[\\p{IsLatin}]+";
        String patternCyrl = "[^\\p{IsLatin}^\\p{Punct}]+";
        while (!(query = scanner.nextLine()).equals("stop")) {
            switch (query) {
                case "Latn":
                    parseString(input, patternLatin, "Latn");
                    break;
                case "Cyrl":
                    parseString(input, patternCyrl, "Cyrl");
                    break;
                default:
                    System.out.println(query + ": Incorrect input");
            }
        }

    }

    private static void parseString(String string, String r, String lang) {
        Pattern pattern = Pattern.compile(r);
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group().trim()).append(" ");
        }
        String prefix = lang + ": " + stringBuilder.toString().replaceAll("\n", " ").trim()+" ";
        System.out.println(prefix);
    }

    private static String getInputFromFile() {
        String output = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("part6.txt"));
            output = new String(bytes, Charset.forName("cp1251"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return output;
    }

}
