package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MemoryGameActivity extends AppCompatActivity {

    public static final String WORDLIST = "WordList";

    TextView noWords;
    TextView currentWord;
    TextView currentDefinition;

    MemoryGame memoryGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        Intent intent = getIntent();

        // Get wordList from saved preferences

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString("WordList", "Default");
        Gson gson = new Gson();
        TypeToken<WordList> wordListObject = new TypeToken<WordList>(){};
        WordList wordList = gson.fromJson(myWordList, wordListObject.getType());

        memoryGame = new MemoryGame();

        memoryGame.pickWords(wordList);

        // Find out how many words I need

        Integer numberOfRandomWords = memoryGame.getLength();

        // If wordlist doesn't exist, return a message saying "No words yet!"

        if (myWordList.equals("Default")) {

            noWords = (TextView) findViewById(R.id.no_words_message);

        } else {

            // Create all textviews and set to invisible

            noWords = (TextView)findViewById(R.id.no_words_message);
            currentWord = (TextView)findViewById(R.id.current_word);
            currentDefinition = (TextView)findViewById(R.id.current_definition);

            changeTextViewToGone(noWords);
            changeTextViewToGone(currentWord);
            changeTextViewToGone(currentDefinition);

            // Iterate through chosenwords update view on button press

            for (Word word : memoryGame.getChosenWords()){

                if (numberOfRandomWords.equals(0)){

                    changeTextViewToVisible(noWords);
                    break;

                }

                else if (word.equals(null)){
                    break;
                }

                else {
                    updateTextView(word.getWord(), currentWord);
                    changeTextViewToVisible(currentWord);

                }

            }


        }
    }

    public void updateTextView(String word, TextView textView) {
        textView.setText(word);
    }

    public void changeTextViewToVisible(TextView textView){
        textView.setVisibility(View.VISIBLE);
    }

    public void changeTextViewToGone(TextView textView){
        textView.setVisibility(View.GONE);
    }

}
