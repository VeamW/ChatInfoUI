package com.workdemo.vinjim.vtopbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by VinJim on 2016/1/6.
 */
public class VTopBar extends RelativeLayout {

    /**
     * 自定义的属性
     */
    private Button mLeftButton, mRightButton;
    private TextView mTitle;

    private int mLeftTextColor, mRightTextColor, mTitleTextColor, mTitleTextSize;
    private Drawable mLeftBackground, mRightBackground;
    private String mLeftText, mRightText, mTitleText;


    private LayoutParams mLeftParams,mRightParams,mTitleParams;


    public VTopBar(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.VTopBar);
        //获取左边属性
        mLeftTextColor = array.getColor(R.styleable.VTopBar_leftTextColor, 0);
        mLeftBackground = array.getDrawable(R.styleable.VTopBar_leftBackground);
        mLeftText = array.getString(R.styleable.VTopBar_leftText);
        //获取右边属性
        mRightText = array.getString(R.styleable.VTopBar_rightText);
        mRightTextColor = array.getColor(R.styleable.VTopBar_rightTextColor, 0);
        mRightBackground = array.getDrawable(R.styleable.VTopBar_rightBackground);
        //获取标题属性
        mTitleText = array.getString(R.styleable.VTopBar_titleText);
        mTitleTextColor = array.getColor(R.styleable.VTopBar_vtitleTextColor, 0);
        mTitleTextSize = (int) array.getDimension(R.styleable.VTopBar_vtitleTextSize, 0);
        //回收
        array.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitle = new TextView(context);

        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setText(mLeftText);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), mLeftButton.getText()+"", Toast.LENGTH_SHORT).show();
            }
        });

        mRightButton.setText(mRightText);
        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), mRightButton.getText()+"", Toast.LENGTH_SHORT).show();
            }
        });

        mTitle.setText(mTitleText);
        mTitle.setTextColor(mTitleTextColor);
        mTitle.setTextSize(mTitleTextSize);
        mTitle.setGravity(Gravity.CENTER);
        mTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), mTitle.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        setBackgroundColor(0xfff59563);

        mLeftParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
        addView(mLeftButton, mLeftParams);
        mRightParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, TRUE);
        addView(mRightButton, mRightParams);
        mTitleParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT, TRUE);
        addView(mTitle, mTitleParams);

    }
}
