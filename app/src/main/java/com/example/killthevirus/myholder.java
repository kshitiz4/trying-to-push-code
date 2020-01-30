package com.example.killthevirus;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myholder extends RecyclerView.ViewHolder implements View.OnClickListener
{
    ImageView mImageView;
    TextView mTitle,mDes;
    ItemClickListner itemClickListner;


    myholder(@NonNull View itemView) {
        super(itemView);
        this.mImageView=itemView.findViewById(R.id.imageIv);
        this.mTitle=itemView.findViewById(R.id.titleTv);
        this.mDes=itemView.findViewById(R.id.descriptionTv);

  itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        this.itemClickListner.onItemClickListner(v,getLayoutPosition());
    }
    public void setItemClickListner(ItemClickListner ic){
        this.itemClickListner=ic;
    }
}
