package com.example.escolarintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText urlogin, urpassword, urnome;
    Button clk;

    public  final static String EXTRA_MESSAGE_LOGIN = "com.example.EscolarApplication.LOGIN";
    public final static String EXTRA_MESSAGE_PASSWORD = "com.example.EscolarApplication.PASSWORD";
    public  final static String EXTRA_MESSAGE_NOME = "com.example.EscolarApplication.NOME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        urnome = (EditText)findViewById(R.id.editTextNome);
        urlogin = (EditText)findViewById(R.id.editTextLogin);
        urpassword = (EditText)findViewById(R.id.editTextPassword);
        clk = (Button)findViewById(R.id.btnLogin);

        clk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, WelcomeActivity.class);
                in.putExtra("EXTRA_MESSAGE_NOME", urnome.getText().toString());
                in.putExtra("EXTRA_MESSAGE_LOGIN", urlogin.getText().toString());
                in.putExtra("EXTRA_MESSAGE_PASSWORD", urpassword.getText().toString());
                startActivity(in);
                finish();
            }
        });
    }

}