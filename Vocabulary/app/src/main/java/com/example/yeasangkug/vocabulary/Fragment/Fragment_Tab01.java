package com.example.yeasangkug.vocabulary.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yeasangkug.vocabulary.R;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Fragment_Tab01 extends Fragment{

    private final String TAG = "Vocabulary Fragment01";

    private Context mContext;
    private View mView;

    private ListView mListView;
    private ImageButton mBtnSearch;
    private EditText mEditInput;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_tab01, container, false);

        init_resource();

        return mView;
    }

    private void init_resource()
    {
        mContext = this.getActivity();

        mListView = (ListView)mView.findViewById(R.id.list_tab01_wordlist);
        mBtnSearch = (ImageButton)mView.findViewById(R.id.btn_tab01_search);
        mEditInput = (EditText)mView.findViewById(R.id.edt_tab01_input);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"onClick");
            }
        });
    }


}
