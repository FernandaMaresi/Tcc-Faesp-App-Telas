package a1telas.aba1.cursoandroid.ferfe.aba11telas.Model;

import java.io.Serializable;

/**
 * Created by ferfe on 15/10/2017.
 */

public class Membros implements Serializable {

    private Long id;
    private String nomeMembro;
    private String endereco;
    private int idade;

    @Override
    public String toString(){
        return nomeMembro.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMembro() {
        return nomeMembro;
    }

    public void setNomeMembro(String nomeMembro) {
        this.nomeMembro = nomeMembro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
