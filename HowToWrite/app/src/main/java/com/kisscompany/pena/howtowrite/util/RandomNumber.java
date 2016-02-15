package com.kisscompany.pena.howtowrite.util;

import android.content.Context;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class RandomNumber {
    private int Max,Min;

    private static RandomNumber instance;

    public static RandomNumber getInstance() {
        if (instance == null)
            instance = new RandomNumber();
        return instance;
    }

    private Context mContext;

    private RandomNumber() {
        mContext = Contextor.getInstance().getContext();
    }

    public void setRanDomNumber(int Max,int Min){
        this.Max = Max;
        this.Min = Min;
    }

    public int getRanDomNumber(){
        //Min + (int)(Math.random() * ((Max - Min) + 1))
        int ranPst = Min + (int)(Math.random() * ((Max - Min) + 1));
        return ranPst;
    }

}
