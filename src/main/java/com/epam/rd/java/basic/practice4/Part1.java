package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        try  {
            byte[] bytes = Files.readAllBytes(Paths.get("part1.txt"));
            String input = new String(bytes,Charset.forName("cp1251"));
            StringBuffer stringBuffer = new StringBuffer();
            Pattern pattern = Pattern.compile("(?mU)\\w{4,}");
            Matcher matcher = pattern.matcher(input);
            while (matcher.find()) {
                matcher.appendReplacement(stringBuffer, matcher.group().substring(2));
            }
            matcher.appendTail(stringBuffer);
            System.out.println(stringBuffer.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
