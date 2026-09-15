package com.example.projeto_pdm_2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity{

    private ViewPager2 viewPager;

    private ArrayList<Slide> lista;

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

        lista = new ArrayList<Slide>();
        lista.add(new Slide("slide", R.drawable.images, "testo.."));
        lista.add(new Slide("slide", R.drawable.images, "testo.."));
        lista.add(new Slide("slide", R.drawable.images, "testo.."));
        lista.add(new Slide("slide", R.drawable.images, "testo.."));
        lista.add(new Slide("slide", R.drawable.images, "testo.."));

        SlideAdapter adapter = new SlideAdapter(lista);
        viewPager.setAdapter(adapter);

    }

}