package com.example.yp.androidtrafficmonitor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.yp.androidtrafficmonitor.R;

import java.util.ArrayList;

/**
 * Created by yp on 2016/9/25.
 */
public class SettingActivity extends AppCompatActivity implements View.OnClickListener{

    private Spinner operatorSpinner;
    //private String []operator = {"中国移动","中国联通","中国电信"};
    private ArrayList<String> arrayList;
    private ArrayAdapter arrayAdapter;
    private Button backBtn;
    private Button sureBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.parameter_setting_layout);
        operatorSpinner = (Spinner) findViewById(R.id.spinner);
        backBtn = (Button) findViewById(R.id.backBtn);
        sureBtn = (Button) findViewById(R.id.surBtn);
        backBtn.setOnClickListener(this);
        sureBtn.setOnClickListener(this);
        arrayList = new ArrayList<String>();
        arrayList.add("中国移动");
        arrayList.add("中国联通");
        arrayList.add("中国电信");
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        operatorSpinner.setAdapter(arrayAdapter);
        operatorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.backBtn:this.finish();break;
            case R.id.surBtn :saveSettingInfor();
        }

    }

    void saveSettingInfor(){
        Toast.makeText(getApplicationContext(),"保存成功", Toast.LENGTH_SHORT).show();
    }

}
