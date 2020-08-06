package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.media.Image;

/**
 * Created by ferfe on 09/10/2017.
 */

public class Item {


    private int imagem;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public Item(int imagem, int color) {
        this.imagem = imagem;
        this.color = color;
    }

    public Item(int color){
        this.imagem = imagem;
    }
}
