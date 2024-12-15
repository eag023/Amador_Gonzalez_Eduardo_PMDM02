package com.example.amador_gonzalez_eduardo_pmdm02;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FichaPersonaje extends AppCompatActivity {

    Personaje personaje;
    ImageView imagen;
    TextView nombre, habilidad, descripcion;

    /**
     * Método que crea la actividad
     * @param savedInstanceState Bundle que guarda el estado de la actividad
     * @return Valor booleano en true para que se realice la acción
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ficha_personaje);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        personaje= (Personaje) getIntent().getSerializableExtra("personaje");

        imagen=findViewById(R.id.imagenFicha);
        nombre=findViewById(R.id.nombreFicha);
        habilidad=findViewById(R.id.habilidadFicha);
        descripcion=findViewById(R.id.descripcionFicha);

        imagen.setImageResource(personaje.getImagen());
        nombre.setText(personaje.getNombre());
        habilidad.setText(personaje.getHabilidades());
        descripcion.setText(personaje.getDescripcion());

        Toast.makeText(this, getResources().getString(R.string.seleccionado) +" "+ personaje.getNombre(), Toast.LENGTH_SHORT).show();
    }
}