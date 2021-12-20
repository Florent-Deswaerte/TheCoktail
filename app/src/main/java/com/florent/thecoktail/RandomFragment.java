package com.florent.thecoktail;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RandomFragment extends Fragment {

    TextView textViewTitle;
    TextView textViewIngredient;
    TextView textViewMesure;
    TextView textViewAlcoholic;
    TextView textViewCategory;
    TextView textViewInstructions;

    ImageView imageViewCocktail;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewTitle = view.findViewById(R.id.textViewTitle);
        textViewIngredient = view.findViewById(R.id.textViewIngredient);
        textViewMesure = view.findViewById(R.id.textViewMesure);
        textViewAlcoholic = view.findViewById(R.id.textViewAlcoholic);
        textViewCategory = view.findViewById(R.id.textViewCategory);
        textViewInstructions = view.findViewById(R.id.textViewInstructions);

        imageViewCocktail = view.findViewById(R.id.imageViewCocktail);

        textViewIngredient.setHorizontalScrollBarEnabled(true);
        textViewIngredient.setScrollbarFadingEnabled(true);
        textViewIngredient.setHorizontallyScrolling(true);
        textViewIngredient.setMovementMethod(new ScrollingMovementMethod());
        textViewMesure.setHorizontalScrollBarEnabled(true);
        textViewMesure.setScrollbarFadingEnabled(true);
        textViewMesure.setHorizontallyScrolling(true);
        textViewMesure.setMovementMethod(new ScrollingMovementMethod());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/1/").addConverterFactory(GsonConverterFactory.create()).build();
        WebServicesInterface webServicesInterface = retrofit.create(WebServicesInterface.class);

        Call<Drink> callGetRandomTitle = webServicesInterface.getRandomTitle();
        callGetRandomTitle.enqueue(new Callback<Drink>() {
            @Override
            public void onResponse(Call<Drink> call, Response<Drink> response) {

                List<String> AllIngredientsList = new ArrayList<String>();
                AllIngredientsList.add(response.body().drinks[0].strIngredient1);
                AllIngredientsList.add(response.body().drinks[0].strIngredient2);
                AllIngredientsList.add(response.body().drinks[0].strIngredient3);
                AllIngredientsList.add(response.body().drinks[0].strIngredient4);
                AllIngredientsList.add(response.body().drinks[0].strIngredient5);
                AllIngredientsList.add(response.body().drinks[0].strIngredient6);
                AllIngredientsList.add(response.body().drinks[0].strIngredient7);
                AllIngredientsList.add(response.body().drinks[0].strIngredient8);
                AllIngredientsList.add(response.body().drinks[0].strIngredient9);
                AllIngredientsList.add(response.body().drinks[0].strIngredient10);
                AllIngredientsList.add(response.body().drinks[0].strIngredient11);
                AllIngredientsList.add(response.body().drinks[0].strIngredient12);
                AllIngredientsList.add(response.body().drinks[0].strIngredient13);
                AllIngredientsList.add(response.body().drinks[0].strIngredient14);
                AllIngredientsList.add(response.body().drinks[0].strIngredient15);

                String IngredientsList = "";
                for(int i=0;i<AllIngredientsList.size();i++){
                    if (AllIngredientsList.get(i) != null && AllIngredientsList.get(i) != " "){
                        IngredientsList += AllIngredientsList.get(i) + "\n";
                    }
                }

                List<String> AllMeasuresList = new ArrayList<String>();
                AllMeasuresList.add(response.body().drinks[0].strMeasure1);
                AllMeasuresList.add(response.body().drinks[0].strMeasure2);
                AllMeasuresList.add(response.body().drinks[0].strMeasure3);
                AllMeasuresList.add(response.body().drinks[0].strMeasure4);
                AllMeasuresList.add(response.body().drinks[0].strMeasure5);
                AllMeasuresList.add(response.body().drinks[0].strMeasure6);
                AllMeasuresList.add(response.body().drinks[0].strMeasure7);
                AllMeasuresList.add(response.body().drinks[0].strMeasure8);
                AllMeasuresList.add(response.body().drinks[0].strMeasure9);
                AllMeasuresList.add(response.body().drinks[0].strMeasure10);
                AllMeasuresList.add(response.body().drinks[0].strMeasure11);
                AllMeasuresList.add(response.body().drinks[0].strMeasure12);
                AllMeasuresList.add(response.body().drinks[0].strMeasure13);
                AllMeasuresList.add(response.body().drinks[0].strMeasure14);
                AllMeasuresList.add(response.body().drinks[0].strMeasure15);

                String MeasuresList = "";
                for(int i=0;i<AllMeasuresList.size();i++){
                    if (AllMeasuresList.get(i) != null && AllMeasuresList.get(i) != " "){
                        MeasuresList += AllMeasuresList.get(i) + "\n";
                    }
                }

                textViewTitle.setText(response.body().drinks[0].strDrink);
                textViewIngredient.setText(IngredientsList);
                textViewMesure.setText(MeasuresList);
                textViewAlcoholic.setText(response.body().drinks[0].strAlcoholic);
                textViewCategory.setText(response.body().drinks[0].strCategory);
                textViewInstructions.setText(response.body().drinks[0].strInstructions);

                Picasso.get().load(response.body().drinks[0].strDrinkThumb).into(imageViewCocktail);
            }

            @Override
            public void onFailure(Call<Drink> call, Throwable t) {
                System.out.println("Fails");
            }
        });

        return inflater.inflate(R.layout.fragment_random, null);
    }
}
