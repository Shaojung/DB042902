package com.example.teacher.db042902;

import android.app.ActivityManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 取得管理資源
    private ActivityManager manager; // 存放所有執行中的服務
    private List<ActivityManager.RunningServiceInfo> serviceList;
    private Context context;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        lv = (ListView) findViewById(R.id.listView);
        manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        serviceList = manager.getRunningServices(50);

        for (ActivityManager.RunningServiceInfo info : serviceList)
        {
            Log.d("INFO", info.service.getPackageName() + info.service.getShortClassName());
        }
    }
}
