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

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/").addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        Call<Todo[]> callGetAllTodo = webServicesInterface.getAllTodo();
        callGetAllTodo.enqueue(new Callback<Todo[]>() {
            @Override
            public void onResponse(Call<Todo[]> call, Response<Todo[]> response) {
                for (Todo t : response.body()){
                    System.out.println(t.strDrink);
                }
            }

            @Override
            public void onFailure(Call<Todo[]> call, Throwable t) {
                System.out.println("Fails");
            }
        });

        return inflater.inflate(R.layout.fragment_random, null);
    }
}
