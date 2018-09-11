package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.codecool.PhraseReverse.*;

class PhraseReverseTest {
    private final String sentence = "this is one long sentence without punctuation";
    private final String palindrome = "radar eye radar";

    @Test
    void reverseReversesWholeString() {
        assertEquals("noitautcnup tuohtiw ecnetnes gnol eno si siht", reverse(sentence));
        assertEquals(".  ", reverse("  ."));
        assertEquals(palindrome, reverse(palindrome));
    }

    @Test
    void reverseWordOrderWorksWithSentence() {
        assertEquals("punctuation without sentence long one is this", reverseWordOrder(sentence));
        assertEquals(palindrome, reverse(palindrome));
    }

    @Test
    void reverseWordOrderGivesBackSameStringWhenGivenOnlyOneWord() {
        assertEquals("word", reverseWordOrder("word"));
    }

    @Test
    void reverseWordOrderWorksWithMultipleSpaces() {
        assertEquals("words    between    spaces", reverseWordOrder("spaces    between    words"));
    }

    @Test
    void reverseNReversesFirstNCharacters() {
        assertEquals(" si sihtone long sentence without punctuation", reverseN(sentence, 8));
        assertEquals("ecnetnes gnol eno si siht without punctuation", reverseN(sentence, 25));
        assertEquals(palindrome, reverseN(palindrome, 5));
    }

    @Test
    void reverseNCanMakeACurseWordFromThis() {
        assertEquals("shit is one long sentence without punctuation",
                reverseN(reverseN(reverseN(reverseN(sentence, 2), 3), 2), 4));
    }

    @Test
    void reverseNGivesBackSameStringWithZeroCharsReversed() {
        assertEquals(sentence, reverseN(sentence, 0));
    }

    @Test
    void reverseNThrowsExceptionWhenGivenOutOfBoundsIndex() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> reverseN(sentence, -5));
        assertThrows(StringIndexOutOfBoundsException.class, () -> reverseN(sentence, 100));
    }

    @Test
    void reverseArrayReversesArrayOrder() {
        assertArrayEquals(new String[] {"3", "2", "1"}, reverseArray(new String[] {"1", "2", "3"}));
    }

    @Test
    void joinJoinsArrayWithGivenString() {
        assertEquals(sentence, join(sentence.split(" "), " "));
        assertEquals(sentence, join(sentence.split(""), ""));
    }

    @Test
    void joinGivesBackEmptyStringWhenGivenEmptyArray() {
        assertEquals("", join(new String[0], sentence));
    }

}