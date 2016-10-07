package com.example.yp.androidtrafficmonitor.layout;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import com.example.yp.androidtrafficmonitor.R;

/**
 * Created by yp on 2016/9/25.
 */
public class AboutUsDialog extends Dialog {

    private Context context;

    public AboutUsDialog(Context context) {
        super(context);
        this.context = context;
    }

    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.about_us_dialog);
    }

}
