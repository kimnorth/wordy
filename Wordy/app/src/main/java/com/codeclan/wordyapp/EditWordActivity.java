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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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

        // I could either edit the wordlist object containing the object, or delete the word and add
        // a new one, so it sits at the top of the list. I'm going to try the latter.

//        wordList.deleteWord(bundledWord); // this isn't the same object in the array

        for (Word word : wordList.getWords()){
            if (word.getWord().equals(bundledWord.getWord())){
                Log.d("Word object is", word.toString());
                wordList.deleteWord(word);

            }
        }

        Word _word = new Word(editedWord, editedDefinition);
        wordList.addWord(_word);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString( "WordList", gson.toJson( wordList ));
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }


}
