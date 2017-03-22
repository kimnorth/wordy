package com.codeclan.wordyapp;

import android.widget.TextView;

/**
 * Created by user on 21/03/2017.
 */

public class TextViewObjects {

    int id;
    TextView textView;


    public TextViewObjects(int id, TextView textView){

        this.id = id;
        this.textView = textView;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }



}


