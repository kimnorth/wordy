package com.codeclan.wordyapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class WordList {

    private ArrayList<Word> words;

    public WordList(){
        this.words = new ArrayList<Word>();
    }

    public int getLength(){
        return this.words.size();
    }

    public void addWord(String word, String definition){
        Word newWord = new Word(word, definition);
        words.add(newWord);
    }



}
