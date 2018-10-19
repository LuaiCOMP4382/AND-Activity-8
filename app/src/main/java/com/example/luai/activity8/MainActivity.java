package com.example.luai.activity8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openLink0(View view) {
        openVideo(0);
    }

    public void openLink1(View view) {
        openVideo(1);
    }

    public void openLink2(View view) {
        openVideo(2);
    }

    public void openVideo(int index) {

        Intent i = new Intent(this, VideoActivity.class);

        i.putExtra("index", index);

        startActivity(i);

    }

}
