package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

public class MemoryGameActivity extends AppCompatActivity {

    public static final String WORDLIST = "WordList";

    Button reveal;

    TextView noWords;
    TextView currentWord;
    TextView currentDefinition;
    Integer indexPos;
    Word currentWordObject;
    Integer numberOfRandomWords;
    MemoryGame memoryGame;

    public MemoryGameActivity(){
        this.indexPos = 0;
        this.currentWordObject = new Word("", "");
        this.numberOfRandomWords = 0;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);

        Intent intent = getIntent();

        // Get wordList from saved preferences

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString("WordList", "Default");
        Gson gson = new Gson();
        TypeToken<WordList> wordListObject = new TypeToken<WordList>() {
        };
        WordList wordList = gson.fromJson(myWordList, wordListObject.getType());

        memoryGame = new MemoryGame();

        memoryGame.pickWords(wordList);

        // Find out how many words I need

        numberOfRandomWords = memoryGame.getLength();

        reveal = (Button)findViewById(R.id.reveal_button);

        // Create all textviews and set to invisible

        noWords = (TextView) findViewById(R.id.no_words_message);
        currentWord = (TextView) findViewById(R.id.current_word);
        currentDefinition = (TextView) findViewById(R.id.current_definition);

        changeTextViewToGone(noWords);
        changeTextViewToGone(currentWord);
        changeTextViewToGone(currentDefinition);

        // If wordlist doesn't exist, return a message saying "No words yet!"

        if (myWordList.equals("Default")) {

            noWords = (TextView) findViewById(R.id.no_words_message);

        } else {

            // If no words in list, display No Words message

                if (numberOfRandomWords.equals(indexPos)) {
                        changeTextViewToVisible(noWords);
                    }

                else {

                    // set instance currentWordObject to the word at current index position

                    currentWordObject = memoryGame.getChosenWord(indexPos);

                    // Update the textview with the current word

                    updateTextView(this.currentWordObject.getWord(), this.currentWord);
                    changeTextViewToVisible(this.currentWord);
                    updateTextView(this.currentWordObject.getDefintion(), this.currentDefinition);
                    changeTextViewToInvisible(this.currentDefinition);

                    }

                }

        }

    public void onClickRevealButton(View button) {

        // Create currentWordObject as empty instance variable

        changeTextViewToVisible(this.currentDefinition);

        Log.d("button pressed", currentWordObject.getDefintion() );

        indexPos++;

        Handler myHandler = new Handler();
        myHandler.postDelayed(mMyRunnable, 2500);
    }

    public void setUpNextTextViews(){

        if (!indexPos.equals(numberOfRandomWords)) {

            currentWordObject = memoryGame.getChosenWord(indexPos);

            // Update the textview with the current word

            updateTextView(this.currentWordObject.getWord(), this.currentWord);
            changeTextViewToVisible(this.currentWord);
            updateTextView(this.currentWordObject.getDefintion(), this.currentDefinition);
            changeTextViewToInvisible(this.currentDefinition);

        }

        else {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }


    }


    private Runnable mMyRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            setUpNextTextViews();
        }
    };

    public void updateTextView(String word, TextView textView) {
        textView.setText(word);
    }

    public void changeTextViewToVisible(TextView textView){
        textView.setVisibility(TextView.VISIBLE);
    }

    public void changeTextViewToInvisible(TextView textView){
        textView.setVisibility(TextView.INVISIBLE);
    }

    public void changeTextViewToGone(TextView textView){
        textView.setVisibility(TextView.GONE);
    }

}
