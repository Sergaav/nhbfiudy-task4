package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        String fileName = "src/source1.txt";
        Charset charset = Charset.forName("cp1251");
        StringBuilder stringBuilder = new StringBuilder();
        try (Reader in = new FileReader(fileName, charset)) {
            int s;
            while ((s = in.read()) != -1) {
                stringBuilder.append((char) s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        Pattern pattern = Pattern.compile("(?mU)\\w{4,}");
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find()) {
            matcher.appendReplacement(stringBuilder1, matcher.group().substring(2));
        }
        System.out.println(stringBuilder1.toString());


    }

}
