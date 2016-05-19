package com.example.yeasangkug.vocabulary.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yeasangkug.vocabulary.R;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Fragment_Tab01 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tab01, container, false);
        return rootView;

    }
}
