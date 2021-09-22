package com.example.englishwordapp.utils;

import androidx.annotation.NonNull;

import com.example.englishwordapp.dtos.DtoWords;
import com.example.englishwordapp.enums.WordSheetNames;
import com.example.englishwordapp.handlers.GetWordsCallBack;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class FirebaseWordsUtils {
    private static final String SHEET_PATH = "1o7gzgF_q6TBHRxSz_AzG6yjjLV9Q1vWVqY8gzaLB-yM";

    private static final String NUMS = "nums", ENGLISH = "English", KOREAN = "Korean";

    private static final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private static final DatabaseReference databaseReference = firebaseDatabase.getReference();

    public static void getWord(String WordSheet, GetWordsCallBack handler) {
        databaseReference.child(SHEET_PATH).child(WordSheet).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<Map<String, Object>> result = (ArrayList<Map<String, Object>>) snapshot.getValue();
                handler.handle(parseWordsFromFirebase(result.size() == 0 ? new ArrayList<>(): result));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public static ArrayList<DtoWords> parseWordsFromFirebase(ArrayList<Map<String, Object>> inputs) {
        ArrayList<DtoWords> result = new ArrayList<>();

        for(int i = 0; i < inputs.size(); i++) {
            DtoWords Word = new DtoWords(
                    (String) inputs.get(i).get(ENGLISH),
                    (String) inputs.get(i).get(KOREAN),
                    (Long) inputs.get(i).get(NUMS)
            );
            result.add(Word);
        }

        return result;
    }
}
