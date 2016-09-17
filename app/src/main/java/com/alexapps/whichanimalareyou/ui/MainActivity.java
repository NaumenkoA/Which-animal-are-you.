package com.alexapps.whichanimalareyou.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alexapps.whichanimalareyou.R;

public class MainActivity extends AppCompatActivity {
    private EditText mPhraseField;
    private Button mStartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhraseField = (EditText) findViewById(R.id.phraseText);
        mStartButton = (Button) findViewById(R.id.startButton);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String phrase = mPhraseField.getText().toString();
                if (phrase.equals("")) {
                    Toast.makeText(MainActivity.this,"Enter your motto first!", Toast.LENGTH_SHORT ).show();
                                   }
                else startQuestions();
        }
    });
   }
    private void startQuestions(){
        Intent intent = new Intent(this, StatementActivity.class);
        startActivity(intent);
    }
}
