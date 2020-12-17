package com.example.escolarintents;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FeedActivity extends AppCompatActivity {

    private EditText descri;
    private EditText title;
    private Button btnsave;
    Button btnbd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }

        title = (EditText)findViewById(R.id.editTexttitlenote);
        descri = (EditText)findViewById(R.id.editTextdescrinote);
        btnsave = (Button)findViewById(R.id.btnsave);
        btnbd = (Button) findViewById(R.id.btn_bd);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String conteud = title.getText().toString();
                salvarArquivo(conteud);
            }
        });

        btnbd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FeedActivity.this, AddNoteActivity.class);
                startActivity(in);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);{
            switch (requestCode){
                case 1000:
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"Permissão Concedida", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Permissão não Concedida", Toast.LENGTH_SHORT).show();
                        finish();
                    }
            }
        }
    }

    private void salvarArquivo(String conteudoArquivo){

        File folder = new File(Environment.getExternalStorageDirectory() + "Pasta_Note/");
        if(folder.exists()){
            folder.mkdir();
        }
        String nomearquivo = title.getText().toString();
        File arquivo = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), "/Pasta_Note/" + nomearquivo);
        try {
            FileOutputStream salvar = new FileOutputStream(arquivo);
            salvar.close();
            Toast.makeText(this, "Arquivo Salvo", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e){
            e.printStackTrace();
            Toast.makeText(this, "Arquivo não Encontrado", Toast.LENGTH_SHORT).show();
        } catch (IOException e){
            e.printStackTrace();
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }

}