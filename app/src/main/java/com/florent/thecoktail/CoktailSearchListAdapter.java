package com.florent.thecoktail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class CoktailSearchListAdapter extends RecyclerView.Adapter<CoktailCategorieCellHolder> {
    private Coktail[] dataSource;
    private OnCoktailCategorieListClickListener onCoktailCategorieListClickListener;
    public CoktailSearchListAdapter(Coktail[] dataSource, OnCoktailCategorieListClickListener listener) {
        this.dataSource = dataSource;
        onCoktailCategorieListClickListener = listener;
    }

    @NonNull
    @Override
    public CoktailCategorieCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cocktailcategorie_list_cell, parent,false);
        CoktailCategorieCellHolder coktailCategorieCellHolder = new CoktailCategorieCellHolder(view);
        return coktailCategorieCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CoktailCategorieCellHolder holder, int position) {
        holder.titleTextView.setText(dataSource[position].strDrink);
        Picasso.get().load(dataSource[position].strDrinkThumb).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCoktailCategorieListClickListener.onCoktailSearchListClick(dataSource[holder.getAdapterPosition()]);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }

}
