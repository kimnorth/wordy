package com.codeclan.wordyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button learnButton;
    Button newWordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        learnButton = (Button)findViewById(R.id.learn_button);
        newWordButton = (Button)findViewById(R.id.new_word_button);

        WordList wordList = new WordList();

        wordList.addWord(new Word("banana", "skin"));
        wordList.addWord(new Word("cheese", "A yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzzA yellow kind of beefzzzzzzzzzzzzzz"));
        wordList.addWord(new Word("Godalming", "a place in surrey"));
        wordList.addWord(new Word("Gland", "something rude"));
        wordList.addWord(new Word("Sick", "excellent"));
        wordList.addWord(new Word("Dog", "a dyslexic god"));
        wordList.addWord(new Word("Dog", "a dyslexic god"));
        wordList.addWord(new Word("banana", "skin"));
        wordList.addWord(new Word("banana", "skin"));
        wordList.addWord(new Word("banana", "skin"));
        wordList.addWord(new Word("Dog", "a dyslexic god"));

        Intent newWordIntent = getIntent();
        Bundle extras = newWordIntent.getExtras();

        Word newWord = new Word(extras.getString("new_word"), extras.getString("new_definition"));
        if (newWord != null){
            wordList.addWord(newWord);
        }

        ArrayList<Word> mainListWords = wordList.getWords();

        WordListAdapter wordListAdapter = new WordListAdapter(this, mainListWords);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(wordListAdapter);


    }

    public void onClickLearnButton(View button){
        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, MemoryGameActivity.class);
        startActivity(intent);
    }

    public void onClickNewWordButton(View button){

        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, NewWordActivity.class);
        startActivity(intent);
    }
}
