package ru.qotofey.android.characterrecognition.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.qotofey.android.characterrecognition.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        App.getComponent().inject(this);
        setContentView(R.layout.activity_main);
    }
}

