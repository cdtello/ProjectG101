package com.example.projectg101.Adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projectg101.Entidades.Product;
import com.example.projectg101.MainActivity2;
import com.example.projectg101.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {
    private ArrayList<Product> arrayProducts;
    private Context context;

    public ProductAdapter(Context context, ArrayList<Product> arrayProducts) {
        this.arrayProducts = arrayProducts;
        this.context = context;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        view = layoutInflater.inflate(R.layout.product_template, null);

        ImageView imgProduct = (ImageView) view.findViewById(R.id.imgProduct);
        TextView tvNameProduct = (TextView) view.findViewById(R.id.tvNameProduct);
        TextView tvDescriptionProduct = (TextView) view.findViewById(R.id.tvDescriptionProduct);
        TextView tvPriceProduct = (TextView) view.findViewById(R.id.tvPriceProduct);

        Product product = arrayProducts.get(i);

        imgProduct.setImageResource(R.drawable.dragon);
        tvNameProduct.setText(product.getName());
        tvDescriptionProduct.setText(product.getDescription());
        tvPriceProduct.setText(String.valueOf(product.getPrice()));

        imgProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(context.getApplicationContext(), MainActivity2.class);
                intent.putExtra("name", product.getName());
                intent.putExtra("description", product.getDescription());
                intent.putExtra("price", product.getPrice());
                intent.putExtra("image",product.getImage());
                context.startActivity(intent);
            }
        });

        return view;
    }
}
