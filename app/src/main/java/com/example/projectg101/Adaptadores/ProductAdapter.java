package com.example.projectg101.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectg101.Entidades.Product;
import com.example.projectg101.MainActivity2;
import com.example.projectg101.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Product> arrayProducts;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.context = context;
        this.arrayProducts = arrayProducts;
    }

    @Override
    public int getCount() {
        return arrayProducts.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducts.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView,
                        ViewGroup viewGroup) {

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        convertView = layoutInflater.inflate(R.layout.product_template, null);

        Product product = arrayProducts.get(position);

        ImageView imgProduct = (ImageView) convertView.findViewById(R.id.imgProduct);
        TextView tvNameProduct = (TextView) convertView.findViewById(R.id.tvNameProduct);
        TextView tvDescriptionProduct = (TextView) convertView.findViewById(R.id.tvDescriptionProduct);
        TextView tvPriceProduct = (TextView) convertView.findViewById(R.id.tvPriceProduct);
        CheckBox checkBoxProduct = (CheckBox) convertView.findViewById(R.id.checkBoxProduct);

        byte[] image = product.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);

        imgProduct.setImageBitmap(bitmap);
        tvNameProduct.setText(product.getName());
        tvDescriptionProduct.setText(product.getDescription());
        tvPriceProduct.setText(String.valueOf(product.getPrice()));

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(), MainActivity2.class);
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", product.getPrice());

                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
