package com.cursoandroid.pedrapapeloutesoura;

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

    public void selecionadoPedra(View view){

        this.opcaoSelecionada("pedra");
    }


    public void selecionadoPapel(View view){

        this.opcaoSelecionada("papel");
    }


    public void selecionadoTesoura(View view){

        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoselecionada){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoes = {"pedra","papel","tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;

        }

        if (
                (opcaoApp == "tesoura" && opcaoselecionada == "papel") ||
                        (opcaoApp == "papel" && opcaoselecionada == "pedra") ||
                        (opcaoApp == "pedra" && opcaoselecionada == "tesoura")
        ){// app ganhador
            textoResultado.setText("Você perdeu :(");

        }else if (
                (opcaoselecionada == "tesoura" && opcaoApp == "papel") ||
                        (opcaoselecionada == "papel" && opcaoApp == "pedra") ||
                        (opcaoselecionada == "pedra" && opcaoApp == "tesoura")
        ){// usuario ganhador
            textoResultado.setText("Você ganhou :)");
        }else { // empate
            textoResultado.setText("Empatamos ;)");
        }

        System.out.println("item clicado:" + opcaoApp);



    }


}
