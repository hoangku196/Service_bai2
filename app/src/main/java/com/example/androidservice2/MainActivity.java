package com.example.androidservice2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edText;
    private Intent service;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edText = findViewById(R.id.edText);

        bundle = new Bundle();

        service = new Intent(this, MyService.class);

    }

    public void searchA(View view) {
        String text = edText.getText().toString();
        if (text.length() > 0) {
            bundle.putString("Text", text);
            bundle.putChar("Key", 'A');
            service.putExtra("MyBundle", bundle);
            startService(service);
        } else {
            Toast.makeText(this, "Nhập vào một chuỗi", Toast.LENGTH_SHORT).show();
        }
    }
    public void searchB(View view){
        String text = edText.getText().toString();
        if (text.length() > 0) {
            bundle.putString("Text", text);
            bundle.putChar("Key", 'B');
            service.putExtra("MyBundle", bundle);
            startService(service);
        } else {
            Toast.makeText(this, "Nhập vào một chuỗi", Toast.LENGTH_SHORT).show();
        }
    }

    public void stopMyService() {
        stopService(service);
    }
}
