package com.example.madlibs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WordActivity extends AppCompatActivity {
    Story retrievedStory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_word);

        if (savedInstanceState != null) {
            retrievedStory = (Story) savedInstanceState.getSerializable("retrievedStory");
        }
        else{
            Intent intent = getIntent();
            retrievedStory = (Story) intent.getSerializableExtra("sendStory");
        }

        EditText editText = (EditText) findViewById(R.id.editText3);
        editText.setHint(retrievedStory.getNextPlaceholder());

        TextView textView2 = (TextView) findViewById(R.id.textView5);
        textView2.setHint(retrievedStory.getPlaceholderRemainingCount()+ "  word(s) left");
        }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("retrievedStory", retrievedStory);
    }

    public void checkClicked(View view) {
        TextView textView = (TextView) findViewById(R.id.textView6);
        textView.setVisibility(View.VISIBLE);

        EditText edit = (EditText)findViewById(R.id.editText3);
        String content = edit.getText().toString();
        retrievedStory.fillInPlaceholder(content);

        if (retrievedStory.getPlaceholderRemainingCount() != 0) {
            EditText editText = (EditText) findViewById(R.id.editText3);
            editText.setText("");
            editText.setHint(retrievedStory.getNextPlaceholder());
        }

        TextView textView2 = (TextView) findViewById(R.id.textView5);
        textView2.setHint(retrievedStory.getPlaceholderRemainingCount()+ "  word(s) left");

        // gebuik get next place holder  om de volgende place holder te krijgen
        // als button is clicked, voeg de text die opgeschreven is toe ana de placeholder
        // dmv fillInPlaceholder
        // als alle placeholder ingevuld zij dan naar volgende xml
        // als er op de button geklikt is laat dan het textveld zien

        //Button buttonClick = (Button) view;
        //buttonClick.setVisibility(View.VISIBLE);
        Intent intent = new Intent(WordActivity.this, TextStory.class);
        intent.putExtra("sendStory", retrievedStory);
        if (retrievedStory.isFilledIn()) {
            startActivity(intent);
        }

    }
}
