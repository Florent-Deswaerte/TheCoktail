package com.florent.thecoktail;

import com.google.gson.annotations.SerializedName;

public class Drink {
    @SerializedName("drinks")
    public Coktail[] drinks;
}
