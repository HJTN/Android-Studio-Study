package com.example.englishwordapp.handlers;

import com.example.englishwordapp.dtos.DtoWords;

import java.util.ArrayList;

public interface GetWordsCallBack {
    void handle(ArrayList<DtoWords> result);
}
