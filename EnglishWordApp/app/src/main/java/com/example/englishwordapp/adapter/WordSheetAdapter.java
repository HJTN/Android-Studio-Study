package com.example.englishwordapp.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishwordapp.R;
import com.example.englishwordapp.databinding.ItemRecyclerviewWordsheetBinding;
import com.example.englishwordapp.views.WordsActivity;

import java.util.ArrayList;

public class WordSheetAdapter extends RecyclerView.Adapter<WordSheetAdapter.ViewHolder> {
    private ArrayList<String> WordSheets;

    public WordSheetAdapter(ArrayList<String> wordSheets) {
        this.WordSheets = wordSheets;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_wordsheet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordSheetAdapter.ViewHolder holder, int position) {
        holder.setItem(WordSheets.get(position));
    }

    @Override
    public int getItemCount() {
        return WordSheets.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewWordsheetBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemRecyclerviewWordsheetBinding.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // RecyclerView Item 클릭 시 이벤트...
                    Intent intent = new Intent(v.getContext(), WordsActivity.class);
                    intent.putExtra("WordSheet", binding.itemRecyclerviewTV.getText().toString());
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    v.getContext().startActivity(intent);
                }
            });
        }

        public void setItem(String WordSheet) {
            binding.itemRecyclerviewTV.setText(WordSheet);
        }
    }
}
