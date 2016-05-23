package com.example.yeasangkug.vocabulary.DTO;

/**
 * Created by yeasangkug on 2016. 5. 23..
 */
public class Item_Word {

    private String mWord;
    private String mMean;

    public Item_Word(String mWord, String mMean)
    {
        this.mWord = mWord;
        this.mMean = mMean;
    }

    public String getmWord() {
        return mWord;
    }

    public void setmWord(String mWord) {
        this.mWord = mWord;
    }

    public String getmMean() {
        return mMean;
    }

    public void setmMean(String mMean) {
        this.mMean = mMean;
    }
}
