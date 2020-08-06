package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import a1telas.aba1.cursoandroid.ferfe.aba11telas.BDHelper.MembrosBd;
import a1telas.aba1.cursoandroid.ferfe.aba11telas.Model.Membros;

public class FormularioMembros extends AppCompatActivity {

    EditText editTextNome,editTextEndereco,editTextIdade;
    Button btn_Polimorfismo;
    Membros editarMembro;
    Membros membro;
    MembrosBd bdHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_membros);

        membro = new Membros();
        bdHelper = new MembrosBd(FormularioMembros.this);

        bdHelper = new MembrosBd(FormularioMembros.this);

        Intent intent = getIntent();
        editarMembro = (Membros) intent.getSerializableExtra("membro-escolhido");

        editTextNome = (EditText) findViewById(R.id.editTextNomeId);
        editTextEndereco = (EditText) findViewById(R.id.editTextEnderecoId);
        editTextIdade = (EditText) findViewById(R.id.editTextIdadeId);

        btn_Polimorfismo = (Button) findViewById(R.id.btn_Polimorfismo);

        if(editarMembro != null){
            btn_Polimorfismo.setText("Modificar Membro");
            editTextNome.setText(editarMembro.getNomeMembro());
            editTextEndereco.setText(editarMembro.getEndereco());
            editTextIdade.setText(editarMembro.getIdade()+"");

            membro.setId(editarMembro.getId());
        }else{
            btn_Polimorfismo.setText("Cadastrar Novo Membro");
        }




        btn_Polimorfismo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                membro.setNomeMembro(editTextNome.getText().toString());
                membro.setEndereco(editTextEndereco.getText().toString());
                membro.setIdade(Integer.parseInt(editTextIdade.getText().toString()));

                if (btn_Polimorfismo.getText().toString().equals("Cadastrar Novo Membro")){
                    bdHelper.salvarMembro(membro);
                    bdHelper.close();
                    ShowMessage("Salvo com sucesso");
                    onBackPressed();

                }else{
                    bdHelper.alterarMembro(membro);
                    bdHelper.close();
                }
            }

        });

    }
    private void ShowMessage(String texto){
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

    }

}
