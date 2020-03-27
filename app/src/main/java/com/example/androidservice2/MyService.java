package com.example.androidservice2;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Bundle bundle = intent.getBundleExtra("MyBundle");

        if (bundle != null) {
            String searchText = bundle.getString("Text");
            char key = bundle.getChar("Key");

            int count = 0;
            for (int i = 0; i < searchText.length(); i++) {
                if (searchText.charAt(i) == key)
                    count++;
            }

            String content = "Có " + count + " kí tự " + key;

            Toast.makeText(this, content, Toast.LENGTH_SHORT).show();

        }

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
