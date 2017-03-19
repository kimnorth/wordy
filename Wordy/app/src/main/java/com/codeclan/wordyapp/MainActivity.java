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

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        learnButton = (Button)findViewById(R.id.learn_button);

        WordList wordList = new WordList();
        ArrayList<Word> mainListWords = wordList.getWords();

        mainListWords.add(new Word("banana", "skin"));
        mainListWords.add(new Word("cheese", "A yellow kind of beef"));
        mainListWords.add(new Word("Godalming", "a place in surrey"));
        mainListWords.add(new Word("Gland", "something rude"));
        mainListWords.add(new Word("Sick", "excellent"));
        mainListWords.add(new Word("Dog", "a dyslexic god"));

        WordListAdapter wordListAdapter = new WordListAdapter(this, mainListWords);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(wordListAdapter);

    }

    public void onClickLearnButton(View button){
        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, MemoryGameActivity.class);
        startActivity(intent);
    }
}
