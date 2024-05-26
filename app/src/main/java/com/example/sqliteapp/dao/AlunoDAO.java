package com.example.sqliteapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.sqliteapp.model.AlunoVO;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AlunoDAO extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "IESB_DB";
    private static final String TB_ALUNOS = "tb_alunos";

    private static final String KEY_ID = "id";
    private static final String NOME = "name";
    private static final String MATRICULA = "matricula";
    private static final String EMAIL = "email";

    public AlunoDAO(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TB_ALUNOS = "CREATE TABLE " + TB_ALUNOS + "("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + NOME + " TEXT, "
                + MATRICULA + " TEXT, "
                + EMAIL + " TEXT )";
        db.execSQL(CREATE_TB_ALUNOS);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_ALUNOS);
        onCreate(db);
    }

    public void  addAluno(AlunoVO alunoVO) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NOME, alunoVO.getName());
        contentValues.put(MATRICULA, alunoVO.getMatricula());
        contentValues.put(EMAIL, alunoVO.getEmail());

        db.insert(TB_ALUNOS, null, contentValues);
        db.close();
    }

    public List<AlunoVO> getAllAlunos() {
        List<AlunoVO> ltAlunos = new ArrayList<AlunoVO>();
        String selectQuery = "SELECT * FROM " + TB_ALUNOS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()) {
            do {
                AlunoVO alunoVO = new AlunoVO();
                alunoVO.setId((Integer.parseInt(cursor.getString(0))));
                alunoVO.setName(cursor.getString(1));
                alunoVO.setMatricula(cursor.getString(2));
                alunoVO.setEmail(cursor.getString(3));

                ltAlunos.add(alunoVO);
            } while (cursor.moveToNext());
        }
        return ltAlunos;
    }
}
