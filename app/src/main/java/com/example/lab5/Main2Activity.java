package com.example.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.lab5.DAO.ProductDAO;
import com.example.lab5.adapter.RecyclerViewAdapter;
import com.example.lab5.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    List<Product> listProducts = new ArrayList<>();
    ProductDAO productDAO;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        productDAO = new ProductDAO(Main2Activity.this);

        listProducts = productDAO.getAllProduct();
        Log.e("abc", String.valueOf(listProducts.size()));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        recyclerViewAdapter = new RecyclerViewAdapter(this,listProducts);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(recyclerViewAdapter);

    }
}
