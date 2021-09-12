package com.example.studytest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SimpleTextAdapter extends RecyclerView.Adapter<SimpleTextAdapter.ViewHolder> {
    private ArrayList<String> mData;

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        Button button;

        ViewHolder(View itemView){
            super(itemView);

            textView = itemView.findViewById(R.id.textItem);
            button = itemView.findViewById(R.id.itemButton);
        }
    }

    SimpleTextAdapter() {
        mData = new ArrayList<>();
    }

    public void addItem(String item) {
        mData.add(item);
    }

    public void addItem(int position, String item) {
        mData.add(position, item);
    }

    public ArrayList<String> getArrayList() {
        return mData;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String text = mData.get(position);
        holder.textView.setText(text);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
