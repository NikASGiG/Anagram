package ua.foxminded.nikasgig.anagram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to anagram programm");
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        String exampleLine1 = "abcd efgh"; // "abcd efgh" => "dcba hgfe"
        String exampleLine2 = "a1bcd efg!h"; // "a1bcd efg!h" => "d1cba hgf!e"
        String exampleLine3 = "a1bcd"; // "a1bcd" => "d1cba"
        Reverser reverser = new Reverser();
        System.out.println("--------Test---------");
        System.out.println(exampleLine1 + " => " + reverser.convertLineToAnagram(exampleLine1));
        System.out.println(exampleLine2 + " => " + reverser.convertLineToAnagram(exampleLine2));
        System.out.println(exampleLine3 + " => " + reverser.convertLineToAnagram(exampleLine3));
        System.out.println("---------------------");
        System.out.print("Input your string: ");
        String yourInput = scanner.nextLine();
        System.out.println();
        System.out.println(yourInput + " => " + reverser.convertLineToAnagram(yourInput));
        scanner.close();
    }
}
