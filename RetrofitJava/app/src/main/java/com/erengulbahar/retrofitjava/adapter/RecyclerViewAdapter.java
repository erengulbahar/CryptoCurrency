package com.erengulbahar.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.erengulbahar.retrofitjava.R;
import com.erengulbahar.retrofitjava.model.CryptoModel;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>
{
    private ArrayList<CryptoModel> cryptoList;
    private String[] colors = {"#abffe5","#e1eef9","#ffc100","#7b9bcc","#f1cdbd","#ffbb9a","#bf95d4","#a7cc7b"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoList)
    {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout,parent,false);

        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position)
    {
        holder.bind(cryptoList.get(position),colors,position);
    }

    @Override
    public int getItemCount()
    {
        return cryptoList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder
    {
        TextView textName;
        TextView textPrice;

        public RowHolder(@NonNull View itemView)
        {
            super(itemView);
        }

        public void bind(CryptoModel cryptoModel,String[] colors,Integer position)
        {
            textName = itemView.findViewById(R.id.textName);
            textPrice = itemView.findViewById(R.id.textPrice);

            textName.setText(cryptoModel.currency);
            textPrice.setText(cryptoModel.price);

            itemView.setBackgroundColor(Color.parseColor(colors[position%8]));
        }
    }
}