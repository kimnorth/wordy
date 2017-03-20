package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class NewWordActivity extends AppCompatActivity {

    public static final String WORDLIST = "WordList";

    TextView enterNewWord;
    TextView enterNewDefinition;
    EditText fieldNewWord;
    EditText fieldNewDefinition;
    Button addWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        enterNewWord = (TextView)findViewById(R.id.enter_new_word);
        enterNewDefinition = (TextView)findViewById(R.id.enter_new_definition);
        fieldNewWord = (EditText)findViewById(R.id.new_word_name);
        fieldNewDefinition = (EditText)findViewById(R.id.new_word_definition);
        addWord = (Button)findViewById(R.id.add_word_button);

    }

    public void onClickAddWordButton(View button){

        String newWord = fieldNewWord.getText().toString();
        String newDefinition = fieldNewDefinition.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString("WordList", "This is a string");

        Gson gson = new Gson();

        if (myWordList.equals("This is a string")){
            myWordList = gson.toJson(new WordList());
        }

        TypeToken<WordList> wordListObject = new TypeToken<WordList>(){};
        WordList wordList = gson.fromJson(myWordList, wordListObject.getType());

        Word word = new Word(newWord, newDefinition);
        wordList.addWord(word);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString( "WordList", gson.toJson( wordList ));
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
