package com.example.projeto_pdm_2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener{

    private Toolbar toolbar;

    private MediaPlayer mediaPlayer;

    private Button btn;

    private boolean flag;

    private int musica;

    private SeekBar seekBar;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        handler = new Handler();

        btn = findViewById(R.id.button2);
        btn.setOnClickListener(this);

        flag = false;

        musica = R.raw.ultraman_geed_no_akashi;
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if (id == android.R.id.home){

            finish();

        }

        if(id == R.id.id001){

            if(mediaPlayer == null){

                mediaPlayer = MediaPlayer.create(this,musica);
                mediaPlayer.setOnCompletionListener(this);

                seekBar.setMax(mediaPlayer.getDuration());

                handler.post(this);

                mediaPlayer.start();

            } else if (!mediaPlayer.isPlaying()) {

                mediaPlayer.start();

            }

        }

        if(id == R.id.id002){

            if(mediaPlayer != null && mediaPlayer.isPlaying()){

                mediaPlayer.pause();

            }

        }

        if(id == R.id.id003){

            if(mediaPlayer != null){

                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;

            }

        }

        return false;

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        mediaPlayer.release();
        mediaPlayer = null;

        seekBar.setProgress(0);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if(mediaPlayer != null){

            mediaPlayer.seekTo(seekBar.getProgress());

        }

    }

    @Override
    public void run() {

        if(mediaPlayer != null){

            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,100);

        }

    }

    @Override
    public void onClick(View view) {

        if(view == btn){

            if(!flag){

                musica = R.raw.ultraman_orb_no_inori;
                flag = true;

            }else{

                musica = R.raw.touch_the_sun__origin_saga;
                flag = false;

            }

        }

    }

}
