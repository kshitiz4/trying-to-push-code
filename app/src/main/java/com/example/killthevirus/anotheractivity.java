package com.example.killthevirus;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class anotheractivity extends AppCompatActivity {
    TextView mTitleTv,mdescTv;
    ImageView mImageIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotheractivity);
        //in this activity we will use back button
        ActionBar actionBar=getSupportActionBar();
     mTitleTv=findViewById(R.id.title);
     mdescTv=findViewById(R.id.description);
     mImageIv=findViewById(R.id.imageView);
     //now get our data from intent in which we put our data
        Intent intent=getIntent();
        String mTitle=intent.getStringExtra("iTitle");
        String mDescription=intent.getStringExtra("iDesc");
        byte[] mBytes=getIntent().getByteArrayExtra("iImage");
        //now decode image because from previous activity we get our image in bytes
        Bitmap bitmap= BitmapFactory.decodeByteArray(mBytes,0,mBytes.length);
        actionBar.setTitle(mTitle);//which title we get from previous activity that will set in our action bar
        //now set our data in our view,which we get in our previous activity
        mTitleTv.setText(mTitle);
        mdescTv.setText(mDescription);
        mImageIv.setImageBitmap(bitmap);
    }
}
