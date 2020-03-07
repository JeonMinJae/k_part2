package com.example.part4_mission;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class Mission_2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener{

    SeekBar seekBar;
    MyCheckView myCheckView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission_2);

        seekBar=findViewById(R.id.seekbar);
        myCheckView=findViewById(R.id.customView);

        seekBar.setOnSeekBarChangeListener(this);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        myCheckView.setValue(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
