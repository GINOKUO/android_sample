package com.example.givemepass.viewpagerdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import java.util.logging.Handler;

/**
 * Created by givemepass on 2016/7/8.
 */
public class PageTwoView extends PageView{
    private android.os.Handler handler = new android.os.Handler();

    public PageTwoView(Context context) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.page_content, null);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText("Page two");
        addView(view);
    }


    @Override
    public void refreshView() {

    }
}
