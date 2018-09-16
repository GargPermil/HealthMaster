package com.mann.healthmaster;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EnvironmentActivity extends AppCompatActivity {

    Button btnGal;
    ImageView ivGalImg;
    Bitmap bmp;
    TextView textView9;


    Button upload_plant;
    Button upload_watering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_environment);

        ivGalImg=findViewById(R.id.env_img);
        upload_plant=findViewById(R.id.upload_plant);
        upload_watering=findViewById(R.id.upload_watering);
        textView9=findViewById(R.id.textView9);


        btnGal = (Button)findViewById(R.id.select);


        upload_plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your New Plant Picture is sucessfully Uploaded.",Toast.LENGTH_LONG).show();
            }
        });

        upload_watering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your Watering Plant Picture is sucessfully Uploaded,",Toast.LENGTH_LONG).show();
            }
        });

        btnGal.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                openGallery();
            }
        });
    }

    private void openGallery()
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent intent)
    {
        super.onActivityResult(requestCode, resultcode, intent);

        if (requestCode == 1)
        {
            if (intent != null && resultcode == RESULT_OK)
            {

                Uri selectedImage = intent.getData();

                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String filePath = cursor.getString(columnIndex);
                cursor.close();

                if(bmp != null && !bmp.isRecycled())
                {
                    bmp = null;
                }

                bmp = BitmapFactory.decodeFile(filePath);
                ivGalImg.setBackgroundResource(0);
                ivGalImg.setImageBitmap(bmp);
                upload_plant.setEnabled(true);
                upload_watering.setEnabled(true);
                textView9.setText("Image is sucessfully selected.This image will not show here due to privacy reason. click on UPOAD BUTTON");
                textView9.setTextColor(this.getResources().getColor(R.color.red));
            }
            else
            {
                Log.d("Status:", "Photopicker canceled");
            }
        }
    }
}