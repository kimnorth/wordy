package com.codeclan.wordyapp;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by user on 18/03/2017.
 */

public class MemoryGame {

    ArrayList<Word> chosenWords;

    public MemoryGame(){
        this.chosenWords = new ArrayList<Word>();
    }

    public int getLength(){
        return this.chosenWords.size();
    }

    public ArrayList<Word> getChosenWords() { return this.chosenWords; }

    public Word getChosenWord(int index) { return this.chosenWords.get(index); }

    public void pickWords(WordList wordList){

        ArrayList<Word> allWords = wordList.getWords();

        int counter = 0; // initialize counter

        int lengthOfArrayList = allWords.size(); // get length of the arraylist of words

        int max_counter = 0; // initialize maximum counter

        if (lengthOfArrayList > 5){   // if the length of the arraylist is greater than 5
            max_counter = 5;          // set the maximum at 5
        }

        else {                                  // else set the maximum to the length of the arraylist
            max_counter = lengthOfArrayList;    // i.e. 1 - 4.
        }

        while (counter < max_counter) {

                Random rand = new Random();
                int index = rand.nextInt(allWords.size()) + 1;

                if (!chosenWords.contains(allWords.get(index - 1))) {
                    chosenWords.add(allWords.get(index - 1));
                    allWords.remove(index - 1);
                    counter++;
                }

        }

        // Something to be wary of for future development - it looks like this code might be producing
        // the same five objects every time. If you encounter problems
        // with the same five words being selected, the above code is the culprit!

    }

}
