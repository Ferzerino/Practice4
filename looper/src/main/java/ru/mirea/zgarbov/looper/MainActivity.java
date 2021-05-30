package ru.mirea.zgarbov.looper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.os.Message;

public class MainActivity extends AppCompatActivity {
    static MyLooper myLooper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLooper = new MyLooper();
        myLooper.start();
    }
    public void onCLick(View view) {
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("KEY", "Age");
        msg.setData(bundle);
        if(myLooper != null){
            myLooper.handler.sendMessage(msg);
        }
    }
}