package com.example.lab2_internalstorage_csi460_mm;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ListViewHolder extends RecyclerView.ViewHolder {

    TextView listItem;

    public ListViewHolder(View v){
        super(v);
        listItem = v.findViewById(R.id.listItemTxt);
    }
}
