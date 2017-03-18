package com.codeclan.wordyapp;

import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class MemoryGame {

    private ArrayList<Word> chosenWords;

    public MemoryGame(){
        this.chosenWords = new ArrayList<Word>();
    }

    public int getLength(){
        return this.chosenWords.size();
    }

    public void pickWords(WordList wordList){

        ArrayList<Word> allWords = wordList.getWords();

        int counter = 0;

        for (Word word : allWords){
            // if the counter isn't 5...
            if (counter != 5){

                // and If the word isn't already in our chosen words arraylist - add it
                if (!chosenWords.contains(word)){
                    this.chosenWords.add(word);
                    counter++;
                }
            }
        }
    }

}
