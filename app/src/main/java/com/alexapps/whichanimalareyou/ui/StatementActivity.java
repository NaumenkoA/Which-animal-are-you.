package com.alexapps.whichanimalareyou.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.alexapps.whichanimalareyou.R;
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
        Prompter prompter = new Prompter();
        mStatementTextView.setText(prompter.askQuestion().getStatement());
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
