package algo.external.udemy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckAnagramTest {

    @Test
    void test() {
        assertTrue(new CheckAnagram().isAnagram("restful", "fluster"));
        assertTrue(new CheckAnagram().isAnagram("The Morse Code", "Here come dots"));
        assertTrue(new CheckAnagram().isAnagram("Fourth of July", "Joyful Fourth"));
        assertTrue(new CheckAnagram().isAnagram("Slot machines", "Cash lost in me"));
        assertFalse(new CheckAnagram().isAnagram("restful", "flustert"));
    }

}