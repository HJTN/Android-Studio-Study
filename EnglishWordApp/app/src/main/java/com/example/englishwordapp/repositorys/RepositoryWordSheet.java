package com.example.englishwordapp.repositorys;

import com.example.englishwordapp.enums.WordSheetNames;

import java.util.ArrayList;

public class RepositoryWordSheet {
    private static ArrayList<String> wordSheets;

    public RepositoryWordSheet() {
        ArrayList<String> sheets = new ArrayList<>();
        for(int i = 0; i < WordSheetNames.values().length; i++) {
            sheets.add(WordSheetNames.values()[i].name());
        }
        this.wordSheets = sheets;
    }

    public ArrayList<String> getWordSheets() {
        return wordSheets;
    }

    public void setWordSheets(ArrayList<String> wordSheets) {
        this.wordSheets = wordSheets;
    }
}
