package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botaoMenu;
    private Button botaoCadastrarSe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoMenu = (Button) findViewById(R.id.menu_button_Id);
        botaoCadastrarSe = (Button) findViewById(R.id.botao_CadastrarSeId);


        botaoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Menu_Itens_Activity.class));
            }
        });

       botaoCadastrarSe.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this, Cadastro.class));
           }
       });



    }

}

