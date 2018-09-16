package com.mann.healthmaster;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    Button optionA;
    Button optionB;
    Button optionC;
    Button optionD;
    Button skip;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        optionA=(Button) findViewById(R.id.optionA);
        optionB=(Button) findViewById(R.id.optionB);
        optionC=(Button) findViewById(R.id.optionC);
        optionD=(Button) findViewById(R.id.optionD);
        skip=(Button) findViewById(R.id.skip);
        message=findViewById(R.id.message);
        optionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                optionA.setBackgroundColor(Color.GREEN);
                optionB.setBackgroundColor(Color.RED);
                optionC.setBackgroundColor(Color.RED);
                optionD.setBackgroundColor(Color.RED);
                message.setText("Your Answer is Correct. ***NO MORE QUESTIONS***. Contact to Admin");
                message.setTextColor(Color.GREEN);


            }
        });
        optionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                optionA.setBackgroundColor(Color.GREEN);
                optionB.setBackgroundColor(Color.RED);
                optionC.setBackgroundColor(Color.RED);
                optionD.setBackgroundColor(Color.RED);
                message.setText("Your Answer is **WRONG**.    ***NO MORE QUESTIONS***. Contact to Admin");

                message.setTextColor(Color.RED);


            }
        });
        optionC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setTextColor(Color.RED);
                optionA.setBackgroundColor(Color.GREEN);
                optionB.setBackgroundColor(Color.RED);
                optionC.setBackgroundColor(Color.RED);
                optionD.setBackgroundColor(Color.RED);
                        optionA.setBackgroundColor(Color.RED);
                        message.setText("Your Answer is **WRONG**.    ***NO MORE QUESTIONS***. Contact to Admin");

            }
        });
        optionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                optionA.setBackgroundColor(Color.GREEN);
                optionB.setBackgroundColor(Color.RED);
                optionC.setBackgroundColor(Color.RED);
                optionD.setBackgroundColor(Color.RED);
                message.setText("Your Answer is **WRONG**.    ***NO MORE QUESTIONS***. Contact to Admin");
                message.setTextColor(Color.RED);
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                message.setText("*** NO MORE QUESTIONS ***. Contact to Admin");
                message.setTextColor(Color.RED);
            }
        });


    }

}
