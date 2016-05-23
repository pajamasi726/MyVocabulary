package com.example.yeasangkug.vocabulary.WebView;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by yeasangkug on 2016. 5. 23..
 */
public class ClientWebView extends WebViewClient{

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
