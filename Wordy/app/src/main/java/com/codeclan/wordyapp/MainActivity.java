package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Button learnButton;
    Button newWordButton;
    public static final String WORDLIST = "WordList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        learnButton = (Button) findViewById(R.id.learn_button);
        newWordButton = (Button) findViewById(R.id.new_word_button);

        // Get any info from sharedpreferences file

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString( "WordList", new WordList().toString() );

        Gson gson = new Gson();
        TypeToken<WordList> newWordList = new TypeToken<WordList>(){};

        WordList wordList = gson.fromJson(myWordList, newWordList.getType());

        // New WordList object - with 1 added word for test

//        Display on this page

        ArrayList<Word> mainListWords = wordList.getWords();
        Collections.reverse(mainListWords);

        WordListAdapter wordListAdapter = new WordListAdapter(this, mainListWords);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(wordListAdapter);


    }

    public void onClickLearnButton(View button) {
        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, MemoryGameActivity.class);
        startActivity(intent);
    }

    public void onClickNewWordButton(View button) {

        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, NewWordActivity.class);
        startActivity(intent);
    }
}