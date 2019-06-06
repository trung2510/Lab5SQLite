package com.example.lab5.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab5.DAO.ProductDAO;
import com.example.lab5.Main2Activity;
import com.example.lab5.MainActivity;
import com.example.lab5.R;
import com.example.lab5.model.Product;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    List<Product> arrProduct;
    ProductDAO productDAO;

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
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        final Product product = arrProduct.get(i);
        viewHolder.tvName.setText(product.getmName());
        viewHolder.tvPrice.setText(product.getmPrice()+"");

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Sửa", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, MainActivity.class);
                Bundle bundle = new Bundle();
                Product product1 = arrProduct.get(i);
                bundle.putString("name",product1.getmName());
                bundle.putDouble("price",product1.getmPrice());
                intent.putExtra("bun",bundle);
                context.startActivity(intent);
            }
        });

        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                productDAO = new ProductDAO(context);

                Product product1 = arrProduct.get(i);

                if (productDAO.deleteProduct(product1.getmId())>0){
                    arrProduct.remove(arrProduct.get(i));

                    notifyDataSetChanged();

                    List<Product>  listProducts = productDAO.getAllProduct();
                    Log.e("BBBB", String.valueOf(listProducts.size()));

                    Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

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
