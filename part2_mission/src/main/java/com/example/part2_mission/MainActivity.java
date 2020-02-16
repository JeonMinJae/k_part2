package com.example.part2_mission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnok=(Button)findViewById(R.id.ok);
        btnok.setOnClickListener(this);
    }

    private void showToast(String message){
        Toast t=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

    @Override
    public void onClick(View v){
        if (v==btnok){
            showToast("ok button click~~~~");
        }
    }
}
