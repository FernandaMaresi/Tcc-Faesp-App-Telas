package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

public class SetoresActivity extends AppCompatActivity {

    RecyclerView recycler2;
    ItemAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setores);


        recycler2 = (RecyclerView) findViewById(R.id.recycler_setores_Id);

        recycler2.setLayoutManager(new LinearLayoutManager(this));

       // adapter2 = new ItemAdapter(getItens2());
        recycler2.setAdapter(adapter2);

        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if(position == 0){
                    startActivity(new Intent(SetoresActivity.this, MainActivity.class));

                }else {
                    Toast.makeText(getBaseContext(), "Chegou aqui", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
//
//    private List<Item> getItens2(){
//        List<Item> itens = new ArrayList<>();
//        itens.add(new Item(R.drawable.cor1));
//        itens.add(new Item(R.drawable.cor2));
//        itens.add(new Item(R.drawable.cor3));
//        itens.add(new Item(R.drawable.cor4));
//        itens.add(new Item(R.drawable.cor1));
//        itens.add(new Item(R.drawable.cor2));
//        itens.add(new Item(R.drawable.cor3));
//        itens.add(new Item(R.drawable.cor4));
//
//        return itens;
//    }
}
