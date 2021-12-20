package com.florent.thecoktail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesInterface {
    @GET("random.php")
    Call<Drink> getRandomTitle();
}
