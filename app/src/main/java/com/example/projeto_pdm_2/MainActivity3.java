package com.example.projeto_pdm_2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener{

    private ViewPager2 viewPager;

    private ArrayList<Slide> lista;

    private Button voltar;

    private ImageButton music;

    private MediaPlayer mediaPlayer;

    private boolean tocando;

    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewPager);

        texto = findViewById(R.id.textView7);

        lista = new ArrayList<Slide>();
        lista.add(new Slide("Kamen rider Geats", R.drawable.geats, "Kamen rider Geats: Magnum Boost form"));
        lista.add(new Slide("Kamen rider Tycoon", R.drawable.tycoon, "Kamen rider Tycoon: Ninja form"));
        lista.add(new Slide("Kamen rider Na-go", R.drawable.na, "Kamen rider Na-go: Beat form"));
        lista.add(new Slide("Kamen rider Buffa", R.drawable.buffa, "Kamen rider Buffa: Zombie form"));
        lista.add(new Slide("Kamen rider PunkJack", R.drawable.punkjack, "Kamen rider Punkjack: Monster form"));

        SlideAdapter adapter = new SlideAdapter(lista, texto);
        viewPager.setAdapter(adapter);

        voltar = findViewById(R.id.button);
        voltar.setOnClickListener(this);

        music = findViewById(R.id.imageButton);
        music.setOnClickListener(this);


        tocando = true;
    }

    @Override
    public void onClick(View view) {

        if (view == voltar)

            startActivity(new Intent(this, MainActivity02.class));

        if (view == music){

            if(tocando){

                tocando = false;

                music.setImageResource(R.drawable.music_off_48px);
                music.setBackgroundResource(R.drawable.border);

                mediaPlayer = MediaPlayer.create(this,R.raw.time_4_highlight_battle_theme);
                mediaPlayer.setOnCompletionListener(this);
                mediaPlayer.start();

            }else{

                tocando = true;

                music.setImageResource(R.drawable.music_note_24px);
                music.setBackgroundResource(R.drawable.borda);

                mediaPlayer.stop();

            }

        }

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
}