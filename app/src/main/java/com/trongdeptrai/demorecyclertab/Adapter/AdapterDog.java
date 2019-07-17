package com.trongdeptrai.demorecyclertab.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.trongdeptrai.demorecyclertab.Interface.ItemTouchListener;
import com.trongdeptrai.demorecyclertab.Model.Dog;
import com.trongdeptrai.demorecyclertab.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class AdapterDog extends RecyclerView.Adapter<AdapterDog.ViewHolder> implements ItemTouchListener {
    private ArrayList<Dog> mDogList;
    private Context mContext;

    public AdapterDog(ArrayList<Dog> dogList, Context context) {
        this.mDogList = dogList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_dog,viewGroup,  false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Dog dog = mDogList.get(position);
        viewHolder.tv_NameDog.setText(dog.getmName());
        viewHolder.tv_AgeDog.setText(dog.getmAge());
    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }

    @Override
    public void onMove(int oldPosition, int newPosition) {
        if(oldPosition < newPosition){
            //nếu vị trí cũ nhỏ hơn vị trị mới - trên kéo xuống dươi
            for(int i = oldPosition; i < newPosition; i++){
                // cho i chạy từ vị trí nhấn giữ kéo cho tới vị trí thả
                Collections.swap(mDogList, i, i+1);
                // đổi vị trí cho nó - nghĩa là nó sẽ lấy vị trí đang đứng + 1
                //size sẽ tăng lên 1 để hoán đổi

            }
        }else {
            for(int i = oldPosition; i > newPosition; i--) {
                Collections.swap(mDogList, i, i-1);
            }
        }
        notifyItemMoved(oldPosition, newPosition);
    }

    @Override
    public void onSwipe(int position, int direction) {
        //sau khi swipe thành công
        mDogList.remove(position);
        notifyItemRemoved(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tv_NameDog, tv_AgeDog;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tv_NameDog = itemView.findViewById(R.id.text_Name_Dog);
            tv_AgeDog = itemView.findViewById(R.id.text_Age_Dog);
            //set magrin item view
            RecyclerView.LayoutParams pr = (RecyclerView.LayoutParams)itemView.getLayoutParams();
            pr.setMargins( 5, 15, 5,10 );
        }

        @Override
        public void onClick(View v) {
                mDogList.set(2, new Dog("rô", "8"));
                notifyDataSetChanged();
        }
    }

    public void refresh(){
       // notifyDataSetChanged();
        notifyItemInserted(mDogList.size()+1);

    }
}
