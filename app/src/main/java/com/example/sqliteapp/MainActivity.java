package com.example.sqliteapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sqliteapp.dao.AlunoDAO;
import com.example.sqliteapp.model.AlunoVO;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void btnOnClickCadastrarAluno(View view) {
        AlunoDAO alunoDAO = new AlunoDAO(this);

        Log.d("Insert: ", "Inserindo registros no banco de dados...");
        // codigo MOC - gerar base testes
        AlunoVO alunoVO1 = new AlunoVO();
        alunoVO1.setName("Bruno");
        alunoVO1.setMatricula("123456");
        alunoVO1.setEmail("bruno@gmail.com");

        alunoDAO.addAluno(alunoVO1);
        /*------------------------------------------------------------------------------------*/
        Log.d("Insert: ", "Registros inseridos no banco de dados...");

        Log.d("Insert: ", "Inserindo registros no banco de dados...");
        // codigo MOC - gerar base testes
        AlunoVO alunoVO2 = new AlunoVO();
        alunoVO2.setName("Luiz");
        alunoVO2.setMatricula("123456");
        alunoVO2.setEmail("luiz@gmail.com");

        alunoDAO.addAluno(alunoVO2);

        Log.d("Insert: ", "Registros inseridos no banco de dados...");

        Log.d("Insert: ", "Inserindo registros no banco de dados...");
        // codigo MOC - gerar base testes
        AlunoVO alunoVO3 = new AlunoVO();
        alunoVO3.setName("Marco");
        alunoVO3.setMatricula("123456");
        alunoVO3.setEmail("marco@gmail.com");

        alunoDAO.addAluno(alunoVO3);

        Log.d("Insert: ", "Registros inseridos no banco de dados...");
    }

    public void btnOnClickCadastrar(View view) {

    }
}