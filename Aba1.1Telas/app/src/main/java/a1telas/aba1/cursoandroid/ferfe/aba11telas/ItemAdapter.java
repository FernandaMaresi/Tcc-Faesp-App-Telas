package a1telas.aba1.cursoandroid.ferfe.aba11telas;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * Created by ferfe on 09/10/2017.
 */

public class ItemAdapter extends BaseQuickAdapter<Item, BaseViewHolder>{

    public ItemAdapter(@Nullable List<Item> data) {
        super(R.layout.menu_item,data);
    }
    @Override
    protected void convert(BaseViewHolder helper, Item item) {
        helper.setImageDrawable(R.id.image, mContext.getDrawable(item.getImagem()));
        helper.setImageDrawable(R.id.button2,mContext.getDrawable(item.getColor()));

    }
}
