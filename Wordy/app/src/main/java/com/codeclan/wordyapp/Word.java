package com.codeclan.wordyapp;

/**
 * Created by user on 18/03/2017.
 */

public class Word {

    private String word;
    private String defintion;

    public Word(String word, String definition){
        this.word = word;
        this.defintion = definition;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefintion() {
        return defintion;
    }

    public void setDefintion(String defintion) {
        this.defintion = defintion;
    }
}
