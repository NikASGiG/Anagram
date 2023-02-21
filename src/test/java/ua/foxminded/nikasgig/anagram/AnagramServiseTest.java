package ua.foxminded.nikasgig.anagram;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class AnagramServiseTest {
    private AnagramService anagramService = new AnagramService();
    
    @Test
    public void convertLine_whenGivenNull_ReturnNull() {
        String actual = anagramService.convertLine(null);
        assertEquals(null, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = { 
            "", 
            " ",
            "     ",
            "a,a",
            "aaaaaaaaaa,aaaaaaaaaa",
            "!!!111222333,!!!111222333"})
    public void convertLine_whenGivenString_ReturnsTheSameString(String input) {
        String actual = anagramService.convertLine(input);
        assertEquals(input, actual);
    }

    @ParameterizedTest
    @CsvSource({  
        "hello,olleh",
        "tree trees leaf leafes big bigger,eert seert fael sefael gib reggib",
        "QwErtY123tt pIPO,ttYtrE123wQ OPIp", 
        "     pipo,opip", 
        "qwer123tt pipo     ,ttre123wq opip",
        "qwer123tt pipo!1122344aaa,ttre123wq aaao!1122344pip,", })
    public void convertLine_whenGivenString_ReturnsSuccessAnagrmedString(String input, String expected) {
        String actual = anagramService.convertLine(input);
        assertEquals(expected, actual);
    }
}
