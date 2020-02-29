package com.example.part4_11;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Lab11_3Activity extends AppCompatActivity {

    ProgressBar progress;
    SeekBar seek;
    Spinner spiner;
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab11_3);

        progress=(ProgressBar)findViewById(R.id.progressBar);
        seek=(SeekBar)findViewById(R.id.seekBar);
        spiner=(Spinner)findViewById(R.id.spinner);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        String[] datas=getResources().getStringArray(R.array.spinner_array);

        ArrayAdapter<String> aa=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,datas);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spiner.setAdapter(aa);

        String[] autoDatas=getResources().getStringArray(R.array.auto_array);
        ArrayAdapter<String> autoAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, autoDatas);

        autoCompleteTextView.setAdapter(autoAdapter);

        ProgressThread thread=new ProgressThread();
        thread.start();
    }

    class ProgressThread extends Thread{
        @Override
        public void run(){
            for (int i=0; i<10; i++){
                SystemClock.sleep(1000);
                progress.incrementProgressBy(10);
                progress.incrementProgressBy(15);
            }
        }
    }
}
