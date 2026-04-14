package com.example.vistastudio;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(android.R.id.content), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configuración de clics para los botones (Ejemplos)
        findViewById(R.id.bnvMain).setOnClickListener(v -> {
            Toast.makeText(this, "Navegación inferior clickeada", Toast.LENGTH_SHORT).show();
        });

        // Ejemplo de interacción con un botón de subasta
        // Nota: Como es una lista estática en el XML, referenciamos por ID si los tuvieran, 
        // o podrías implementar un RecyclerView para una lista dinámica real.
    }
}