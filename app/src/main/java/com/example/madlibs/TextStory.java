package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TextStory extends AppCompatActivity {
    Story retrievedStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_story);

        Intent intent = getIntent();
        retrievedStory = (Story) intent.getSerializableExtra("sendStory");

        TextView textElement = (TextView) findViewById(R.id.textView4);
        textElement.setText(retrievedStory.toString());
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(TextStory.this, MainActivity.class);
        retrievedStory.clear();
        startActivity(intent);

    }

    public void resetClicked(View view) {
        Intent intent = new Intent(TextStory.this, MainActivity.class);
        retrievedStory.clear();
        startActivity(intent);
    }
}
