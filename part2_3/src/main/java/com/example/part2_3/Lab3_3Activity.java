package com.example.part2_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lab3_3Activity extends AppCompatActivity {

    Button trueB;
    Button falseB;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_3);

        //객체 획득
        trueB=(Button)findViewById(R.id.button3);
        text=(TextView)findViewById(R.id.textView);
        falseB = (Button)findViewById(R.id.button4);

        trueB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view==trueB){
                    text.setVisibility(View.VISIBLE);
                }
            }
        });

        falseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view==falseB){
                    text.setVisibility(View.INVISIBLE);

                }
            }
        });
    }

}
