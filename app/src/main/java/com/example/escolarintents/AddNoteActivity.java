package com.example.escolarintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddNoteActivity extends AppCompatActivity {

    private  BDSQLiteHelper bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        bd = new BDSQLiteHelper(this);

        final EditText titulo =(EditText)findViewById(R.id.editTextAddTitle);
        final EditText descri = (EditText)findViewById(R.id.editTextAddDescri);
        Button btn_add = (Button)findViewById(R.id.btn_add_note);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();
                note.setTitulo(titulo.getText().toString());
                note.setDescricao(descri.getText().toString());
                bd.addNote(note);

                Toast.makeText(getBaseContext(), "Anotação adicionada com sucesso", Toast.LENGTH_SHORT).show();
            }
        });
    }
}