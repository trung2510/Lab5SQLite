package com.example.lab5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab5.R;
import com.example.lab5.model.Product;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Product> arrProduct;

    public RecyclerViewAdapter(Context context, List<Product> arrProduct) {
        this.context = context;
        this.arrProduct = arrProduct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Product product = arrProduct.get(i);
        viewHolder.tvName.setText(product.getmName());
        viewHolder.tvPrice.setText(product.getmPrice()+"");
    }

    @Override
    public int getItemCount() {
        return arrProduct.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tvName;
        TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);

        }
    }
}
