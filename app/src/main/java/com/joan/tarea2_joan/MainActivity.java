package com.joan.tarea2_joan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText entradaAngulo, entradaLado1, entradaLado2;
    private Button botonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entradaAngulo = findViewById(R.id.entrada_angulo);
        entradaLado1 = findViewById(R.id.entrada_lado1);
        entradaLado2 = findViewById(R.id.entrada_lado2);
        botonCalcular = findViewById(R.id.boton_calcular);

        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validarEntradas()) {
                    double angulo = Double.parseDouble(entradaAngulo.getText().toString());
                    double lado1 = Double.parseDouble(entradaLado1.getText().toString());
                    double lado2 = Double.parseDouble(entradaLado2.getText().toString());

                    // Ley de Cosenos
                    double cosAngulo = Math.cos(Math.toRadians(angulo));
                    double lado3 = Math.sqrt(lado1 * lado1 + lado2 * lado2 - 2 * lado1 * lado2 * cosAngulo);

                    double sinAngulo = Math.sin(Math.toRadians(angulo));

                    Intent intent = new Intent(MainActivity.this, ResultadosActivity.class);
                    intent.putExtra("lado3", lado3);
                    intent.putExtra("sinAngulo", sinAngulo);
                    intent.putExtra("cosAngulo", cosAngulo);
                    startActivity(intent);
                }
            }
        });
    }

    private boolean validarEntradas() {
        if (entradaAngulo.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa el ángulo", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (entradaLado1.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa el lado 1 del triángulo", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (entradaLado2.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor ingresa el lado 2 del triángulo", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
