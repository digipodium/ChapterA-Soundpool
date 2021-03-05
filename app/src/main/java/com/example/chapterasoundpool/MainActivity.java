package com.example.chapterasoundpool;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Bundle;

import com.example.chapterasoundpool.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private com.example.chapterasoundpool.databinding.ActivityMainBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        bind = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());
        SoundPool sp = new SoundPool.Builder()
                .setMaxStreams(5)
                .setAudioAttributes(new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build())
                .build();
        int sound1 = sp.load(this, R.raw.p1, 0);
        int sound2 = sp.load(this, R.raw.p2, 0);
        int sound3 = sp.load(this, R.raw.p3, 0);

        bind.fab1.setOnClickListener(v1 -> {
            sp.play(sound1, 1, 1, 1, 1, 1);
        });
        bind.fab2.setOnClickListener(v2 -> {
            sp.play(sound2, 1, 1, 1, 1, 1);
        });
        bind.fab3.setOnClickListener(v3 -> {
            sp.play(sound3, 1, 1, 1, 1, 1);
        });

        bind.btnStop.setOnClickListener(v4 -> {
            sp.stop(sound1);
            sp.stop(sound2);
            sp.stop(sound3);
        });
    }
}