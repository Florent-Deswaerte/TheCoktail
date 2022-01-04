package com.florent.thecoktail;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchFragment extends Fragment {

    Button RechercherButton;
    EditText RechercherPlainText;
    Fragment CocktailCategoryFragment;
    TextView textView2;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RechercherPlainText = view.findViewById(R.id.RechercherPlainText);
        textView2 = view.findViewById(R.id.textView2);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup
            container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_search, container, false);
        Button RechercherButton = (Button) view.findViewById(R.id.RechercherButton);
        RechercherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = (RechercherPlainText.getText()).toString();
                CocktailCategoryFragment = new CocktailSearchFragment(name);
                textView2.setText("Idiot");
                loadFragment(CocktailCategoryFragment);
            }
        });
        return view;
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment != null){
            getFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
            return true;
        }
        return false;
    }
}
