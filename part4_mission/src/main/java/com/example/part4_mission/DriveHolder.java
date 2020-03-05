package com.example.part4_mission;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

//여러번 불러오는걸 방지하기위해 holder를 하나 만들었다.
public class DriveHolder {
    public ImageView typeImageView;
    public TextView nameView;
    public TextView dateView;
    public ImageView phoneImageView;

    public DriveHolder(View v){
        typeImageView=(ImageView)v.findViewById(R.id.profile_img);
        nameView=(TextView)v.findViewById(R.id.profile_name);
        dateView=(TextView)v.findViewById(R.id.profile_st);
        phoneImageView=(ImageView)v.findViewById(R.id.phone_img);
    }
}
