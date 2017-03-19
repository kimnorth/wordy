package com.codeclan.wordyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button learnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    learnButton = (Button)findViewById(R.id.learn_button);

    }

    public void onClickLearnButton(View button){
        Log.d(getClass().toString(), "Button was clicked");
        Intent intent = new Intent(this, MemoryGameActivity.class);
        startActivity(intent);
    }
}
