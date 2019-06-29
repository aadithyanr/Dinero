package com.trinet.dinero.Entities.Model;

import java.util.ArrayList;

/**
 * Created by Aadithyan Rajeshon 08/10/2017.
 */

public class Quotes {

    ArrayList<QuoteModel> arrayList = new ArrayList<>();

    public void setArrayList(ArrayList<QuoteModel> arrayList) {
        this.arrayList = arrayList;
    }

    public ArrayList<QuoteModel> getArrayList() {
        return arrayList;
    }
}
