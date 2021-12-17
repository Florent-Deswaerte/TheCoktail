package com.florent.thecoktail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        Call<Drink> callGetRandom = webServicesInterface.getRandom();
        callGetRandom.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {
                    System.out.println(response.body().drinks[0].strDrink);
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                System.out.println("Fails");
            }
        });

        return inflater.inflate(R.layout.fragment_random, null);
    }
}
