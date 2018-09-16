package com.mann.healthmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TaskActivity extends AppCompatActivity {


    Button mindGame;
    Button env;
    Button phy;
    Button logical;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        mindGame=(Button) findViewById(R.id.mindGame);
        env=(Button) findViewById(R.id.env);
        phy=(Button) findViewById(R.id.phy);
        logical=(Button) findViewById(R.id.logical);


        mindGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GamesActivity.class);
                intent.putExtra(GamesActivity.TYPE, GamesActivity.TYPE_MINDGAME);
                startActivity(intent);

            }
        });

        env.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), GamesActivity.class);
                intent.putExtra(GamesActivity.TYPE, GamesActivity.TYPE_ENVIRONMENTGAME);
                startActivity(intent);

            }
        });


        phy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), GamesActivity.class);
                intent.putExtra(GamesActivity.TYPE, GamesActivity.TYPE_PHYSICALGAME);
                startActivity(intent);

            }
        });

        logical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), GamesActivity.class);
                intent.putExtra(GamesActivity.TYPE, GamesActivity.TYPE_LOGICALGAME);
                startActivity(intent);

            }
        });


    }
}
