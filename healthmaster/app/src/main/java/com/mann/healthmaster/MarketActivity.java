package com.mann.healthmaster;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.mann.healthmaster.Modal.marketfood;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MarketActivity extends AppCompatActivity {

    ListView listview;
//    String foodList[] = {"Egg  (Price=3 GOLD)",  "Soft Drinks  (Price=2 GOLD)", "Pizza (Price=5 GOLD)", "Milk  (Price=3 GOLD)", "Soyabean (Price=4 GOLD)", "Chicken  (Price=6 GOLD) " ,"Fried Chicken (Price= GOLD) ", "Carrot  (Price=2 GOLD)","Tomato  (Price=2 GOLD) ","Green Vegetable  (Price=3 GOLD)","Banana  (Price=8 GOLD)","Curd   (Price=2 GOLD)","Burger  (Price=4 GOLD)","Water   (Price=1 GOLD)","Hard Drink (Price=2 GOLD)","Smoke  (Price=1 GOLD)"};
    ArrayList<marketfood> foodList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);

        String url = config.URL + "marketDetails";
        final String TAG = "marketconn";

        JsonArrayRequest jsonObjReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, response.toString());

                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject item = (JSONObject) response.get(i);
                        foodList.add(new marketfood(item.getInt("mid"),
                                item.getInt("foodid"),item.getString("name"),
                                item.getInt("sellprice"),item.getInt("sellerid")));
                    }

                    ArrayList<String> d = new ArrayList<>();
                    for (marketfood s : foodList) {
                        d.add(s.name + " :       " + s.sellprice + " Gold");
                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, d);

                    listview.setAdapter(arrayAdapter);
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

        listview = (ListView)findViewById(R.id.listview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /*
                if(position==0){



                }else if(position==1){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();


                }else if(position==2){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                }else if(position==3){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                }else if(position==3){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();


                }else if(position==4){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                }else if(position==5){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                }else if(position==6){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();


                }else if(position==7){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                }else if(position==8){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                } else if(position==9){
                Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();


                 }else if(position==10){
                    Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                 }else if(position==11){
                      Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                 }else if(position==12){
                Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();


                }else if(position==13){
                     Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                 }else if(position==14){
                      Toast.makeText(getApplicationContext(), foodList[position] + " is Purchased Sucessfully", Toast.LENGTH_SHORT).show();

                 }

*/

        }
        });
    }






}

