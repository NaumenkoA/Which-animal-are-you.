package com.alexapps.whichanimalareyou.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alexapps.whichanimalareyou.R;

public class FinalActivity extends AppCompatActivity {
    private ImageView mAnimalImageView;
    private Button mNewGameButton;
    private TextView mMottoTextView;
    private ImageView mBubbleImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        mAnimalImageView = (ImageView) findViewById(R.id.animalImageView);
        mNewGameButton = (Button) findViewById(R.id.playAgainButton);
        mMottoTextView =  (TextView) findViewById(R.id.mottoTextView);
        mBubbleImage = (ImageView) findViewById(R.id.speakImageView);
        mNewGameButton.setVisibility(View.INVISIBLE);
        mBubbleImage.setVisibility(View.INVISIBLE);
        mMottoTextView.setVisibility(View.INVISIBLE);
        Intent intent = getIntent();
        String userMotto = intent.getStringExtra(getString(R.string.motto));
        int pictureId = intent.getIntExtra(getString(R.string.pictureId), 0);
        String animalName = "It seems you are a " + intent.getStringExtra(getString(R.string.animalName));
        mMottoTextView.setText(userMotto);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), pictureId, null);
        mAnimalImageView.setImageDrawable(drawable);
        Toast.makeText(FinalActivity.this, animalName, Toast.LENGTH_LONG).show();
        mBubbleImage.setVisibility(View.VISIBLE);
        mMottoTextView.setVisibility(View.VISIBLE);
        mNewGameButton.setVisibility(View.VISIBLE);
    }
}
