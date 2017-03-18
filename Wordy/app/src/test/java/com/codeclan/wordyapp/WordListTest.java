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
    Word newWord;

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
        newWord = new Word("Banana", "a yellow kind of beef");
        wordList.addWord(newWord);
        assertEquals(1, wordList.getLength());
    }

    @Test
    public void canDeleteWord(){
        wordList = new WordList();
        newWord = new Word("Banana", "a yellow kind of beef");
        wordList.addWord(newWord);
        wordList.deleteWord(newWord);
        assertEquals(0, wordList.getLength());
    }

//    @Test
//    public void canEditWordInList(){
//        wordList = new WordList();
//        newWord = new Word("Banana", "a yellow kind of beef");
//        wordList.addWord(newWord);
//        // Need to create a method to edit word in the word class and test it.
//        assertEquals();
//    }



}
