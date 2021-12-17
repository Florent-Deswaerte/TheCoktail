package com.florent.thecoktail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WebServicesInterface {
    @GET("api/json/v1/1/random.php")
    Call<Todo[]> getAllTodo();
}
