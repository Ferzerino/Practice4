package ru.mirea.zgarbov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int counter = 0;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView infoTextView = findViewById(R.id.textView);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Current thread: " + mainThread.getName());
        mainThread.setName("MireaThread");
        infoTextView.append("\n New thread name: " + mainThread.getName());
    }
    public void onClick(View view) {
        Runnable runnable = new Runnable(){
            public void run(){
                int numberThread = counter++;
                Log.i("ThreadProject", "Running thread № " + numberThread);
                long endTime = System.currentTimeMillis() + 20 * 1000;

                while (System.currentTimeMillis() < endTime){
                    synchronized (this){
                        try{
                            wait(endTime - System.currentTimeMillis());
                        }catch (Exception e){
                        }
                    }
                }
                Log.i("ThreadProject", "Выполнен поток №" + numberThread);
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }


}