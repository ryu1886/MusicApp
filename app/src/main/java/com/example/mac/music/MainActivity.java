package com.example.mac.music;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


    public class MainActivity extends AppCompatActivity {

        private MediaPlayer mMplayer;
        private Button bt_start;
        private Button bt_stop;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            mMplayer = new MediaPlayer();


            bt_start = (Button) findViewById(R.id.bt_start);
            bt_stop = (Button) findViewById(R.id.bt_stop);



            try {
                AssetFileDescriptor afd = getResources().openRawResourceFd(R.raw.boysandgirls);
                mMplayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            } catch(Exception e) {
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }


            bt_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        mMplayer.prepare();
                        mMplayer.start();
                    } catch(Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

            bt_stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMplayer.stop();
                }
            });




        }
    }