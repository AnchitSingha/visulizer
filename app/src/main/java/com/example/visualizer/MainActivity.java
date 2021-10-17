package com.example.visualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gauravk.audiovisualizer.visualizer.BarVisualizer;

public class MainActivity extends AppCompatActivity {

    Button btnplay, btnpause, btnstop;
    MediaPlayer player;
    BarVisualizer visualizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplay = findViewById(R.id.play);
        btnpause = findViewById(R.id.pause);
        btnstop = findViewById(R.id.stop);
        visualizer = findViewById(R.id.bar);

        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player == null)
                {
                    player = MediaPlayer.create(MainActivity.this, R.raw.pop);
                    
                }
                player.start();
            }
        });

        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player != null)
                {
                    player.pause();
                }
            }
        });

        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(player != null)
                {
                    player.release();
                    player = null;
                }
            }
        });
    }
}