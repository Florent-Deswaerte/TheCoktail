package com.florent.thecoktail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.view.MenuItem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, OnCategorieListClickListener, OnCoktailCategorieListClickListener {

    Fragment RandomFragment;
    Fragment ListFragment;
    Fragment SearchFragment;
    Fragment CocktailCategoryFragment;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RandomFragment = new RandomFragment();
        ListFragment = new ListFragment();
        SearchFragment = new SearchFragment();

        loadFragment(RandomFragment);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch(item.getItemId()){
            case R.id.action_random:
                fragment = RandomFragment;
                break;
            case R.id.action_list:
                fragment = ListFragment;
                break;
            case R.id.action_search:
                fragment = SearchFragment;
                break;
        }
        return loadFragment(fragment);
    }

    @Override
    public void onCategorieListClick(Categorie categorie) {
        String category = categorie.strCategory;
        CocktailCategoryFragment = new CocktailCategoryFragment(category);
        loadFragment(CocktailCategoryFragment);
    }

    @Override
    public void onCoktailCategorieListClick(CoktailCategorie coktailCategorie) {
        String name = coktailCategorie.strDrink;
        CocktailCategoryFragment = new CocktailDetailFragment(name);
        loadFragment(CocktailCategoryFragment);
    }

    @Override
    public void onCoktailSearchListClick(Coktail coktail) {
        String name = coktail.strDrink;
        CocktailCategoryFragment = new CocktailDetailFragment(name);
        loadFragment(CocktailCategoryFragment);
    }
}