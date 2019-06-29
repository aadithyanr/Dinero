package com.trinet.dinero.Views.ViewHolders;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.trinet.dinero.Entities.Model.ThemeModel;
import com.trinet.dinero.Modules.OnThemeSelectedListener;
import com.trinet.dinero.Supports.Data.SimpleCache;
import com.trinet.dinero.databinding.ItemThemeBinding;

/**
 * Created by Aadithyan Rajeshon 08/10/2017.
 */

public class SettingThemeViewHolder extends RecyclerView.ViewHolder {

    ItemThemeBinding content;

    public SettingThemeViewHolder(View itemView) {
        super(itemView);
        content = DataBindingUtil.bind(itemView);
    }

    public void onBind(Context context, final ThemeModel model, String selectedName, final OnThemeSelectedListener listener){

        if (model.getName().equalsIgnoreCase(selectedName)){
            content.txtHarga.setText("Selected");
            content.containerHarga.setSelected(true);
        }else{
            content.txtHarga.setText("Choose me");
            content.containerHarga.setSelected(false);
        }
        content.txtNama.setText(model.getName());
        content.img.setImageResource(model.getImage());

        content.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onThemeSelected(model.getName());
            }
        });
    }
}
