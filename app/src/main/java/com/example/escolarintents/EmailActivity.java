package com.example.escolarintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EmailActivity extends AppCompatActivity {

    EditText txtto, txtsubject, txtmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        txtto = (EditText)findViewById(R.id.txt_to);
        txtsubject = (EditText)findViewById(R.id.txt_subject);
        txtmessage = (EditText)findViewById(R.id.txt_message);

        Button  btnsend = (Button)findViewById(R.id.btn_send);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMail();
            }
        });
    }
    private void sendMail(){
        String recipientList = txtto.getText().toString();
        String[] recipient = recipientList.split(",");

        String subject = txtsubject.getText().toString();
        String message = txtmessage.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, recipient);
        intent.putExtra(intent.EXTRA_SUBJECT, subject);
        intent.putExtra(intent.EXTRA_TEXT, message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"email client"));
    }
}