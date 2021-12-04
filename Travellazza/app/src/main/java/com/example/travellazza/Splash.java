package com.example.travellazza;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.travellazza.databinding.LoadingBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Handler;
public class Splash extends AppCompatActivity {

    private LoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms
                Intent intent = new Intent(Splash.this,Login.class);
                startActivity(intent);
                finish();
            }
        }, 3000);



    }
}
