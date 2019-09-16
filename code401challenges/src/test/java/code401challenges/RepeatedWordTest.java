package code401challenges;

import org.junit.Test;

import static org.junit.Assert.*;

public class RepeatedWordTest {

    @Test
    public void repeatedWord_string1() {
        assertEquals("a", RepeatedWord.repeatedWord("Once upon a time, there was a brave princess who..."));
    }

    @Test
    public void repeatedWord_string2() {
        assertEquals("it", RepeatedWord.repeatedWord("It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only..."));
    }

    @Test
    public void repeatedWord_string3() {
        assertEquals("summer", RepeatedWord.repeatedWord("It was a queer, sultry summer, the summer they electrocuted the Rosenbergs, and I didn’t know what I was doing in New York..."));
    }

    @Test
    public void repeatedWord_doesNotExist() {
        assertNull(RepeatedWord.repeatedWord("My name is matt"));
    }

}