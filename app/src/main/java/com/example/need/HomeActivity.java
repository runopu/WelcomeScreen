package com.example.need;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }


    @Override
    public void onBackPressed() {
        Intent mainIntent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
    //    @Override
//    public void onBackPressed() {
//
//        if (backPressedTime+2000>System.currentTimeMillis())
//        {
//            backToast.cancel();
//            super.onBackPressed();
//        }
//        else
//        {
//            backToast=Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
//            backToast.show();
//        }
//        backPressedTime=System.currentTimeMillis();
//    }
}
