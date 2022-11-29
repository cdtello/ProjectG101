package com.example.projectg101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.projectg101.Adaptadores.ProductAdapter;
import com.example.projectg101.Entidades.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();
        int img = R.drawable.ic_launcher_background;
        Product product1 = new Product(img, "Producto1", "Descripcion 1 ", 1000);
        Product product2 = new Product(img, "Producto2", "Descripcion 2 ", 2000);
        Product product3 = new Product(img, "Producto3", "Descripcion 3 ", 3000);
        Product product4 = new Product(img, "Producto4", "Descripcion 4 ", 4000);
        Product product5 = new Product(img, "Producto5", "Descripcion 5 ", 5000);
        Product product6 = new Product(img, "Producto6", "Descripcion 6 ", 6000);
        Product product7 = new Product(img, "Producto7", "Descripcion 7 ", 7000);
        Product product8 = new Product(img, "Producto8", "Descripcion 8 ", 8000);
        Product product9 = new Product(img, "Producto9", "Descripcion 9 ", 9000);

        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);
        arrayProducts.add(product5);
        arrayProducts.add(product6);
        arrayProducts.add(product7);
        arrayProducts.add(product8);
        arrayProducts.add(product9);

        productAdapter = new ProductAdapter(this, arrayProducts);
        listViewProducts.setAdapter(productAdapter);
    }
}