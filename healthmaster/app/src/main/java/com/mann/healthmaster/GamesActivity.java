package com.mann.healthmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GamesActivity extends AppCompatActivity {

    public static String TYPE = "gameType";
    public static String TYPE_MINDGAME = "mind";
    public static String TYPE_ENVIRONMENTGAME = "env";
    public static String TYPE_PHYSICALGAME = "phy";
    public static String TYPE_LOGICALGAME = "logical";

    ListView listview;
    String game1[] = {"Quiz","Vocab","Word Link"};
    String game2[] = {"Plant a Tree","Water a Plant"};
    String game3[] = {"Walking","Running","Cricket","Badminton","Football"};
    String game4[] = {"CandyCrush","Find Unique Object","Hit the same object"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        String data[] = null;
        int itype=-1;

        String type = getIntent().getStringExtra(TYPE);
        if(type.equals(TYPE_MINDGAME)) {
            data=game1;
            itype=0;
        } else if(type.equals(TYPE_ENVIRONMENTGAME)) {
            data=game2;
            itype=1;

        } else if(type.equals(TYPE_PHYSICALGAME)) {
            data=game3;
            itype=2;

        } else if(type.equals(TYPE_LOGICALGAME)) {
            data=game4;
            itype=3;
        }

        final int mytype = itype;
        listview = (ListView)findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        listview.setAdapter(arrayAdapter);

            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



                if(position==0){
                    if(mytype==0) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game1[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==1) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game2[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==2) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game3[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }

                }else if(position==1){
                    if(mytype==0) {
                        Intent intent = new Intent(getApplicationContext(), EnvironmentActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game2[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==1) {
                        Intent intent = new Intent(getApplicationContext(), EnvironmentActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game2[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }

                }else if(position==2){
                    if(mytype==0) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game1[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==1) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game2[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==2) {

                        Toast.makeText(getApplicationContext(), game3[position] + " is Locked, First Complete the above Task", Toast.LENGTH_SHORT).show();
                    }else if(mytype==3) {

                        Toast.makeText(getApplicationContext(), game4[position] + " is Locked, First Complete the above Task", Toast.LENGTH_SHORT).show();
                    }
                }else if(position==3){
                    if(mytype==0) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game1[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==1) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game2[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }else if(mytype==2) {
                        Intent intent = new Intent(getApplicationContext(), QuizActivity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(), game3[position] + " is Selected", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });
    }






    }

