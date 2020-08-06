package a1telas.aba1.cursoandroid.ferfe.aba11telas.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import a1telas.aba1.cursoandroid.ferfe.aba11telas.Model.Membros;


/**
 * Created by ferfe on 15/10/2017.
 */

public class MembrosBd extends SQLiteOpenHelper {

    private static final String DATABASE = "bdmembros";
    private static final int VERSION = 1;

    public MembrosBd (Context context){
        super(context, DATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String membro = "CREATE TABLE membros(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nomemembro TEXT NOT NULL, endereco TEXT NOT NULL, idade INTEGER);";
        db.execSQL(membro);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String membro = "DROP TABLE IF EXISTS membros";
        db.execSQL(membro);
    }

    //aqui salva
    public void salvarMembro(Membros membro){
        ContentValues values  = new ContentValues();

        values.put("nomemembro",membro.getNomeMembro());
        values.put("endereco",membro.getEndereco());
        values.put("idade", membro.getIdade());

        getWritableDatabase().insert("membros", null, values);
    }
    //metodo alterar concluido
    public void alterarMembro(Membros membro){
        ContentValues values  = new ContentValues();

        values.put("nomemembro",membro.getNomeMembro());
        values.put("endereco",membro.getEndereco());
        values.put("idade", membro.getIdade());

        String[] args = {membro.getId().toString()};
        getWritableDatabase().update("membros", values, "id=?", args);
    }

    public void deletarMembro(Membros membro){
        String [] args = {membro.getId().toString()};
        getWritableDatabase().delete("membros","id=?",args);
    }


    //lista - mostrar
    public ArrayList<Membros> getLista(){
        String [] columns = {"id","nomemembro","endereco", "idade"};
        Cursor cursor = getWritableDatabase().query("membros", columns, null,null,null,null,null,null);

        ArrayList<Membros> membros = new ArrayList<Membros>();

        while (cursor.moveToNext()){
            Membros membro = new Membros();
            membro.setId(cursor.getLong(0));
            membro.setNomeMembro(cursor.getString(1));
            membro.setEndereco(cursor.getString(2));
            membro.setIdade(cursor.getInt(3));

            membros.add(membro);
        }
        return membros;
    }


}
