package com.florent.thecoktail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CocktailCategoryFragment extends Fragment {

    private RecyclerView cocktailCategorieListRecyclerView;
    private RecyclerView.Adapter coktailCategorieListAdapter;
    private RecyclerView.LayoutManager coktailCategorieListManager;
    String category;

    public CocktailCategoryFragment(String category){
        this.category = category.replaceAll(" ", "_");
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cocktailCategorieListRecyclerView = view.findViewById(R.id.cocktailCategorieListRecyclerView);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        List<String> AllCoktailCategorieList = new ArrayList<String>();

        Call<DrinkCoktailCategorie> callGetCategorie = webServicesInterface.getCoktailCategorie(this.category);
        callGetCategorie.enqueue(new Callback<DrinkCoktailCategorie>() {
            @Override
            public void onResponse(Call<DrinkCoktailCategorie> call, Response<DrinkCoktailCategorie> response) {

                //Permet de fixer la taille du ReclyclerView
                cocktailCategorieListRecyclerView.setHasFixedSize(true);
                //Permet de définir l'orientation de scroll du RecyclerView
                coktailCategorieListManager = new LinearLayoutManager(getContext());
                cocktailCategorieListRecyclerView.setLayoutManager(coktailCategorieListManager);
                //On définit notre jeu de données pour alimenter notre liste.
                //On crée notre adapter et on le lie avec notre jeu de données
                coktailCategorieListAdapter = new CoktailCategorieListAdapter(response.body().coktailCategories, (MainActivity) getActivity());
                cocktailCategorieListRecyclerView.setAdapter(coktailCategorieListAdapter);
            }

            @Override
            public void onFailure(Call<DrinkCoktailCategorie> call, Throwable t) {
                System.out.println("Fails");
            }
        });
        return inflater.inflate(R.layout.fragment_category, null);
    }
}
