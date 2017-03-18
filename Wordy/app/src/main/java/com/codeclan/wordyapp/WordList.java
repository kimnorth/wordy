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

    public void addWord(Word newWord){
        words.add(newWord);
    }

    public void deleteWord(Word wordToDelete){
        words.remove(wordToDelete);
    }

    public ArrayList<Word> getWords(){
        return this.words;
    }



}
