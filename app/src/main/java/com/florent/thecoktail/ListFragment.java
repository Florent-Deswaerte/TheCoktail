package com.florent.thecoktail;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListFragment extends Fragment {

    private RecyclerView categorieListRecyclerView;
    private RecyclerView.Adapter categorieListAdapter;
    private RecyclerView.LayoutManager categorieListManager;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        categorieListRecyclerView = view.findViewById(R.id.categorieListRecyclerView);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        List<String> AllCategorieList = new ArrayList<String>();

        Call<DrinkCategorie> callGetCategorie = webServicesInterface.getCategorie();
        callGetCategorie.enqueue(new Callback<DrinkCategorie>() {
            @Override
            public void onResponse(Call<DrinkCategorie> call, Response<DrinkCategorie> response) {

                //Permet de fixer la taille du ReclyclerView
                categorieListRecyclerView.setHasFixedSize(true);
                //Permet de définir l'orientation de scroll du RecyclerView
                categorieListManager = new LinearLayoutManager(getContext());
                categorieListRecyclerView.setLayoutManager(categorieListManager);
                //On définit notre jeu de données pour alimenter notre liste.
                //On crée notre adapter et on le lie avec notre jeu de données
                categorieListAdapter = new categorieListAdapter(response.body().categories);
                categorieListRecyclerView.setAdapter(categorieListAdapter);
            }

            @Override
            public void onFailure(Call<DrinkCategorie> call, Throwable t) {
                System.out.println("Fails");
            }
        });
        return inflater.inflate(R.layout.fragment_list, null);
    }
}
