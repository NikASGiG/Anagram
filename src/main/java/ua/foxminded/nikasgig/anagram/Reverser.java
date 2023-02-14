package ua.foxminded.nikasgig.anagram;

public class Reverser {
    private static final String SPACE = " ";

    public String convertLineToAnagram(final String inputLine) {
        if (!isValidate(inputLine)) {
            return inputLine;
        }
        String[] lineArray = inputLine.split(SPACE);
        String result = "";
        for (int i = 0; i < lineArray.length; i++) {
            result += convertWordToAnagram(lineArray[i]);
            if (i != lineArray.length - 1) {
                result += SPACE;
            }
        }
        return result;
    }

    private boolean isValidate(final String inputLine) {
        if (inputLine == null || inputLine.length() == 0 || inputLine.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    private String convertWordToAnagram(final String inputLine) {
        char[] inputCharArray = inputLine.toCharArray();
        char[] charArrayOnlyLetters = new char[inputCharArray.length];
        int counterOnlyLetters = writeToArrayOnlyLetters(inputCharArray, charArrayOnlyLetters);
        reverseArrayWithOnlyLetters(charArrayOnlyLetters, counterOnlyLetters);
        writeResultCharArray(inputCharArray, charArrayOnlyLetters);
        return new String(inputCharArray);
    }

    private int writeToArrayOnlyLetters(char[] inputCharArray, char[] charArrayOnlyLetters) {
        int counterOnlyLetters = 0;
        for (char c : inputCharArray) {
            if (Character.isLetter(c)) {
                charArrayOnlyLetters[counterOnlyLetters] = c;
                counterOnlyLetters++;
            }
        }
        return counterOnlyLetters;
    }

    private void reverseArrayWithOnlyLetters(char charArray[], final int counterOnlyLetters) {
        for (int i = 0; i < counterOnlyLetters / 2; i++) {
            char temporaryChar = charArray[i];
            charArray[i] = charArray[counterOnlyLetters - 1 - i];
            charArray[counterOnlyLetters - 1 - i] = temporaryChar;
        }
    }

    private void writeResultCharArray(char[] inputCharArray, char[] charArrayOnlyLetters) {
        int counter = 0;
        for (int i = 0; i < inputCharArray.length; i++) {
            if (Character.isLetter(inputCharArray[i])) {
                inputCharArray[i] = charArrayOnlyLetters[counter];
                counter++;
            }
        }
    }
}
