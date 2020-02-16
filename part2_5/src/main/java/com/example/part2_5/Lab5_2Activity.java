package com.example.part2_5;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Lab5_2Activity extends AppCompatActivity implements View.OnClickListener{

    Button alertd,listd,prd,dated,timed,coud;

    AlertDialog alertDialog;
    AlertDialog customDialog;
    AlertDialog listDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_2);

        alertd=(Button)findViewById(R.id.alertd);
        listd=(Button)findViewById(R.id.listd);
        prd=(Button)findViewById(R.id.progressd);
        dated=(Button)findViewById(R.id.dated);
        timed=(Button)findViewById(R.id.timed);
        coud=(Button)findViewById(R.id.customd);

        alertd.setOnClickListener(this);
        listd.setOnClickListener(this);
        prd.setOnClickListener(this);
        dated.setOnClickListener(this);
        timed.setOnClickListener(this);
        coud.setOnClickListener(this);
    }

    private void showToast(String message){
        Toast t=Toast.makeText(this, message, Toast.LENGTH_SHORT);
        t.show();
    }

    DialogInterface.OnClickListener dialogListener=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            if (dialogInterface==customDialog && i==DialogInterface.BUTTON_POSITIVE){
                showToast("custom dialog 확인 click...");
            } else if (dialogInterface==listDialog){
                String[] datas=getResources().getStringArray(R.array.dialog_array);
                showToast(datas[i]+"선택 하셨습니다.");
            } else if (dialogInterface==alertDialog && i==DialogInterface.BUTTON_POSITIVE){
                showToast("alert dialog ok cliick...");
            }
        }
    };


    @Override
    public void onClick(View v){
        if (v==alertd){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setIcon(android.R.drawable.ic_dialog_alert);	//제목 옆에 붙을 이미지
            builder.setTitle("알림");			//제목
            builder.setMessage("정말 종료 하시겠습니까?");		//내용
            builder.setPositiveButton("OK",dialogListener);		//버튼
            builder.setNegativeButton("NO",null);   //이벤트 핸들러 없음
            alertDialog=builder.create();			//다이얼로그 제작
            alertDialog.show();
        } else if (v==listd){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            builder.setTitle("알람 벨소리");
            builder.setSingleChoiceItems(R.array.dialog_array, 0, dialogListener);
            builder.setPositiveButton("확인", null);
            builder.setNegativeButton("취소", null);
            listDialog=builder.create();
            listDialog.show();

        } else if (v==prd){
            ProgressDialog progressDialog=new ProgressDialog(this);
            progressDialog.setIcon(android.R.drawable.ic_dialog_alert);
            progressDialog.setTitle("wait");
            progressDialog.setMessage("잠시만 ㅣ다려");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setIndeterminate(true);
            progressDialog.show();

        } else if (v==dated){
            Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day=c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dateDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    showToast(year+":"+(month+1)+":"+day);
                }
            },year, month, day);
            dateDialog.show();
        } else if (v==timed){
            Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            TimePickerDialog timeDialog= new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hour, int minute) {
                    showToast(hour+":"+minute);
                }
            }, hour, minute, false);
            timeDialog.show();
        } else if (v==coud){
            AlertDialog.Builder builder=new AlertDialog.Builder(this);
            LayoutInflater inflater=(LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
            View view=inflater.inflate(R.layout.dialog_layout, null);
            builder.setView(view);

            builder.setPositiveButton("확인", dialogListener);
            builder.setNegativeButton("취소", null);

            customDialog=builder.create();
            customDialog.show();

        }

    }
}
