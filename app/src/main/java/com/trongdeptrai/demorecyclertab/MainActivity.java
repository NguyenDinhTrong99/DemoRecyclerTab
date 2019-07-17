package com.trongdeptrai.demorecyclertab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.trongdeptrai.demorecyclertab.Activity.RecyclerViewActivity;
import com.trongdeptrai.demorecyclertab.Activity.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {
    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set title actionbar
        getSupportActionBar().setTitle("Main");
    }

    //hàm sử lí sự kiện onclick button ở file xml
    public void OnClickButtons(View v){
        if(v.getId() == R.id.btn_Recycler_View){
                mIntent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(mIntent);
        }else if(v.getId() == R.id.btn_Tab_Layout){
            mIntent = new Intent(MainActivity.this, TabLayoutActivity.class);
            startActivity(mIntent);
        }
    }
}
