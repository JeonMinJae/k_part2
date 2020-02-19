package com.example.part3_mission;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText nameView;
    EditText phoneView;
    EditText emailView;
    Button addBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameView=(EditText)findViewById(R.id.edit_name);
        phoneView=(EditText)findViewById(R.id.edit_phone);
        emailView=(EditText)findViewById(R.id.edit_email);

        addBtn=(Button)findViewById(R.id.btn_add);
        addBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==addBtn){
            String name=nameView.getText().toString();
            String phone=phoneView.getText().toString();
            String email=emailView.getText().toString();

            if (name==null || name.equals("")){
                Toast t=Toast.makeText(this, "이름이 입력되지 않았습니다.", Toast.LENGTH_SHORT);
                t.show();
            }else {
                DBHelper helper=new DBHelper(this);
                SQLiteDatabase db=helper.getWritableDatabase();
                db.execSQL("insert into tb_contact (name, phone, email) values(?,?,?)",
                        new String[]{name, phone, email});
                db.close();

                Toast t= Toast.makeText(this, "새로운 주소록이 등록되었습니다", Toast.LENGTH_SHORT);
                t.show();

                Intent intent= new Intent(this, ResultActivity.class);
                startActivity(intent);
            }
        }
    }
}
