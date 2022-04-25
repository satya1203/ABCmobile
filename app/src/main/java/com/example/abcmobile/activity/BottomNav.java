package com.example.abcmobile.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.abcmobile.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BottomNav extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bottom_nav);

        BottomNavigationView navView = findViewById(R.id.bottom_navigation);
//        NavController navController = Navigation.findNavController(this,R.id.bottom_navigation);

//        List<Integer> list = Arrays.asList(R.id.navigation_home, R.id.navigation_dashboard);
//        Set<Integer> set = new HashSet(Arrays.asList(R.id.navigation_home, R.id.navigation_dashboard));
//        AppBarConfiguration AppBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();

//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_transaction).build();
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        final NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        final NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(navView, navController);
    }
}
