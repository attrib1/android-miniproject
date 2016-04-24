package com.kisscompany.pena.howtowrite.util;

import android.content.Context;

import com.kisscompany.pena.howtowrite.manager.Contextor;

import java.util.Random;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class RandomNumber {

    private int Min=0,Max=9;


/*    private static RandomNumber instance;

    public static RandomNumber getInstance() {
        if (instance == null)
            instance = new RandomNumber();
        return instance;
    }*/

    //private Context mContext;

    /*public RandomNumber() {
        //mContext = Contextor.getInstance().getContext();
    }*/

/*
    public void setRanDomNumber(int max,int min){
        Max = max+1;
        Min = min;
    }
*/

    public int getRanDomNumber(){
        Random rand = new Random();

        int ranPst = rand.nextInt((Max - Min) + 1) + Min;

        return ranPst;
    }

}
