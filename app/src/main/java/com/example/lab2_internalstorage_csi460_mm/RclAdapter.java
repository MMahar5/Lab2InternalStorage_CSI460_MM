package com.example.lab2_internalstorage_csi460_mm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RclAdapter extends RecyclerView.Adapter<ListViewHolder> {

    private List<String> listItems;
    private LayoutInflater inflater;

    public RclAdapter(Context context, List<String> listItem){
        this.inflater = LayoutInflater.from(context);
        this.listItems = listItem;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.list_item, parent, false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        String newItem = listItems.get(position);
        holder.listItem.setText(newItem);
    }

    @Override
    public int getItemCount() {
        return (listItems != null) ? listItems.size() : 0;
    }
}
