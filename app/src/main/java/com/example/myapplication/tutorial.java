package com.example.myapplication;

import static com.example.myapplication.R.raw.tutoriaal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tutorial extends AppCompatActivity {

    VideoView video_view;
    MediaController mediaController;
    int position=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tutorial);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        video_view =findViewById(R.id.video_View);

        String path="android.resource://"+ getPackageName()+"/"+R.raw.tutoriaal;

        video_view.setVideoURI(Uri.parse(path));
        video_view.start();

        if(this.mediaController==null){
            this.mediaController=new MediaController(tutorial.this);

            this.mediaController.setAnchorView(video_view);

            this.video_view.setMediaController(mediaController);
        }
        this.video_view.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                video_view.seekTo(position);
                if(position==0){
                    video_view.start();
                }

                mp.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(video_view);
                    }
                });

            }
        });
    }

    public void closee(View view) {
        Intent closetuto = new Intent(tutorial.this, inicioprofe.class );
        startActivity(closetuto);
    }

}