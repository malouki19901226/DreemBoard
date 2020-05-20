package com.example.dreemboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private ArrayList<ProfileItem> mProfileList;
    public MyAdapter(ArrayList<ProfileItem> profileList) {
        mProfileList = profileList;
    }

    /*public MyAdapter(Context ct, TextView s1, TextView s2, ImageView img) {
        context = ct;
        data1 = s1;
        data2 = s2;
        images = img;
    }*/
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_row, parent, false);
        MyViewHolder evh = new MyViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ProfileItem currentItem = mProfileList.get(position);
        holder.myImage.setImageResource(currentItem.getImageResource());
        holder.myText1.setText(currentItem.getText1());
        holder.myText2.setText(currentItem.getText2());

        //holder.myText1.setText(data1[position]);
        //holder.myText2.setText(data2[position]);
        //holder.myImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return mProfileList.size();
    }

    public class MyViewHolder extends  RecyclerView.ViewHolder {
        public TextView myText1, myText2;
        public ImageView myImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.nameTextView);
            myText2 = itemView.findViewById(R.id.descTextView);
            myImage = itemView.findViewById(R.id.imageView);
        }
    }
}
