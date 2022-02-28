package com.example.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResult = findViewById(R.id.imageResult);
        TextView textResult = findViewById(R.id.textResult);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {
            case "pedra":
                imageResult.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResult.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResult.setImageResource(R.drawable.tesoura);
                break;
        }

        if (
                (opcaoApp == "pedra" && opcaoSelecionada == "tesoura") ||
                        (opcaoApp == "tesoura" && opcaoSelecionada == "papel") ||
                        (opcaoApp == "papel" && opcaoSelecionada == "pedra")
        ) {
            textResult.setText("Você perdeu!");
        } else if (
                (opcaoApp == "papel" && opcaoSelecionada == "tesoura") ||
                        (opcaoApp == "tesoura" && opcaoSelecionada == "pedra") ||
                        (opcaoApp == "pedra" && opcaoSelecionada == "papel")
        ) {
            textResult.setText("Você ganhou!");
        } else {
            textResult.setText("Empate, tente novamente...");
        }
    }
}