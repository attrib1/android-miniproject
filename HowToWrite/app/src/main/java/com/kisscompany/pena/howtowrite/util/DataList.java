package com.kisscompany.pena.howtowrite.util;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;
import com.kisscompany.pena.howtowrite.R;

import java.util.ArrayList;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DataList {
    private ArrayList<Integer> dataImg = new ArrayList<Integer>();
    private ArrayList<String> dataName = new ArrayList<String>();

    private static DataList instance;

    public static DataList getInstance() {
        if (instance == null)
            instance = new DataList();
        return instance;
    }

    private Context mContext;

    private DataList() {
        mContext = Contextor.getInstance().getContext();
        setDataImg();
        setDataName();
    }

    public String getDataName(int pst) {
        return dataName.get(pst);
    }
    public Integer getDataImg(int pst) {
        return dataImg.get(pst);
    }

    /// Set Data
    private void setDataImg() {
        dataImg.add(R.drawable.mock);
        dataImg.add(R.drawable.dog);

        dataImg.add(R.drawable.mock);
        dataImg.add(R.drawable.dog);
    }
    private void setDataName() {
        dataName.add("amsterdam");
        dataName.add("dog");

        dataName.add("amsterdam");
        dataName.add("dog");
    }

}
