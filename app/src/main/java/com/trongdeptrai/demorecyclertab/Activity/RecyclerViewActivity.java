package com.trongdeptrai.demorecyclertab.Activity;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.trongdeptrai.demorecyclertab.Adapter.DogAdapter;
import com.trongdeptrai.demorecyclertab.Interface.ItemTouchHelperCallBack;
import com.trongdeptrai.demorecyclertab.Interface.ItemTouchListener;
import com.trongdeptrai.demorecyclertab.Model.Dog;
import com.trongdeptrai.demorecyclertab.R;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity{
    private RecyclerView mRecyclerView;
    private DogAdapter adapter;
    private ArrayList<Dog> mDogList;
    private ItemTouchHelper.Callback callback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        //set title actionbar
        getSupportActionBar().setTitle("Recycler View");
        callback = new ItemTouchHelperCallBack(new ItemTouchListener() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                adapter.onMove(oldPosition, newPosition);
            }
            @Override
            public void onSwipe(int position, int direction) {
                adapter.onSwipe(position, direction);
            }
        });
        initView();
    }

    // thêm menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_recycler_view, menu);
        return super.onCreateOptionsMenu(menu);
    }
    // bắt sự kiện item của menu

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_add_dog){
            DialogNewDog();
        }
        return super.onOptionsItemSelected(item);
    }



    private void initView() {
        mDogList = new ArrayList<>();
        //thêm dữ liệu mặc định cho mảng
        initData();
        adapter = new DogAdapter(mDogList);
        mRecyclerView = findViewById(R.id.recyclerDog);
        // định dạng lại kích thước layout
        mRecyclerView.setHasFixedSize(true);
        // định dạng bố cục cho recycler - hiển thị theo chiều dọc
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL, false));
        //sét adpater cho recyclerview
        mRecyclerView.setAdapter(adapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);
    }

    private void initData() {
        mDogList.add(new Dog("Husky", "3"));
        mDogList.add(new Dog("Chó Lát", "4"));
        mDogList.add(new Dog("Chó Cái", "5"));
        mDogList.add(new Dog("Chó Dại", "7"));
        mDogList.add(new Dog("Chó Ngáo Đá", "6"));
        mDogList.add(new Dog("Chó Cảnh Vụ", "9"));
        mDogList.add(new Dog("Chó Điên", "5.5"));
        mDogList.add(new Dog("Chó Của Tỷ Phú", "4"));
        mDogList.add(new Dog("Chó Con Của Mẹ Nó", "10.5"));
        mDogList.add(new Dog("Chó Là Chó", "3"));
        mDogList.add(new Dog("Chó Dog", "2"));
    }

    //hàm hiển thị dialog thêm chó
    private void DialogNewDog(){
        final Dialog dialog = new Dialog(this);
        //không hiện title
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        // nếu bấm bên ngoài dialog thì đóng dialog
        dialog.setCanceledOnTouchOutside(true);
        //set UI cho dialog
        dialog.setContentView(R.layout.dialog_add_dog);
        //set kích thước dialog
        // chiều rộng  chiều dài wrap theo kích thươc dialog
        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.CENTER;
        wlp.flags &= ~WindowManager.LayoutParams.FLAG_BLUR_BEHIND;
        window.setAttributes(wlp);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        // ánh xạ
        Button btn_Save, btn_Cancel;
        final EditText edt_Name, edt_Age;
        btn_Save = dialog.findViewById(R.id.btn_Save);
        btn_Cancel = dialog.findViewById(R.id.btn_Cancel);
        edt_Name = dialog.findViewById(R.id.edt_Name_Dog);
        edt_Age = dialog.findViewById(R.id.edt_Age_Dog);
        // bắt sự kiện button cancel
        btn_Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        //bắt sự kiện button save
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_Name.getText().toString();
                String age = edt_Age.getText().toString();
                if(age.isEmpty() || name.isEmpty()){
                    Toast.makeText(RecyclerViewActivity.this, "Vui lòng nhập dự liệu trước khi lưu!", Toast.LENGTH_SHORT).show();
                }else {
                    Dog dog = new Dog(name, age);
                    mDogList.add(dog);
                    adapter.refresh();
                    dialog.dismiss();
                    Toast.makeText(RecyclerViewActivity.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialog.show();
    }


}
