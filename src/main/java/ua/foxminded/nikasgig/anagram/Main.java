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
        AnagramService anagramService = new AnagramService();
        System.out.println("-------Test-------");
        System.out.println(exampleLine1 + " => " + anagramService.convertLine(exampleLine1));
        System.out.println(exampleLine2 + " => " + anagramService.convertLine(exampleLine2));
        System.out.println(exampleLine3 + " => " + anagramService.convertLine(exampleLine3));
        System.out.println("------------------");
        System.out.print("Input your string: ");
        String inputLine = scanner.nextLine();
        System.out.println();
        System.out.println(inputLine + " => " + anagramService.convertLine(inputLine));
        scanner.close();
    }
}
