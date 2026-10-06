package com.example.projeto_pdm_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity {

    private DrawerLayout drawLayout;

    private NavigationView naviView;

    private Toolbar toolbar;

    private ActionBarDrawerToggle toogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.idLinear), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        drawLayout = findViewById(R.id.idDrawer);
        naviView = findViewById(R.id.idNavigation);
        toolbar = findViewById(R.id.toolbar2);

        toogle = new ActionBarDrawerToggle(this, drawLayout, toolbar, R.string.open, R.string.close);
        drawLayout.addDrawerListener(toogle);
        toogle.syncState();

        naviView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if (menuItem.getItemId() == R.id.idHome){

                    drawLayout.closeDrawers();
                    return false;

                }

                if (menuItem.getItemId() == R.id.idTela02){

                    drawLayout.closeDrawers();
                    startActivity(new Intent(HomeActivity.this, MainActivity02.class));
                    return false;

                }

                if (menuItem.getItemId() == R.id.idTela3){

                    drawLayout.closeDrawers();
                    startActivity(new Intent(HomeActivity.this, MainActivity3.class));
                    return false;

                }

                return false;

            }

        });



    }
}