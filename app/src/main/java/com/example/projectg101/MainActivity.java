package com.example.projectg101;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

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

        arrayProducts = new ArrayList<>();
        // **** Productos para llenar

        Product product1 = new Product("Producto1", "Desc1", 1000, "");
        Product product2 = new Product("Producto2", "Desc2", 2000, "");
        Product product3 = new Product("Producto3", "Desc3", 3000, "");
        Product product4 = new Product("Producto4", "Desc4", 4000, "");
        Product product5 = new Product("Producto5", "Desc5", 5000, "");
        Product product6 = new Product("Producto6", "Desc6", 6000, "");
        Product product7 = new Product("Producto7", "Desc7", 7000, "");
        Product product8 = new Product("Producto8", "Desc8", 8000, "");
        Product product9 = new Product("Producto9", "Desc9", 9000, "");

        arrayProducts.add(product1);
        arrayProducts.add(product2);
        arrayProducts.add(product3);
        arrayProducts.add(product4);
        arrayProducts.add(product5);
        arrayProducts.add(product6);
        arrayProducts.add(product7);
        arrayProducts.add(product8);
        arrayProducts.add(product9);

        // *************

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        productAdapter = new ProductAdapter(this, arrayProducts);

        listViewProducts.setAdapter(productAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.itemAdd:
                Intent intent = new Intent(getApplicationContext(), ProductForm.class);
                startActivity(intent);
                return true;
            case R.id.itemFavorite:
                Toast.makeText(getApplicationContext(),"Favoritos",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.itemShare:
                Toast.makeText(getApplicationContext(),"Compartir",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}