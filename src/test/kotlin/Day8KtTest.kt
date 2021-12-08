import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day8KtTest {

    @Test
    fun d8p1test() {
        assertEquals(26, d8p1())
    }

    @Test
    fun d8p2test() {
        assertEquals(61229, d8p2())
    }

    @Test
    fun subtractTest() {
        assertEquals("ad", subtract("abcd", "bc"))
    }

    @Test
    fun findDigitPatternsTest() {
        assertEquals(
            mapOf(
                "acedgfb" to 8,
                "cdfbe" to 5,
                "gcdfa" to 2,
                "fbcad" to 3,
                "dab" to 7,
                "cefabd" to 9,
                "cdfgeb" to 6,
                "eafb" to 4,
                "cagedb" to 0,
                "ab" to 1
        ),
            findDigitPatterns("acedgfb cdfbe gcdfa fbcad dab cefabd cdfgeb eafb cagedb ab")
        )
    }
}