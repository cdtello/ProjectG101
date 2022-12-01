package com.example.projectg101;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.projectg101.Adaptadores.ProductAdapter;
import com.example.projectg101.DB.DBHelper;
import com.example.projectg101.Entidades.Product;
import com.example.projectg101.Servicios.ProductService;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    private ProductService productService;
    private ListView listViewProducts;
    private ProductAdapter productAdapter;
    private ArrayList<Product> arrayProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewProducts = (ListView) findViewById(R.id.listViewProducts);
        arrayProducts = new ArrayList<>();

        try {
            dbHelper = new DBHelper(this);
            productService = new ProductService();
            arrayProducts = productService.cursorToArrayList(dbHelper.getProducts());
        }catch (Exception e){
            Log.e("DB Get", e.toString());
        }

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