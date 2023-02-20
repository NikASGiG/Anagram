package ua.foxminded.nikasgig.anagram;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AnagramServiseTest {

    private AnagramService anagramService = new AnagramService();
    private final String SPACE = " ";
    private final String FIVE_SPACES = "     ";

    @ParameterizedTest
    @NullSource
    void isBlank_ShouldReturnTrueForNullInputs(String input) {
        assertEquals(input, anagramService.convertLine(input));
    }

    @ParameterizedTest
    @ValueSource(strings = { "", SPACE, FIVE_SPACES })
    void convertLine_whenGivenString_ReturnsTheSameString(String input) {
        assertEquals(input, anagramService.convertLine(input));
    }

    @ParameterizedTest
    @CsvSource({ "a,a", "aaaaaaaaaa,aaaaaaaaaa", "ttYtrE123wQ OPIp,QwErtY123tt pIPO", "opip," + FIVE_SPACES + "pipo",
            "!!!111222333,!!!111222333", "ttre123wq opip,qwer123tt pipo" + FIVE_SPACES,
            "ttre123wq aaao!1122344pip,qwer123tt pipo!1122344aaa", })
    void convertLine_whenGivenString_ReturnsSuccessAnagrmedString(String expected, String input) {
        assertEquals(expected, anagramService.convertLine(input));
    }

}
