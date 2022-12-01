package com.example.projectg101.Servicios;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;

import com.example.projectg101.Entidades.Product;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class ProductService {
    public byte[] imageViewToByte(ImageView imageView){
        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    public ArrayList<Product> cursorToArrayList(Cursor cursor){
        ArrayList<Product> list = new ArrayList<>();
        if(cursor.getCount() != 0){
            while (cursor.moveToNext()){
                Product product = new Product(
                  cursor.getBlob(4),
                  cursor.getString(1),
                  cursor.getString(2),
                  Integer.parseInt(cursor.getString(3))
                );
                list.add(product);
            }
        }
        return list;
    }
}
