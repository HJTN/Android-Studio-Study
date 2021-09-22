package com.example.englishwordapp.utils;

import android.content.Context;

import com.example.englishwordapp.dtos.DtoUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class FirebaseUserDataUtils {
    private static final String USER_PATH = "data-source/users";

    private static final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private static final DatabaseReference postsReference = firebaseDatabase.getReference(USER_PATH);

    public static void setPost(Integer userId, DtoUser dtoUser) {
        postsReference.child(userId+"").setValue(dtoUser);
    }

    public static void getPost(Integer userId, Context context) {
        // get data from Firebase...
    }
}
