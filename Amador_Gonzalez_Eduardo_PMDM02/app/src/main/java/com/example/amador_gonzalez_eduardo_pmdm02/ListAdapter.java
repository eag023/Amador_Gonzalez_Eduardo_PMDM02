package com.example.amador_gonzalez_eduardo_pmdm02;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//Clase del Adapter

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> implements View.OnClickListener {
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nombre;
        ImageView imagen;

        /**
         * Constructor que crea un ListViewHolder
         * @param itemView View al que se le crea el ViewHolder
         */
        ListViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            imagen = (ImageView)itemView.findViewById(R.id.imagen);
        }
    }

    List<Personaje> listaPersonaje;
    Context context;

    /**
     * Constructor que crea el adaptador
     * @param listaPersonaje Lista con los personajes a mostrar
     */
    public ListAdapter(List<Personaje> listaPersonaje, Context context){
        this.listaPersonaje = listaPersonaje;
        this.context = context;
    }

    /**
     * Método que llama el RecyclerView
     * @param recyclerView RecyclerView al que se le asigna el adapter
     */
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    /**
     * Método que crea un ViewHolder
     * @param viewGroup Donde el View se añadirá
     * @param i Tipo del nuevo View
     * @return ListViewHolder creado
     */
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lista_elemento, viewGroup, false);
        ListViewHolder lvh = new ListViewHolder(v);
        return lvh;
    }

    /**
     * Método para establecer la información en cada posición del RecyclerView
     * @param listViewHolder ViewHolder
     * @param i Posición dentro del RecyclerView
     */
    @Override
    public void onBindViewHolder(ListViewHolder listViewHolder, int i) {
        //Mostramos la información del zumo
        listViewHolder.nombre.setText(listaPersonaje.get(i).nombre);
        listViewHolder.imagen.setImageResource(listaPersonaje.get(i).imagen);
        listViewHolder.cv.setOnClickListener(this);
        listViewHolder.cv.setTag(i);
    }

    /**
     * Método para pasar la información a la siguiente actividad
     * @param view View
     */
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, FichaPersonaje.class); //Se crea un Intent para la siguiente actividad
        intent.putExtra("personaje", listaPersonaje.get((Integer) view.getTag())); //Se le pasa el objeto Personaje
        context.startActivity(intent); //Se inicia la actividad
    }

    /**
     * Método que cuenta la cantidad de elementos de la lista
     * @return Número de elementos de la lista
     */
    @Override
    public int getItemCount() {
        return listaPersonaje.size();
    }
}
