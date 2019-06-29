package com.trinet.dinero.Views.Activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import com.trinet.dinero.Entities.List.ListCurrency;
import com.trinet.dinero.Entities.Model.Currency;
import com.trinet.dinero.Modules.OnCurrencySelectedListener;
import com.trinet.dinero.R;
import com.trinet.dinero.Supports.Data.SimpleCache;
import com.trinet.dinero.Supports.Utils.Adapter;
import com.trinet.dinero.Supports.Utils.StaticVariable;
import com.trinet.dinero.Views.ViewHolders.CurrencyViewHolder;
import com.trinet.dinero.databinding.ActivityCurrencyBinding;

/**
 * Created by Aadithyan Rajeshon 13/10/2017.
 */

public class CurrencyActivity extends AppCompatActivity implements View.OnClickListener, OnCurrencySelectedListener{

    ActivityCurrencyBinding content;
    SimpleCache simpleCache;
    ListCurrency currency;
    List<Currency> currencies;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        content = DataBindingUtil.setContentView(this, R.layout.activity_currency);
        simpleCache = new SimpleCache(this);
        currency = new ListCurrency();
        currencies = currency.getArrayList();
        content.btnBack.setOnClickListener(this);
        content.btnClear.setOnClickListener(this);

        content.editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                List<Currency> temp = new ArrayList<>();
                for (Currency currency: currencies){
                    if (currency.getCountry().toLowerCase().contains(s.toString().toLowerCase())){
                        temp.add(currency);
                    }
                }

                setList(temp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        setList(currencies);
    }

    void setList(List<Currency> currencies){

        if (simpleCache.getObject(StaticVariable.CURRENCY_SELECTED, Currency.class) != null){
            Currency currency = simpleCache.getObject(StaticVariable.CURRENCY_SELECTED, Currency.class);
            content.txtNama.setText(currency.getCountry());
            content.txtSymbol.setText(currency.getSymbol());
        }
        Adapter<Currency, CurrencyViewHolder> adapter = new Adapter<Currency, CurrencyViewHolder>(R.layout.item_currency, CurrencyViewHolder.class,
                Currency.class, currencies) {
            @Override
            protected void bindView(CurrencyViewHolder holder, Currency model, int position) {
                holder.onBind(model, CurrencyActivity.this);
            }
        };

        final LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        content.list.setLayoutManager(manager);
        content.list.setAdapter(adapter);
        content.list.setHasFixedSize(true);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == content.btnBack.getId()){
            onBackPressed();
        }else if (v.getId() == content.btnClear.getId()){
            content.editSearch.setText("");
        }
    }

    @Override
    public void onCurrencySelected(Currency model) {
        simpleCache.putObject(StaticVariable.CURRENCY_SELECTED, model);
        finish();
    }
}
