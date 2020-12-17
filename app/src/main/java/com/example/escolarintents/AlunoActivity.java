package com.example.escolarintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AlunoActivity extends AppCompatActivity {

    TextView alunotel,alunoemail;
    Button btnemail, btncall,btnmaps,btnnote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aluno);
        btncall = (Button)findViewById(R.id.btn_aluno_telefone);
        btnemail= (Button)findViewById(R.id.btn_aluno_email);
        alunotel = (TextView)findViewById(R.id.txt_aluno_telefone);
        alunoemail = (TextView)findViewById(R.id.txt_aluno_emaill);
        btnmaps = (Button)findViewById(R.id.btn_maps);
        btnnote = (Button)findViewById(R.id.btn_note);

        btnemail.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in = new Intent(AlunoActivity.this, EmailActivity.class);
                        startActivity(in);
            }
        });

        btncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AlunoActivity.this, CallActivity.class);
                startActivity(in);
            }
        });

        btnmaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AlunoActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        btnnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(AlunoActivity.this, FeedActivity.class);
                startActivity(in);
            }
        });
    }
}