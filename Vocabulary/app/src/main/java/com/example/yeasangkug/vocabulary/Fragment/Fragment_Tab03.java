package com.example.yeasangkug.vocabulary.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.yeasangkug.vocabulary.DB.DBManager;
import com.example.yeasangkug.vocabulary.R;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Fragment_Tab03 extends Fragment{

    private final String TAG = "MyVocabulary";

    private EditText mEdt_Word;
    private EditText mEdt_Mean;
    private Button   mBtn_Add;

    private View mView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_tab03, container, false);

        resource_init();

        return mView;

    }

    private void resource_init()
    {
        mEdt_Word = (EditText)mView.findViewById(R.id.edt_tab03_word);
        mEdt_Mean = (EditText)mView.findViewById(R.id.edt_tab03_mean);
        mBtn_Add  = (Button)mView.findViewById(R.id.btn_tab03_add);

        mBtn_Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"Fragment 03 추가 버튼 클릭");

                String word = mEdt_Word.getText().toString();
                String mean = mEdt_Mean.getText().toString();


                DBManager db_manager = DBManager.get_DbManager(getActivity());

                db_manager.insert(word, mean);

                mEdt_Word.setText("");
                mEdt_Mean.setText("");
            }
        });

    }
}
