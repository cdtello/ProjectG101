package com.example.projectg101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.projectg101.DB.DBHelper;
import com.example.projectg101.Servicios.ProductService;

public class ProductForm extends AppCompatActivity {
    private DBHelper dbHelper;
    private ProductService productService;
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

        dbHelper = new DBHelper(this);
        productService = new ProductService();

        btnProductForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbHelper.insertProduct(
                        editNameProductForm.getText().toString(),
                        editDescriptionProductForm.getText().toString(),
                        editPriceProductForm.getText().toString(),
                        productService.imageViewToByte(imgProductForm)
                );
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }
}