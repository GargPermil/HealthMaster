package com.mann.healthmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main2Activity extends AppCompatActivity {

    ImageView task;
    ImageView home;
    ImageView freeze;
    ImageView market;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final TextView level = findViewById(R.id.textView3);
        final TextView gold = findViewById(R.id.textView5);
        final TextView gems = findViewById(R.id.textView6);



        String url = config.URL + "playerDetails";
        final String TAG = "main2Activity";

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());
                try {
                    JSONObject t = (JSONObject) response.get(0);
                    level.setText(t.getInt("lvlexperience")+"");
                    gold.setText(t.getInt("Gold")+"");
                    gems.setText(t.getInt("Gems")+"");
                    t.getInt("energy");
                    t.getInt("power");
                    t.getInt("MuscleHealth");
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                //hidepDialog();
            }
        });

        AppController.getInstance().addToRequestQueue(jsonObjReq);

        task=(ImageView) findViewById(R.id.task);
        home=(ImageView) findViewById(R.id.home);
        freeze=(ImageView) findViewById(R.id.freeze);
        market=(ImageView) findViewById(R.id.market);

        task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TaskActivity.class);
                startActivity(intent);

            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TudoWarActivity.class);
                startActivity(intent);

            }
        });


        freeze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                freeze.setImageResource(R.drawable.openfreeze);
                Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_SHORT).show();


            }
        });

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MarketActivity.class);
                startActivity(intent);

            }
        });


    }
}
