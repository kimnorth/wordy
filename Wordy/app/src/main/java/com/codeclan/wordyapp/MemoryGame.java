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

    public void pickWords(WordList wordList){

        ArrayList<Word> allWords = wordList.getWords();

        System.out.println(wordList.getLength());
        System.out.println(allWords.size());

        int counter = 0;

        while (counter < 5) {

                Random rand = new Random();
                int index = rand.nextInt(allWords.size()) + 1;


                if (!chosenWords.contains(allWords.get(index - 1))) {
                    chosenWords.add(allWords.get(index - 1));
//                    System.out.println(allWords.get(index - 1));
                    allWords.remove(index - 1);
//                    System.out.println(chosenWords.size());
//                    System.out.println(allWords.size());
                    counter++;
                }

        }

        // Something to be wary of for future development - it looks like this code might be producing
        // the same five objects every time. If you encounter problems
        // with the same five words being selected, the above code is the culprit!

    }

}
