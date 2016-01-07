package com.workdemo.vinjim.wchat6_0;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by VinJim on 2016/1/7.
 */
public class TagFragment extends Fragment {

    public static final String TITLE = "title";

    private String mTitle = "default";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        if (bundle != null) {
           mTitle =  bundle.getString(TITLE);
        }

        TextView textView = new TextView(getActivity() );
        textView.setTextSize(30);
        textView.setBackgroundColor(Color.parseColor("#ffffffff"));
        textView.setText(mTitle);
        textView.setGravity(Gravity.CENTER);

        return textView;
    }
}
