package com.example.killthevirus;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<myholder> {

    Context c;
    ArrayList<model>models;//this array list create a list of array which parameters define in our model class


    //now create a paramaterized constructor

    public MyAdapter(Context c, ArrayList<model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row,null);//this line inflate our row
        return new myholder(view);//this will return our view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull final myholder myholder, int i) {
        myholder.mTitle.setText(models.get(i).getTitle());//here i is position
        myholder.mDes.setText(models.get(i).getDescription());
        myholder.mImageView.setImageResource(models.get(i).getImg());//here we used image because we will use image in ourresource folder which is drawable

        //this method is when we want to use one activity
        myholder.setItemClickListner(new ItemClickListner() {
            @Override
            public void onItemClickListner(View v, int position) {
                String gTitle=models.get(position).getTitle();
                String gDesk=models.get(position).getDescription();//these object get our data from previous activity
                BitmapDrawable bitmapDrawable=(BitmapDrawable)myholder.mImageView.getDrawable();//this wil get our image from drawable
                Bitmap bitmap=bitmapDrawable.getBitmap();
                ByteArrayOutputStream stream=new ByteArrayOutputStream();//image will get stream and bytes
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);//it will compress our image
                byte[] bytes=stream.toByteArray();
                //get our data with intent
                Intent intent=new Intent(c,anotheractivity.class);
                intent.putExtra("iTitle",gTitle);
                intent.putExtra("iDesc",gDesk);//get data and put in intent
                intent.putExtra("iImage",bytes);
                c.startActivity(intent);
            }
        });
        //if we want to use different activities than we can use different logic
      //myholder.setItemClickListner(new ItemClickListner() {
        //    @Override
          //  public void onItemClickListner(View v, int position) {
            //    if(models.get(position).getTitle().equals("Facebook")) {
                    //than you can move another activity from if body
              //  }
                //if(models.get(position).getTitle().equals("Watsapp")) {
                    //than you can move another activity from if body
                //}
                //if(models.get(position).getTitle().equals("youtube")) {
                    //than you can move another activity from if body
                //}
                //if(models.get(position).getTitle().equals("Spotify")) {
                    //than you can move another activity from if body
                //}

            //}
        //});
        //but still we are using one activity so
    }

    @Override
    public int getItemCount() {


        return models.size();
    }
}
