package com.florent.thecoktail;

import com.google.gson.annotations.SerializedName;

public class DrinkCoktailCategorie {
    @SerializedName("drinks")
    public CoktailCategorie[] coktailCategories;
}
