package com.example.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.io.InputStream;


public class MainActivity extends AppCompatActivity {
    Story story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

    public void checkClicked(View view) {
        Intent intent = new Intent(MainActivity.this, WordActivity.class);

        Button button = (Button) view;
        String name_text = button.getText().toString();

        InputStream stream = null;
        switch(name_text) {
             case "Simple":
                 stream = getResources().openRawResource(R.raw.madlib_simple);
                 break;
             case "Clothes":
                 stream = getResources().openRawResource(R.raw.madlib_clothes);
                 break;
             case "Dance":
                 stream = getResources().openRawResource(R.raw.madlib_dance);
                 break;
             case "Tarzan":
                 stream = getResources().openRawResource(R.raw.madlib_tarzan);
                 break;
             case "University":
                 stream = getResources().openRawResource(R.raw.madlib_university);
                 break;
             default:
                 Log.d("switch", "checkClicked: default");
                 stream = getResources().openRawResource(R.raw.madlib_simple);
        }
        story = new Story(stream);
        intent.putExtra("sendStory", story);
        startActivity(intent);
    }


}
