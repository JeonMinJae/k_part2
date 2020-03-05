package com.example.part4_mission;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DriveAdapter extends ArrayAdapter<DriveVO> {
    Context context;
    int resId;
    ArrayList<DriveVO> datas;

    public DriveAdapter(Context context, int resId, ArrayList<DriveVO> datas){
        super(context, resId);
        this.context=context;
        this.resId=resId;
        this.datas=datas;
    }

    @Override
    public int getCount(){
        return datas.size();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView==null){
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(resId, null);
            DriveHolder holder=new DriveHolder(convertView);
            convertView.setTag(holder);
        }
        DriveHolder holder=(DriveHolder)convertView.getTag();

        ImageView typeImageView=holder.typeImageView;
        TextView nameView=holder.nameView;
        TextView dateView=holder.dateView;
        ImageView phoneImageView=holder.phoneImageView;

        final DriveVO vo=datas.get(position);

        nameView.setText(vo.name);
        dateView.setText(vo.date);

        if (vo.type.equals("yes") && vo.type !=null){
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.hong, null));
        } else {
            typeImageView.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_person, null));
        }

        if (vo.phone != null && !vo.phone.equals("")){
            phoneImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+vo.phone));
                    context.startActivity(intent);
                }
            });
        }

        return convertView;
    }

}
