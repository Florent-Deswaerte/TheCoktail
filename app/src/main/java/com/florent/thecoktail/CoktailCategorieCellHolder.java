package com.florent.thecoktail;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CoktailCategorieCellHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView idTextView;
    public ImageView imageView;

    public CoktailCategorieCellHolder(@NonNull View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        idTextView = itemView.findViewById(R.id.titleTextView);
        imageView = itemView.findViewById(R.id.imageView);
    }
}
