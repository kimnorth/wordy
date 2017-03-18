package com.codeclan.wordyapp;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by user on 18/03/2017.
 */

public class MemoryGameTest {

    MemoryGame memoryGame;
    WordList wordsList;
    Word word1;
    Word word2;
    Word word3;
    Word word4;
    Word word5;

    @Before
    public void before(){
        memoryGame = new MemoryGame();
        wordsList = new WordList();
        word1 = new Word("Banana", "a kind of yellow beef");
        word2 = new Word("Fire", "a yellow thing");
        word3 = new Word("Hat", "a thing on your head");
        word4 = new Word("Seat", "for your arse");
        word5 = new Word("Bellows", "no idea");
        wordsList.addWord(word1);
        wordsList.addWord(word2);
        wordsList.addWord(word3);
        wordsList.addWord(word4);
        wordsList.addWord(word5);

    }

    @Test
    public void hasFiveWords(){
        memoryGame.pickWords(wordsList);
        assertEquals(5, memoryGame.getLength() );
    }

}
