package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class EditWordActivity extends AppCompatActivity {

    public static final String WORDLIST = "WordList";

    private Word bundledWord;
    private String passedWord;
    private String passedDefinition;
    private EditText wordToEdit;
    private EditText definitionToEdit;
    private Button editWordButton;
    private Integer indexPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);

        Bundle bundle = getIntent().getExtras();
        bundledWord = (Word) bundle.getSerializable("word");

        System.out.println(bundledWord.getWord());
        System.out.println(bundledWord.getDefintion());

        wordToEdit = (EditText)findViewById(R.id.word_to_edit);
        wordToEdit.setText(bundledWord.getWord(), TextView.BufferType.EDITABLE);

        definitionToEdit = (EditText)findViewById(R.id.definition_to_edit);
        definitionToEdit.setText(bundledWord.getDefintion(), TextView.BufferType.EDITABLE);

        editWordButton = (Button)findViewById(R.id.edit_word_button);

    }

    public void onClickUpdateButton(View button){

        String editedWord = wordToEdit.getText().toString();
        String editedDefinition = definitionToEdit.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString("WordList", "This message shouldn't come up");

        Gson gson = new Gson();

        TypeToken<WordList> wordListObject = new TypeToken<WordList>(){};
        WordList wordList = gson.fromJson(myWordList, wordListObject.getType());


        ArrayList<Word> remainingWords = new ArrayList<>();

        for (Word word : wordList.getWords()){

            if (!word.getWord().equals( bundledWord.getWord() )){
                remainingWords.add(word);
            }
        }

        wordList.replaceList(remainingWords);

        // The word being deleted isn't the same as the word object in the wordlist (even if they
        // have the same value)

        Word tempWord = new Word(editedWord, editedDefinition);
        wordList.addWord(tempWord);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString( "WordList", gson.toJson( wordList ));
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(EditWordActivity.this, "Word Edited", Toast.LENGTH_LONG).show();

    }


}
