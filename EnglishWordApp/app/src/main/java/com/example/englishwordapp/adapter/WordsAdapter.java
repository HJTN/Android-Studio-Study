package com.example.englishwordapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.englishwordapp.R;
import com.example.englishwordapp.databinding.ItemRecyclerviewWordsBinding;
import com.example.englishwordapp.dtos.DtoWords;

import java.util.ArrayList;

public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.ViewHolder> {
    private ArrayList<DtoWords> Words;

    public WordsAdapter(ArrayList<DtoWords> words) {
        this.Words = words;
    }

    @NonNull
    @Override
    public WordsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_words, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsAdapter.ViewHolder holder, int position) {
        holder.setItem(Words.get(position));
    }

    @Override
    public int getItemCount() {
        return Words.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRecyclerviewWordsBinding binding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ItemRecyclerviewWordsBinding.bind(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // RecyclerView item 클릭 이벤트...
                }
            });
        }

        public void setItem(DtoWords word) {
            binding.TvEnglish.setText(word.getEnglish());
            binding.TvKorean.setText(word.getKorean());
        }
    }
}
