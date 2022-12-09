package com.example.projectg101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectg101.BD.DBFirebase;
import com.example.projectg101.BD.DBHelper;
import com.example.projectg101.Entidades.Product;
import com.example.projectg101.Servicios.ProductService;

public class ProductForm extends AppCompatActivity {
    private DBHelper dbHelper;
    private DBFirebase dbFirebase;
    private Button btnProductForm;
    private ImageView imgProductForm;
    private EditText editNameProductForm,editDescriptionProductForm,editPriceProductForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_form);

        btnProductForm = (Button) findViewById(R.id.btnProductForm);
        imgProductForm = (ImageView) findViewById(R.id.imgProductForm);
        editNameProductForm = (EditText) findViewById(R.id.editNameProductForm);
        editDescriptionProductForm = (EditText) findViewById(R.id.editDescriptionProductForm);
        editPriceProductForm = (EditText) findViewById(R.id.editPriceProductForm);

        try {
            dbHelper = new DBHelper(this);
            dbFirebase = new DBFirebase();
        }catch (Exception e){
            Log.e("Error DB", e.toString());
        }



        btnProductForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Product product = new Product(
                        editNameProductForm.getText().toString(),
                        editDescriptionProductForm.getText().toString(),
                        Integer.parseInt(editPriceProductForm.getText().toString().trim()),
                        ""
                );
                //dbHelper.insertData(product);
                dbFirebase.insertData(product);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}