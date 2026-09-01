package com.example.projeto_pdm_2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener, SeekBar.OnSeekBarChangeListener, Runnable, View.OnClickListener{

    private Toolbar toolbar;

    private MediaPlayer mediaPlayer;

    private int musica, indiceLista;

    private SeekBar seekBar;

    private Handler handler;

    private ArrayList <PlayList> lista;

    private CardView Card, Card0, Card1, Card2, Card3;

    private TextView txtMusicToca, txtMusicSeleciona;

    private ImageView imgPreview, imgNext;

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

        musica = R.raw.zenkaiger;

        lista = new ArrayList<PlayList>();
        lista.add(new PlayList("excite", R.raw.exaid_excite));
        lista.add(new PlayList("Samurai Sentai Shinkenger", R.raw.shinkenger));
        lista.add(new PlayList("Ultraman Geed", R.raw.ultraman_geed_no_akashi));
        lista.add(new PlayList("Ultraman Orb Origin", R.raw.touch_the_sun__origin_saga));
        lista.add(new PlayList("Almighty - Saber", R.raw.almighty_saber));

        Card = findViewById(R.id.CardView);
        Card.setOnClickListener(this);
        Card0 = findViewById(R.id.CardView0);
        Card0.setOnClickListener(this);
        Card1 = findViewById(R.id.CardView1);
        Card1.setOnClickListener(this);
        Card2 = findViewById(R.id.CardView2);
        Card2.setOnClickListener(this);
        Card3 = findViewById(R.id.CardView3);
        Card3.setOnClickListener(this);

        txtMusicSeleciona = findViewById(R.id.textView);
        txtMusicToca = findViewById(R.id.textView2);

        imgPreview = findViewById(R.id.imageView4);
        imgPreview.setOnClickListener(this);
        imgNext = findViewById(R.id.imageView5);
        imgNext.setOnClickListener(this);
    }

    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id == android.R.id.home)

            finish();

        if(id == R.id.id001)

            Play();

        if(id == R.id.id002){

            if(mediaPlayer != null && mediaPlayer.isPlaying())

                mediaPlayer.pause();


        }

        if(id == R.id.id003)

            Stop();

        return false;

    }

    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

        handler.removeCallbacks(this);

        mediaPlayer.release();
        this.mediaPlayer = null;

        seekBar.setProgress(0);

        indiceLista ++ ;

        if (indiceLista >= lista.size())

            indiceLista = 0;

        txtMusicSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
        Stop();
        Play();

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

        if(mediaPlayer != null)

            mediaPlayer.seekTo(seekBar.getProgress());

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

        if (view == Card){

            indiceLista = 0;
            txtMusicSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if (view == Card0){

            indiceLista = 1;
            txtMusicSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if (view == Card1){

            indiceLista = 2;
            txtMusicSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if (view == Card2){

            indiceLista = 3;
            txtMusicSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if (view == Card3){

            indiceLista = 4;
            txtMusicSeleciona.setText("Música selecionada: " + lista.get(indiceLista).getNome());
            musica = lista.get(indiceLista).getMusica();

        }

        if (view == imgPreview){

            indiceLista -- ;

            if (indiceLista < 0)

                indiceLista = lista.size()-1;

            txtMusicSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            Stop();
            Play();

        }

        if (view == imgNext){

            indiceLista ++ ;

            if (indiceLista >= lista.size())

                indiceLista = 0;

            txtMusicSeleciona.setText("Música Selecionada: "+lista.get(indiceLista).getNome());
            Stop();
            Play();

        }

    }

    public void Play(){

        if(mediaPlayer == null){

            mediaPlayer = MediaPlayer.create(this,lista.get(indiceLista).getMusica());
            mediaPlayer.setOnCompletionListener(this);

            txtMusicToca.setText("Música tocando: " + lista.get(indiceLista).getNome());

            seekBar.setMax(mediaPlayer.getDuration());

            handler.post(this);

            mediaPlayer.start();

        } else if (!mediaPlayer.isPlaying()) {

            mediaPlayer.start();

            handler.post(this);

        }

    }

    public void Stop(){

        if(mediaPlayer != null){

            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }

    }

}
