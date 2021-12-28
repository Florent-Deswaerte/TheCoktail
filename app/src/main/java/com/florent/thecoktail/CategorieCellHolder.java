package com.florent.thecoktail;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategorieCellHolder extends RecyclerView.ViewHolder {
    public TextView categorieTextView;

    public CategorieCellHolder(@NonNull View itemView) {
        super(itemView);
        categorieTextView = itemView.findViewById(R.id.categorieTextView);
    }
}
