package com.codeclan.wordyapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class WordListTest {

    WordList wordList;

    @Before
    public void before(){
        wordList = new WordList();
    }

    @Test
    public void canReturnLength(){
        assertEquals( 0, wordList.getLength() );
    }

    @Test
    public void canAddWord(){
        wordList.addWord("Banana", "a yellow kind of beef");
        assertEquals(1, wordList.getLength());
    }



}
