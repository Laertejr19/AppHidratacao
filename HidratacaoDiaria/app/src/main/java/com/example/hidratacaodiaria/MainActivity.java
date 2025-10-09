package com.example.hidratacaodiaria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText pesoUsuario, idadeUsuario, qtdAtual;
    RadioGroup grupoRadio;
    Button botaoCalcular;
    TextView mostrarMeta, mostrarRestante, mostrarMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // conectando os componentes do layout
        pesoUsuario = findViewById(R.id.peso);
        idadeUsuario = findViewById(R.id.idade);
        qtdAtual = findViewById(R.id.quantidade);
        grupoRadio = findViewById(R.id.atividade);
        botaoCalcular = findViewById(R.id.calcular);
        mostrarMeta = findViewById(R.id.meta);
        mostrarRestante = findViewById(R.id.restante);
        mostrarMensagem = findViewById(R.id.mensagem);

        // clique no botão
        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // verifica se os campos estão vazios
                if (pesoUsuario.getText().toString().equals("") ||
                        idadeUsuario.getText().toString().equals("") ||
                        qtdAtual.getText().toString().equals("")) {

                    mostrarMensagem.setText("preencha todos os campos");
                    return; // para aqui se tiver vazio
                }

                // convertendo valores para numeros
                double peso = Double.parseDouble(pesoUsuario.getText().toString());
                int idade = Integer.parseInt(idadeUsuario.getText().toString());
                int quantidade = Integer.parseInt(qtdAtual.getText().toString());

                // verifica se a pessoa é maior de idade
                if (idade < 18) {
                    AlertDialog alert = new AlertDialog.Builder(MainActivity.this)
                            .setTitle("aviso")
                            .setMessage("este app é para maiores de 18 anos")
                            .setPositiveButton("OK", null)
                            .create();
                    alert.show();
                    return;
                }

                // calcula base de consumo
                int consumoBase = (int)(peso * 35);
                int extra = 0;

                // verificando atividade
                int idAtividadeSelecionada = grupoRadio.getCheckedRadioButtonId();

                if (idAtividadeSelecionada == R.id.sedentario) {
                    extra = 0;
                }

                if (idAtividadeSelecionada == R.id.moderado) {
                    extra = 300;
                }

                if (idAtividadeSelecionada == R.id.intenso) {
                    extra = 600;
                }

                // calcula total e faltante
                int total = consumoBase + extra;
                int faltam = total - quantidade;

                // exibindo resultados
                mostrarMeta.setText("meta diária: " + total + " ml");
                if (faltam > 0) {
                    mostrarRestante.setText("faltam: " + faltam + " ml");
                    mostrarMensagem.setText("continue se hidratando");
                } else {
                    mostrarRestante.setText("faltam: 0 ml");
                    mostrarMensagem.setText("parabens por atingir a meta");
                }

                // só pra conferir no log (coisa que estudante faz)
                System.out.println("DEBUG: total=" + total + " faltam=" + faltam);

            }
        });
    }
}