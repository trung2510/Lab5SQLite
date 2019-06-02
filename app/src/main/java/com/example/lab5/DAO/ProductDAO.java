package com.example.lab5.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.lab5.database.DataBase;
import com.example.lab5.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    DataBase dataBase;
    SQLiteDatabase db;

    public static final String TABLE_NAME = "Product";
    public static final String SQL_PRODUCT = "CREATE TABLE Product(id PRIMARY KEY, name text, price double);";

    public ProductDAO(Context context) {
        dataBase = new DataBase(context);
        db = dataBase.getWritableDatabase();
    }

    public int insertProduct(Product product){
        ContentValues values = new ContentValues();
        values.put("name",product.getmName());
        values.put("price",product.getmPrice());

        try {
            if (db.insert(TABLE_NAME,null,values) < 0) {
                return -1;
            }
        }
        catch (Exception e){
            Log.e("ProductDAO: ", e.getMessage() );
        }

        return 1;
    }

    public List<Product> getAllProduct(){
        List<Product> listProduct = new ArrayList<>();
        String SELECT = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = db.rawQuery(SELECT,null);
        cursor.moveToFirst();
        if (cursor.moveToFirst()) {

            do {
                Product product = new Product();
                product.setmName(cursor.getString(1));
                product.setmPrice((cursor.getDouble(2)));

                listProduct.add(product);

            }

            while (cursor.moveToNext());
        }
        db.close();
        return listProduct;
    }
}
