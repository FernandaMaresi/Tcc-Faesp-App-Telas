package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import a1telas.aba1.cursoandroid.ferfe.aba11telas.BDHelper.MembrosBd;
import a1telas.aba1.cursoandroid.ferfe.aba11telas.Model.Membros;

public class Cadastro extends AppCompatActivity {

    ListView lista;
    MembrosBd bdHelper;
    ArrayList<Membros> listViewMembros;
    Membros membro;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);


        Button btnCadastrar = (Button) findViewById(R.id.btn_CadastrarId);
        btnCadastrar.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, FormularioMembros.class);
                startActivity(intent);
            }
        });

        lista = (ListView) findViewById(R.id.listViewMembros);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

                Membros membroEscolhido = (Membros) adapter.getItemAtPosition(position);

                Intent i = new Intent(Cadastro.this, FormularioMembros.class);
                i.putExtra("membro-escolhido", membroEscolhido);
                startActivity(i);
            }
        });

        lista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                membro = (Membros) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar Este Membro");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bdHelper = new MembrosBd(Cadastro.this);
                bdHelper.deletarMembro(membro);
                bdHelper.close();
                carregarMembro();
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarMembro();
    }

    public void carregarMembro(){
        bdHelper = new MembrosBd(Cadastro.this);
        listViewMembros = bdHelper.getLista();
        bdHelper.close();

        if (listViewMembros != null){
            adapter = new ArrayAdapter<Membros>(Cadastro.this, android.R.layout.simple_list_item_1,listViewMembros);
            lista.setAdapter(adapter);
            Log.i("MainActivity", "Teste");
        }
        //  finish();
    }

}
