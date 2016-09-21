package com.example.yp.androidtrafficmonitor;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button showBtn=null;
    private TextView uidTraffic;
    private String result;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBtn=(Button) findViewById(R.id.showList);
        uidTraffic = (TextView) findViewById(R.id.uidTraffic);
        showBtn.setOnClickListener(new ButtonListener());
    }

    public void getAppTrafficList(){
        //获取所有的安装在手机上的应用软件的信息，并且获取这些软件里面的权限信息
        PackageManager pm=getPackageManager();//获取系统应用包管理
        //获取每个包内的androidmanifest.xml信息，它的权限等等
        List<PackageInfo> pinfos=pm.getInstalledPackages
                ( PackageManager.GET_PERMISSIONS);
        //遍历每个应用包信息
        for(PackageInfo info:pinfos){
            //请求每个程序包对应的androidManifest.xml里面的权限
            String[] premissions=info.requestedPermissions;
            if(premissions!=null && premissions.length>0){
                //找出需要网络服务的应用程序
                for(String premission : premissions){
                    if("android.permission.INTERNET".equals(premission)){
                        //获取每个应用程序在操作系统内的进程id
                        int uId=info.applicationInfo.uid;
                        //如果返回-1，代表不支持使用该方法，注意必须是2.2以上的
                        long rx=TrafficStats.getUidRxBytes(uId);
                        //如果返回-1，代表不支持使用该方法，注意必须是2.2以上的
                        long tx= TrafficStats.getUidTxBytes(uId);
                        if(rx<0 || tx<0){
                            continue;
                        }else{
                            result = result + info.applicationInfo.loadLabel(pm)+Formatter.formatFileSize(this, rx+tx) + "\n";
                        }
                    }
                }
            }
        }

        uidTraffic.setText(result);
    }
    private class ButtonListener implements View.OnClickListener {

        public void onClick(View v) {
            // TODO Auto-generated method stub
            result = "";
            getAppTrafficList();
        }

    }
}
