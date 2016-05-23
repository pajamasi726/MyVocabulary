package com.example.yeasangkug.vocabulary.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.yeasangkug.vocabulary.R;
import com.example.yeasangkug.vocabulary.WebView.ClientWebView;

/**
 * Created by yeasangkug on 2016. 5. 19..
 */
public class Fragment_Tab02 extends Fragment{

    private WebView mWebView;
    private View mView;
    private String mUrl = "http://dic.daum.net/index.do?dic=eng";

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_tab02, container, false);

        resource_init();

        return mView;

    }

    private void resource_init()
    {
        mWebView = (WebView) mView.findViewById(R.id.webview);

        // 자바 스크립트 실행 가능
        mWebView.getSettings().setJavaScriptEnabled(true);
        // 홈페이지 지정
        mWebView.loadUrl(mUrl);

        // WebClient 지정
        mWebView.setWebViewClient(new ClientWebView());

    }
}
