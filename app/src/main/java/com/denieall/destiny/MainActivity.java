package com.denieall.destiny;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView story_textview;
    Button option1, option2;

    int storyTrack = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        story_textview = findViewById(R.id.story_textView);
        option1 = findViewById(R.id.btn_option1);
        option2 = findViewById(R.id.btn_option2);

        if (savedInstanceState == null) {

            //Set text
            story_textview.setText(R.string.T1_Story);
            option1.setText(R.string.T1_Ans1);
            option2.setText(R.string.T1_Ans2);

        } else {

            storyTrack = savedInstanceState.getInt("tracker");
            story_textview.setText(savedInstanceState.getCharSequence("textview"));
            option1.setText(savedInstanceState.getCharSequence("btn1"));
            option2.setText(savedInstanceState.getCharSequence("btn2"));

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("tracker", storyTrack);
        outState.putCharSequence("textview", story_textview.getText());
        outState.putCharSequence("btn1", option1.getText());
        outState.putCharSequence("btn2", option2.getText());

    }

    public void option_clicked(View view) {
        if (view.getId() == R.id.btn_option1) {

            if (storyTrack == 1) {

                story_textview.setText(R.string.T3_Story);
                option1.setText(R.string.T3_Ans1);
                option2.setText(R.string.T3_Ans2);

                storyTrack = 2;

            } else if (storyTrack == 2) {

                story_textview.setText(R.string.T6_End);
                option1.setVisibility(View.GONE);
                option2.setVisibility(View.GONE);

            } else if (storyTrack == 3) {

                story_textview.setText(R.string.T3_Story);
                option1.setText(R.string.T3_Ans1);
                option2.setText(R.string.T3_Ans2);

                storyTrack = 2;

            }

        } else if (view.getId() == R.id.btn_option2) {

            if (storyTrack == 1) {

                story_textview.setText(R.string.T2_Story);
                option1.setText(R.string.T2_Ans1);
                option2.setText(R.string.T2_Ans2);

                storyTrack = 3;

            } else if (storyTrack == 2) {

                story_textview.setText(R.string.T5_End);
                option1.setVisibility(View.GONE);
                option2.setVisibility(View.GONE);

            } else if (storyTrack == 3) {

                story_textview.setText(R.string.T4_End);
                option1.setVisibility(View.GONE);
                option2.setVisibility(View.GONE);

            }
        }
    }
}
