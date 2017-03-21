package com.codeclan.wordyapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class WordListTest {

    WordList wordList;
    ArrayList<Word> replacedList;
    ArrayList<Word> expected;
    Word newWord;
    Word newWord2;

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

    @Test
    public void canGetWords(){
        wordList = new WordList();
        newWord = new Word("Banana", "a yellow kind of beef");
        wordList.addWord(newWord);
        ArrayList<Word> gotWords = wordList.getWords();
        assertEquals(1, gotWords.size());
    }

    @Test
    public void canReplaceArrayList(){
        wordList = new WordList();
        newWord = new Word("Banana", "smiley face");
        newWord2 = new Word("Success", "you have replaced the ArrayList");
        replacedList = new ArrayList<Word>();
        replacedList.add(newWord2);
        wordList.replaceList(replacedList);
        expected = new ArrayList<Word>();
        expected.add(newWord2);
        assertEquals(expected, wordList.getWords());

    }

}
