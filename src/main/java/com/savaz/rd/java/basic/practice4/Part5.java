package com.savaz.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        ResourceBundle resourceBundleRu = ResourceBundle.getBundle("resources", new Locale("ru"));
        ResourceBundle resourceBundleEn = ResourceBundle.getBundle("resources", new Locale("en"));
        while (!(input = scanner.nextLine()).equals("stop")) {
            String[] temp = input.split(" ");
            if (temp.length == 2) {
                switch (temp[1]) {
                    case "ru":
                        System.out.println(resourceBundleRu.getString(temp[0]));
                        break;
                    case "en":
                        System.out.println(resourceBundleEn.getString(temp[0]));
                        break;
                    default:
                        System.out.println("Incorrect input!");
                }
            }

        }


    }

}
