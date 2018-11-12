package com.hie2j.localbroadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private LocalReceiver localReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localReceiver = new LocalReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction("LOCAL_BROADCAST");
        LocalBroadcastManager manager = LocalBroadcastManager.getInstance(MainActivity.this);
        manager.registerReceiver(localReceiver,filter);
//        registerReceiver(localReceiver,filter);

        findViewById(R.id.btn_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("LOCAL_BROADCAST");

                LocalBroadcastManager manager = LocalBroadcastManager.getInstance(MainActivity.this);
                manager.sendBroadcast(intent);

//                sendOrderedBroadcast(intent,null);

            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        unregisterReceiver(localReceiver);
//    }
}
