package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Locale localeRu = new Locale("ru");
        Locale localeEn = new Locale("en");
        ResourceBundle resourceBundleRu = ResourceBundle.getBundle("resources/resources_ru.properties",localeRu);
        ResourceBundle resourceBundleEn = ResourceBundle.getBundle("resources/resources_ru.properties",localeEn);
        while ((input=scanner.nextLine()).equals("stop")){
            String[] temp = input.split(" ");
            if (temp[1].equals("ru")){
                System.out.println(resourceBundleRu.getString(temp[0]));
            }
            if (temp[1].equals("en")){
                System.out.println(resourceBundleEn.getString(temp[0]));
            }
        }


    }

}
