package com.example.part6_mission;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class Mission2Activity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    boolean isDrawerOpened;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mission2);

        toolbar=findViewById(R.id.mission2_toolbar);
        setSupportActionBar(toolbar);
//        기본 타이틀 보여주지 않겠다.
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawerLayout=findViewById(R.id.drawer);
        toggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                isDrawerOpened=true;
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                isDrawerOpened=false;
            }
        };
        drawerLayout.addDrawerListener(toggle);
//        뒤로가기 버튼 있다.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toggle.syncState();
    }

//    메뉴(토글) 클릭시
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
// 뒤로가기 눌렀을시
    @Override
    public void onBackPressed() {
        if (isDrawerOpened){
            drawerLayout.closeDrawers();
        }else {
            super.onBackPressed();
        }
    }
}