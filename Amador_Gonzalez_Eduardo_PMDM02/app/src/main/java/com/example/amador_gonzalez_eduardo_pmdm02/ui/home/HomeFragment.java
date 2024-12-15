package com.example.amador_gonzalez_eduardo_pmdm02.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amador_gonzalez_eduardo_pmdm02.ListAdapter;
import com.example.amador_gonzalez_eduardo_pmdm02.Personaje;
import com.example.amador_gonzalez_eduardo_pmdm02.R;
import com.example.amador_gonzalez_eduardo_pmdm02.databinding.FragmentHomeBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    List<Personaje> elementos;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        init();

        return root;
    }

    public void init(){
        elementos = new ArrayList<>(); //Creamos la lista que guardará los elementos para luego mostrarla en el RecyclerView
        elementos.add(new Personaje(R.drawable.mario, getResources().getString(R.string.mario), R.string.hMario, R.string.dMario));
        elementos.add(new Personaje(R.drawable.luigi, getResources().getString(R.string.luigi), R.string.hLuigi, R.string.dLuigi));
        elementos.add(new Personaje(R.drawable.peach, getResources().getString(R.string.peach), R.string.hPeach, R.string.dPeach));
        elementos.add(new Personaje(R.drawable.toad, getResources().getString(R.string.toad), R.string.hToad, R.string.dToad));

        ListAdapter listAdapter =  new ListAdapter(elementos, getContext());
        RecyclerView recyclerView = binding.getRoot().findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}