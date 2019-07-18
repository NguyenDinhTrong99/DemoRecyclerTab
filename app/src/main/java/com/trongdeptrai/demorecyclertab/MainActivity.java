package com.trongdeptrai.demorecyclertab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.trongdeptrai.demorecyclertab.Activity.RecyclerViewActivity;
import com.trongdeptrai.demorecyclertab.Activity.TabLayoutActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set title actionbar
        getSupportActionBar().setTitle("Main");
    }

    //hàm sử lí sự kiện onclick button ở file xml
    public void OnClickButtons(View v){
        Intent intent;
        if(v.getId() == R.id.btn_Recycler_View){
            intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
        }else if(v.getId() == R.id.btn_Tab_Layout){
            intent = new Intent(MainActivity.this, TabLayoutActivity.class);
            startActivity(intent);
        }
    }
}
