package com.codeclan.wordyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class EditWordActivity extends AppCompatActivity {

    private Word word;
    private String passedWord;
    private String passedDefinition;
    private EditText wordToEdit;
    private EditText definitionToEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);

        Bundle bundle = getIntent().getExtras();
        word = (Word) bundle.getSerializable("word");

        System.out.println(word.getWord());
        System.out.println(word.getDefintion());

        wordToEdit = (EditText)findViewById(R.id.word_to_edit);
        wordToEdit.setText(word.getWord(), TextView.BufferType.EDITABLE);

        definitionToEdit = (EditText)findViewById(R.id.definition_to_edit);
        definitionToEdit.setText(word.getDefintion(), TextView.BufferType.EDITABLE);

    }



}
