package com.florent.thecoktail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WebServicesInterface {
    @GET("random.php")
    Call<Drink> getRandomTitle();

    @GET("list.php?c=list")
    Call<DrinkCategorie> getCategorie();

    @GET("filter.php")
    Call<DrinkCoktailCategorie> getCoktailCategorie(@Query("c") String categoryName);

    @GET("search.php")
    Call<Drink> getCoktailDetail(@Query("s") String name);
}
