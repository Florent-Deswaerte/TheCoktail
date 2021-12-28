package com.florent.thecoktail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class categorieListAdapter extends RecyclerView.Adapter<CategorieCellHolder> {
    private Categorie[] dataSource;
    public categorieListAdapter(Categorie[] dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public CategorieCellHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categorie_list_cell, parent,false);
        CategorieCellHolder categorieCellHolder = new CategorieCellHolder(view);
        return categorieCellHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieCellHolder holder, int position) {
        holder.categorieTextView.setText(dataSource[position].getCategorie());
    }

    @Override
    public int getItemCount() {
        if (this.dataSource != null) {
            return this.dataSource.length;
        }
        return 0;
    }

}
