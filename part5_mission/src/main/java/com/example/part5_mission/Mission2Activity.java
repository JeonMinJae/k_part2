package com.example.part5_mission;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Mission2Activity extends AppCompatActivity implements View.OnClickListener{

    ImageView call;
    ImageView location;
    ImageView internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);

        call=(ImageView)findViewById(R.id.mission2_call);
        location=(ImageView)findViewById(R.id.mission2_location);
        internet=(ImageView)findViewById(R.id.mission2_internet);

        call.setOnClickListener(this);
        location.setOnClickListener(this);
        internet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view==call){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-120"));
                startActivity(intent);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},100);
            }
        } else if (view==location){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.5662952,126.9779451?q=37.5662952,126.9779451"));
            startActivity(intent);

        } else if (view==internet){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://naver.com"));
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0){
            if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:02-120"));
                startActivity(intent);
            }else {
                Toast toast=Toast.makeText(this, "no permission", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
