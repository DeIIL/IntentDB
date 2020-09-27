package com.example.escolarintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CallActivity extends AppCompatActivity {

    Button btnligar;
    TextView nmrligar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        btnligar = (Button)findViewById(R.id.btn_ligar);
        nmrligar = (TextView)findViewById(R.id.txt_call);

        btnligar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero = nmrligar.getText().toString();
                Uri uri = Uri.parse("tel:"+numero);

                Intent in = new Intent(Intent.ACTION_CALL, uri);
                if (ActivityCompat.checkSelfPermission(CallActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(CallActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 1);
                    return;
                }
                startActivity(in);
            }
        });
    }
}