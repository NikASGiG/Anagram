package ua.foxminded.nikasgig.anagram;

public class AnagramService {
    private static final String SPACE = " ";

    public String convertLine(final String inputLine) {
        if (!isValidate(inputLine)) {
            return inputLine;
        }
        String[] words = inputLine.split(SPACE);
        String result = "";
        for (int i = 0; i < words.length; i++) {
            result += convertWord(words[i]) + SPACE;
        }
        return result.trim();
    }

    private boolean isValidate(final String inputLine) {
        return !(inputLine == null || inputLine.trim().isEmpty());
    }

    private String convertWord(final String inputLine) {
        char[] list = inputLine.toCharArray();
        int beginCounter = 0;
        int endCounter = list.length-1;
        char temporaryChar;
        while (beginCounter < endCounter) {
            while (!Character.isLetter(list[beginCounter])) {
                beginCounter++;
            }
            temporaryChar = list[beginCounter];
            while (!Character.isLetter(list[endCounter])) {
                endCounter--;
            }
            list[beginCounter] = list[endCounter];
            list[endCounter] = temporaryChar;
            beginCounter++;
            endCounter--;
        }
        return new String(list);
    }
}
