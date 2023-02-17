package ua.foxminded.nikasgig.anagram;

public class AnagramService {
    private static final String SPACE = " ";

    public String convertLine(final String inputLine) {
        if (!isValidate(inputLine)) {
            return inputLine;
        }
        String[] words = inputLine.split(SPACE);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(reverseWord(words[i])).append(SPACE);
        }
        return result.toString().trim();
    }

    private boolean isValidate(final String inputLine) {
        return !(inputLine == null || inputLine.trim().isEmpty());
    }

    private String reverseWord(final String word) {
        StringBuilder resultWord = new StringBuilder();
        int endIndex = word.length() - 1;
        for (int i = 0; i < word.length(); i++) {
            if (Character.isLetter(word.charAt(i))) {
                while (!Character.isLetter(word.charAt(endIndex))) {
                    endIndex--;
                }
                resultWord.append(word.charAt(endIndex));
                endIndex--;
            } else {
                resultWord.append(word.charAt(i));
            }
        }
        return resultWord.toString();
    }

}
