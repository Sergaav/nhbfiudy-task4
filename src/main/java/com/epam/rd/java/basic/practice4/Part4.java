package com.epam.rd.java.basic.practice4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
    private final String input;

    public Part4(String fileName) {
        this.input = readFile(fileName);
    }

    public static void main(String[] args) {
        Part4 part4 = new Part4("part4.txt");
        Iterator<String> iterator = part4.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().trim() + System.lineSeparator());
        }
    }

    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    private String readFile(String fileName) {
        String out = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(fileName));
            out = new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return out;
    }


    private class IteratorImpl implements Iterator<String> {
        Pattern pattern = Pattern.compile("(?imU)\\s*[A-ZÀ-ß][^.!?]*[.!?]");
        Matcher matcher = pattern.matcher(input);
        boolean isNext = false;

        @Override
        public boolean hasNext() {
            isNext = matcher.find();
            return isNext;
        }

        @Override
        public String next() {
            if (!isNext)
                throw new NoSuchElementException();
            return matcher.group().replaceAll(System.lineSeparator(), " ");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
