package com.example.givemepass.viewpagerdemo;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;

/**
 * Created by givemepass on 2016/7/8.
 */
public abstract class PageView extends RelativeLayout{
    public PageView(Context context) {
        super(context);
    }
    public abstract void refreshView();
}
