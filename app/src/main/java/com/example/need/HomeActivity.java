package com.example.need;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    ArrayList<String> numberlist=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        get_json();
    }
public void get_json()
{
    String json;
    try
    {
        InputStream inputStream=getAssets().open("data.json");
        int size= inputStream.available();
        byte [] buffer=new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        json=new String(buffer,"UTF-8");
        JSONArray jsonArray=new JSONArray(json);

        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject obj=jsonArray.getJSONObject(i);
            if (obj.getString("fruit").equals("Apple"))
            {
                numberlist.add(obj.getString("number"));
            }
        }
        Toast.makeText(getApplicationContext(), numberlist.toString(), Toast.LENGTH_SHORT).show();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
    catch (JSONException e)
    {
        e.printStackTrace();
    }

}
    @Override
    public void onBackPressed() {
        Intent mainIntent=new Intent(HomeActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
}
