package com.example.edu.viewpostactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
//연습용 예제임.
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int mProgressBarStatus=0;
    ProgressBar progressBarPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.button2);
        button.setOnClickListener(this);
        progressBarPost=findViewById(R.id.progressBarPost);

    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressBarStatus<100){
                    try {
                        Thread.sleep(100);//프로그래스바가 움직이는거 보기 위해 일부러 시간을준거. 평소엔 사용안해.
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mProgressBarStatus++;//프로그래스바가 증가
                    progressBarPost.post(new Runnable(){

                        @Override
                        public void run() {
                            progressBarPost.setProgress(mProgressBarStatus);
                        }
                    });
                }
            }
        }).start();
    }
}
