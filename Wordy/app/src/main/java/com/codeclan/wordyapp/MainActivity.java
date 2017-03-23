package com.codeclan.wordyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.internal.BottomNavigationMenu;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    public static final String WORDLIST = "WordList";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get any info from sharedpreferences file

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString( "WordList", "This is a string" );

        Gson gson = new Gson();
        TypeToken<WordList> newWordList = new TypeToken<WordList>(){};

        if (myWordList.equals("This is a string")){
            myWordList = gson.toJson( new WordList() );
        }

        WordList wordList = gson.fromJson(myWordList, newWordList.getType());

//      Display on this page

        ArrayList<Word> mainListWords = wordList.getWords();
        Collections.reverse(mainListWords); // Put latest word at top

        WordListAdapter wordListAdapter = new WordListAdapter(this, mainListWords);

        ListView listView = (ListView) findViewById(R.id.main_list);
        listView.setAdapter(wordListAdapter);

    }

    public void onWordClicked(View textView) {

        Log.d(getClass().toString(), "Word was clicked");

        Word w = (Word) textView.getTag();

        Log.d(getClass().toString(), w.getWord());

        Bundle bundle = new Bundle();
        bundle.putSerializable("word", w);

        Intent intent = new Intent(this, EditWordActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    public void onDeleteButtonPressed(View imageView){

        SharedPreferences sharedPref = getSharedPreferences(WORDLIST, Context.MODE_PRIVATE);
        String myWordList = sharedPref.getString( "WordList", "This should not be seen" );

        Gson gson = new Gson();
        TypeToken<WordList> newWordList = new TypeToken<WordList>(){};

        WordList wordList = gson.fromJson(myWordList, newWordList.getType());

        Word w = (Word) imageView.getTag();

//        ArrayList<Word> arrayListOfWords = wordList.getWords();
        ArrayList<Word> remainingWords = new ArrayList<>();

        // Need to create a new arraylist of words that excludes any that match the bundled word
        // Then use my new method to add it to the wordList object
        // Then put that back up to shared preferences

        for (Word word : wordList.getWords()) {
            if (!word.getWord().equals(w.getWord())) {
                remainingWords.add(word);
            }
        }

        wordList.replaceList(remainingWords);

        SharedPreferences.Editor editor = sharedPref.edit();

        editor.putString( "WordList", gson.toJson( wordList ));
        editor.apply();

        Log.d(getClass().toString(), "Delete was clicked");
        finish();
        startActivity(getIntent());
        this.overridePendingTransition(0, 0);

        Toast.makeText(MainActivity.this, "Word Deleted", Toast.LENGTH_LONG).show();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_word, menu); //
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add_word_now) {

            Intent intent = new Intent(this, NewWordActivity.class);
            startActivity(intent);
            return true;

        }

        else if (item.getItemId() == R.id.learn) {
            Intent intent = new Intent(this, MemoryGameActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}