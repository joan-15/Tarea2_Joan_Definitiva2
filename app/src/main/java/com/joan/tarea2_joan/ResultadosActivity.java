package com.joan.tarea2_joan;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultadosActivity extends AppCompatActivity {

    private TextView resultadoLado3, resultadoSinAngulo, resultadoCosAngulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        resultadoLado3 = findViewById(R.id.resultado_lado3);
        resultadoSinAngulo = findViewById(R.id.resultado_sin_angulo);
        resultadoCosAngulo = findViewById(R.id.resultado_cos_angulo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            double lado3 = extras.getDouble("lado3");
            double sinAngulo = extras.getDouble("sinAngulo");
            double cosAngulo = extras.getDouble("cosAngulo");

            resultadoLado3.setText("Lado 3 del triángulo: " + lado3);
            resultadoSinAngulo.setText("Sin del ángulo: " + sinAngulo);
            resultadoCosAngulo.setText("Cos del ángulo: " + cosAngulo);
        }
    }
}
