package com.example.travellazza;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.travellazza.databinding.LoadingBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Splash extends AppCompatActivity {

    private LoadingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = LoadingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new MainActivity();


    }
}
