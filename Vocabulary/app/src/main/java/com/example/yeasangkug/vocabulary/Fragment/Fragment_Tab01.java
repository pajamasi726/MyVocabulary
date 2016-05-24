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

import com.example.yeasangkug.vocabulary.Adapter.Adapter_WordList;
import com.example.yeasangkug.vocabulary.DB.DBManager;
import com.example.yeasangkug.vocabulary.DTO.Item_Word;
import com.example.yeasangkug.vocabulary.R;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Fragment_Tab01 extends Fragment{

    private final String TAG = "Vocabulary Fragment01";

    private Context mContext;
    private View mView;

    private ListView mListView;
    private Adapter_WordList mAdapter;
    private ImageButton mBtnSearch;
    private EditText mEditInput;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_tab01, container, false);

        init_resource();

        init_ListView();

        update_ListView();

        return mView;
    }

    private void init_resource()
    {
        mContext = this.getActivity();
        mBtnSearch = (ImageButton)mView.findViewById(R.id.btn_tab01_search);
        mEditInput = (EditText)mView.findViewById(R.id.edt_tab01_input);

        mBtnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"onClick");
            }
        });
    }

    private void init_ListView()
    {
        mListView = (ListView)mView.findViewById(R.id.list_tab01_wordlist);

        mAdapter = new Adapter_WordList();
        mListView.setAdapter(mAdapter);
    }

    private void update_ListView()
    {
        if(mAdapter == null)
            return;
        DBManager dbmanager = DBManager.get_DbManager(getActivity());
        mAdapter.setList(dbmanager.allData());
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(isVisibleToUser){
            update_ListView();
        }

        super.setUserVisibleHint(isVisibleToUser);
    }
}
