package com.example.lab5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab5.DAO.ProductDAO;
import com.example.lab5.database.DataBase;
import com.example.lab5.model.Product;

public class MainActivity extends AppCompatActivity {

     EditText edtName;
     EditText edtPrice;
     Button btnInsert;
     ProductDAO productDAO;
    private Button btnUpdate;


    DataBase dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
    }

    private void AnhXa() {

        edtName = (EditText) findViewById(R.id.edt_name);
        edtPrice = (EditText) findViewById(R.id.edt_price);
        btnInsert = (Button) findViewById(R.id.btn_insert);

        btnUpdate = (Button) findViewById(R.id.btn_update);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productDAO = new ProductDAO(MainActivity.this);
                Product product = new Product(edtName.getText().toString().trim(),Double.parseDouble(edtPrice.getText().toString().trim()));
                if (productDAO.insertProduct(product) > 0){
                    Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        try {
            if (intent != null){
                Bundle bundle = intent.getBundleExtra("bun");
                edtName.setText(bundle.getString("name"));
                edtPrice.setText(bundle.getDouble("price")+"");
            }
        }
        catch (Exception e){
            Log.e("", e.getMessage());
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productDAO = new ProductDAO(MainActivity.this);
                Product product = new Product(edtName.getText().toString().trim(),Double.parseDouble(edtPrice.getText().toString().trim()));
                if (productDAO.updateProduct(product) > 0){
                    Toast.makeText(MainActivity.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Sửa thất bại", Toast.LENGTH_SHORT).show();
                }

                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



    }
}
