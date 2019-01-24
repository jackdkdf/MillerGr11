package me.Jack.Assignment;

import java.util.Scanner;

public class Assignment25 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sOne = scanner.nextLine();
        String sTwo = scanner.nextLine();

        System.out.println("Length of first string: " + sOne.length());
        System.out.println("Comparing your first string to your second string: " + sOne.compareTo(sTwo));
        System.out.println("Comparing your first string to your second string if lowercase: " + sOne.compareToIgnoreCase(sTwo));
        System.out.println("Your first string is the same as your second string: " + sOne.equals(sTwo));
        System.out.println("Your first string is the same as your second string when both are lowercase: " + sOne.equalsIgnoreCase(sTwo));
        System.out.println("Your first string starts with your second string: " + sOne.startsWith(sTwo));
        System.out.println("Your first string starts with your second string at the 6th char: " + sOne.startsWith(sTwo, 5));
        System.out.println("Your first string contains your second string: " + sOne.contains(sTwo));
        System.out.println("Index of (String): " + sOne.indexOf(sTwo));
        System.out.println("Index of (String, i): " + sOne.indexOf(sTwo, 5));
        System.out.println("Index of (Char): " + sOne.indexOf('c'));
        System.out.println("Index of (Char, i): " + sOne.indexOf('c', 5));
        System.out.println("Last Index of (Char): " + sOne.lastIndexOf('c'));
        System.out.println("Last Index of (Char, i): " + sOne.lastIndexOf('c', 5));
        System.out.println("Last Index of (String): " + sOne.lastIndexOf(sTwo));
        System.out.println("Last Index of (String, i): " + sOne.lastIndexOf(sTwo, 5));
        System.out.println("Char At 5: " + sOne.charAt(5));
        System.out.println("Substring at 2: " + sOne.substring(2));
        System.out.println("Substring 1 to 3: " + sOne.substring(1, 3));
        System.out.println("Lowercase: " + sOne.toLowerCase());
        System.out.println("Uppercase: " + sOne.toUpperCase());
        System.out.println("Trim: " + sOne.trim());
    }
}
