package com.florent.thecoktail;

import com.google.gson.annotations.SerializedName;

public class CoktailCategorie {
    @SerializedName("strDrink")
    public String strDrink;

    @SerializedName("strDrinkThumb")
    public String strDrinkThumb;

    @SerializedName("idDrink")
    public int idDrink;
}
