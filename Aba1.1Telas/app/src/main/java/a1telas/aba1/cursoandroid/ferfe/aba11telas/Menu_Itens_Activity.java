package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class Menu_Itens_Activity extends AppCompatActivity {

    RecyclerView recycler;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__itens_);

        recycler = (RecyclerView) findViewById(R.id.recycler);

        recycler.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ItemAdapter(getItens());
        recycler.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(position == 0){
                    startActivity(new Intent(Menu_Itens_Activity.this, SetoresActivity.class));

                }else {
                    Toast.makeText(getBaseContext(), "Chegou aqui", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private List<Item> getItens(){
        List<Item> itens = new ArrayList<>();
        itens.add(new Item(R.drawable.menu_celula,R.drawable.cor1));
        itens.add(new Item(R.drawable.menu_culto_de_oracao,R.drawable.cor2));
        itens.add(new Item(R.drawable.menu_visao_mda, R.drawable.cor3));
        itens.add(new Item(R.drawable.menu_news, R.drawable.cor4));
        itens.add(new Item(R.drawable.menu_celula,R.drawable.cor1));
        itens.add(new Item(R.drawable.menu_culto_de_oracao,R.drawable.cor2));
        itens.add(new Item(R.drawable.menu_visao_mda, R.drawable.cor3));
        itens.add(new Item(R.drawable.menu_news, R.drawable.cor4));

        return itens;
    }
}
