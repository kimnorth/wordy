package com.codeclan.wordyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 19/03/2017.
 */

public class WordListAdapter extends ArrayAdapter<Word> {

    public WordListAdapter(Context context, ArrayList<Word> words){
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View listItemView, ViewGroup parent){

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.word_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        name.setText(currentWord.getWord().toString());

        TextView definition = (TextView) listItemView.findViewById(R.id.definition);
        definition.setText(currentWord.getDefintion().toString());

        return listItemView;

    }

}
