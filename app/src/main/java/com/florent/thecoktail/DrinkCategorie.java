package com.florent.thecoktail;

import com.google.gson.annotations.SerializedName;

public class DrinkCategorie {
    @SerializedName("drinks")
    public Categorie[] categories;
}
