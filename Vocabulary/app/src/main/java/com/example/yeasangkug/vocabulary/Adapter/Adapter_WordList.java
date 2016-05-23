package com.example.yeasangkug.vocabulary.Adapter;

import android.content.Context;
import android.support.v7.internal.widget.ContentFrameLayout;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yeasangkug.vocabulary.DTO.Item_Word;
import com.example.yeasangkug.vocabulary.Holder.Holder_Word;
import com.example.yeasangkug.vocabulary.R;

import java.util.ArrayList;

/**
 * Created by yeasangkug on 2016. 5. 23..
 */
public class Adapter_WordList extends BaseAdapter{

    private final String TAG = "MyVocabulary";

    // 단어 데이터를 저장할 배열
    private ArrayList<Item_Word> data;
    private Adapter_WordList mAdapter;


    // 생성자 오버라이딩
    public Adapter_WordList()
    {
        data = new ArrayList<Item_Word>(1);
        mAdapter = this;
    }

    public void addData(Item_Word data)
    {
        Log.i(TAG,"데이터 추가");
        this.data.add(data);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        // context
        final Context context = viewGroup.getContext();

        // 위젯 객체
        Holder_Word holder;

        // 데이터 객체
        Item_Word word;


        if(view == null) // 뷰가 초기 값일 경우
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_listword, viewGroup, false);

            //리소스 연결
            holder = new Holder_Word();
            holder.mTv_Word = (TextView)view.findViewById(R.id.tv_Word);
            holder.mTv_Mean = (TextView)view.findViewById(R.id.tv_Mean);
            holder.mTv_Sound = (ImageButton)view.findViewById(R.id.btn_sound);
            holder.mTv_Delete = (ImageButton)view.findViewById(R.id.btn_delete);

            // 태그 등록
            view.setTag(holder);

        }
        else // 이미 존재 할때
        {
            holder = (Holder_Word)view.getTag();
        }

        word = data.get(i);

        holder.mTv_Word.setText(word.getmWord());
        holder.mTv_Mean.setText(word.getmMean());

        // 소리 재생 버튼 클릭
        holder.mTv_Sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"소리 재생 버튼 클릭");
            }
        });


        // 삭제 버튼 클릭
        holder.mTv_Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG,"데이터 삭제 버튼 클릭");

                // 해당 데이터 찾아서 삭제
                data.remove(i);

                // 갱신 적용
                mAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }
}
