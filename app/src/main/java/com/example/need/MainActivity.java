package com.example.need;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;
    private long backPressedTime;
    private Toast backToast;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent homeIntent=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(homeIntent);
                    finish();
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText("আধুনিক উপায়ে কলা চাষ /n কলা বাংলাদেশের একটি গুরুত্বপূর্ণ ফল যা সারা বছর পাওয়া যায়। কলাকে প্রাচীন সাহিত্যে কদলি বলা হতো।\n" +
                            "\n" +
                            "কলাগাছ, কলাপাতা, কলাগাছের শিকড় ও কলা সবই উপকারী। কলাগাছ ও কলাপাতা শুধুমাত্র পশু খাদ্য নয়। এদের আছে আশ্চার্যজনক ভেষজ গুণ। রোগ নিরাময়ে অদ্বিতীয়। \n"+"কলার পুষ্টিগুণ প্রচুর। কলা উপাদেয় খাদ্য। কাঁচা পাকা দুই অবস্থায়ই খাওয়া যায়। কলায় রয়েছে জলীয় অংশ ৭০ গ্রাম, আঁশ ০.৫ গ্রাম, খাদ্য শক্তি (কিলোক্যালরি) ১০৯, আমিষ ০.৭ গ্রাম, চর্বি ০.৮ গ্রাম, শর্করা ২৫.০ গ্রাম, ক্যালসিয়াম ১১.০ মিলিগ্রাম, লৌহ ০.৯ মিলিগ্রাম, ভিটামিন সি ২৪ মিলিগ্রাম। নারিকেল ছাড়া আর কোনো খাদ্যেই কলার মতো খাদ্যশক্তি নেই। তাই যে কোনো সময় পরিশ্রান্তে অথবা শক্তিক্ষয়জনিত অবস্থায় কলা আহার করলে শরীর পুনরায় কর্মক্ষম হয়ে উঠবে। নারিকেলে ৩৫.৫৭ গ্রাম চর্বি থাকে। যদিও নারিকেলের শর্করা মাত্র ১০.২২ গ্রাম। নারিকেলে খাদ্য শক্তি ৩৭৬ কিলোক্যালরি। যা প্রচলিত ফলের মধ্যে সর্বোচ্চ। দৈনিক খাদ্য তালিকায় সুস্বাস্থ্যের জন্য প্রতিদিনের খাবারে অন্তত ৬০ গ্রাম ফলাদি থাকা বাঞ্ছনীয়। এ ক্ষেত্রে খাবারে আপনার পছন্দের যে কোনো কলা থাকতে পারে।");
                    //mTextMessage.setText(R.string.title_dashboard);
                    setTitle(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    setTitle(R.string.title_notifications);
                    return true;
                case R.id.navigation_notifications_complete:
                    mTextMessage.setText(R.string.title_notifications_completed);
                    setTitle(R.string.title_notifications_completed);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public void onBackPressed() {

        if (backPressedTime+2000>System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
        }
        else
        {
            backToast=Toast.makeText(getBaseContext(), "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime=System.currentTimeMillis();
    }

}
