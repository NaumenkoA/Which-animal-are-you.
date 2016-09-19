package com.alexapps.whichanimalareyou.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alexapps.whichanimalareyou.R;
import com.alexapps.whichanimalareyou.model.Animal;
import com.alexapps.whichanimalareyou.model.Prompter;
import com.alexapps.whichanimalareyou.model.Statement;

public class StatementActivity extends AppCompatActivity {
    private Spinner mSpinner;
    private Button mSubmitButton;
    private TextView mStatementTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);
        mSubmitButton = (Button) findViewById(R.id.submitButton);
        mStatementTextView = (TextView) findViewById(R.id.statementTextView);
        mSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.degrees_array,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);
        final Prompter prompter = new Prompter();
        mStatementTextView.setText(prompter.askQuestion());
        mSubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            if (mSpinner.getSelectedItemPosition() == 0) {
                Toast.makeText(StatementActivity.this, "Select your choice first!", Toast.LENGTH_SHORT).show();
            }
                else {
                int choiceNumber = mSpinner.getSelectedItemPosition();
                prompter.saveAnswer(choiceNumber);
                    if (prompter.isFinal()) {
                    Intent intent = getIntent();
                    String userMotto = intent.getStringExtra(getString(R.string.motto));
                    Animal animal = prompter.detectAnimal();
                    showAnimal(userMotto, animal.getAmimalName(),animal.getPictureId());
                }
                else {
                    mStatementTextView.setText(prompter.askQuestion());
                    mSpinner.setSelection(0);
                }
            }
            }
        });
    }
    public void showAnimal (String motto, String animalName, int pictureId) {
        Intent intent2 = new Intent(this, FinalActivity.class);
        intent2.putExtra(getString(R.string.motto), motto);
        intent2.putExtra(getString (R.string.animalName), animalName);
        intent2.putExtra(getString(R.string.pictureId), pictureId);
        startActivity(intent2);
    }
}
