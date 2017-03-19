package com.codeclan.wordyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NewWordActivity extends AppCompatActivity {

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

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("new_word", newWord);
        intent.putExtra("new_definition", newDefinition);
        startActivity(intent);
    }
}
