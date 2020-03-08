package com.example.part5_14;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> datas;

    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView)findViewById(R.id.main_list);
        listView.setOnItemClickListener(this);

        DBHelper helper =new DBHelper(this);
        SQLiteDatabase db= helper.getWritableDatabase();
        Cursor cursor= db.rawQuery("select location from tb_data where category='0'",null);
        datas=new ArrayList<>();
        while (cursor.moveToNext()){
            datas.add(cursor.getString(0));
        }
        db.close();

        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datas);
        listView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        TextView textView=(TextView)view;
        category=textView.getText().toString();
        Intent intent=new Intent(this, DetailActivity.class);
        intent.putExtra("category", category);
        startActivityForResult(intent,10);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode==10 && resultCode==RESULT_OK){
            String location= data.getStringExtra("location");

            Toast t= Toast.makeText(this, category+":"+location, Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
