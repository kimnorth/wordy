package com.codeclan.wordyapp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WordTest {

    Word word;

    @Before
    public void before(){
        word = new Word("Banana", "A yellow kind of beef");
    }

    @Test
    public void hasWord(){
        assertEquals("Banana", word.getWord());
    }

    @Test
    public void hasDefinition(){
        assertEquals("A yellow kind of beef", word.getDefintion());
    }

    @Test
    public void canChangeWord(){
        word = new Word("Banana", "a yellow kind of beef");
        word.setWord("banana");
        assertEquals( "banana", word.getWord() );
    }

    @Test
    public void canChangeDefinition(){
        word = new Word("Banana", "a yellow kind of beef");
        word.setDefintion("a kind of yellow beef");
        assertEquals("a kind of yellow beef", word.getDefintion());
    }
}