package com.kisscompany.pena.howtowrite.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;


import com.kisscompany.pena.howtowrite.R;
import com.kisscompany.pena.howtowrite.view.state.BundleSavedState;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PhotoCustom extends BaseCustomViewGroup {



    public PhotoCustom(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public PhotoCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public PhotoCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public PhotoCustom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate() {
        inflate(getContext(), R.layout.photo_custom, this);
    }


    private void initInstances() {
        // findViewById here



    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        /*
        TypedArray a = getContext().getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.StyleableName,
                defStyleAttr, defStyleRes);

        try {

        } finally {
            a.recycle();
        }
        */
    }

    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        BundleSavedState savedState = new BundleSavedState(superState);
        // Save Instance State(s) here to the 'savedState.getBundle()'
        // for example,
        // savedState.getBundle().putString("key", value);

        return savedState;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        BundleSavedState ss = (BundleSavedState) state;
        super.onRestoreInstanceState(ss.getSuperState());

        Bundle bundle = ss.getBundle();
        // Restore State from bundle here
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //set Size customView (list_item_photo)
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = width * 2 / 3; //display custom view size Screen 2, 3
        int newHeightMeasure = MeasureSpec.makeMeasureSpec(
                height,
                MeasureSpec.EXACTLY
        );
        super.onMeasure(widthMeasureSpec, newHeightMeasure);

        //set Size this class
        setMeasuredDimension(width, height);
    }
}
