package com.example.englishwordapp.dtos;

import java.util.ArrayList;
import java.util.List;

public class DtoWords {
    private String English;
    private String Korean;
    private Long num;

    public DtoWords() {
    }
    public DtoWords(String english, String korean, Long num) {
        this.English = english;
        this.Korean = korean;
        this.num = num;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getKorean() {
        return Korean;
    }

    public void setKorean(String korean) {
        Korean = korean;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }
}
