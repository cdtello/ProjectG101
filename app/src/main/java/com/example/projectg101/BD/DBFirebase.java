package com.example.projectg101.BD;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.projectg101.Adaptadores.ProductAdapter;
import com.example.projectg101.Entidades.Product;
import com.example.projectg101.Login;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DBFirebase {
    private FirebaseFirestore db;

    public DBFirebase(){
        this.db = FirebaseFirestore.getInstance();
    }

    public void insertData(Product product){
        // Create a new user with a first and last name
        Map<String, Object> prod = new HashMap<>();
        prod.put("id", product.getId());
        prod.put("name", product.getName());
        prod.put("description", product.getDescription());
        prod.put("price", product.getPrice());
        prod.put("image", product.getImage());
        prod.put("latitud", product.getLatitud());
        prod.put("longitud", product.getLongitud());

        // Add a new document with a generated ID
        db.collection("products").add(prod);
    }

    public void getData(ProductAdapter adapter, ArrayList<Product> list){
        db.collection("products")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = new Product(
                                        document.getData().get("id").toString(),
                                        document.getData().get("name").toString(),
                                        document.getData().get("description").toString(),
                                        Integer.parseInt(document.getData().get("price").toString()),
                                        document.getData().get("image").toString(),
                                        document.getData().get("latitud").toString(),
                                        document.getData().get("longitud").toString()
                                );
                                list.add(product);
                            }
                            adapter.notifyDataSetChanged();
                        } else {
                            Log.e("Error document", "Error getting documents.", task.getException());
                        }
                    }
                });
    }

    public void updateData(Product product){

        db.collection("products").whereEqualTo("id", product.getId())
                        .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            DocumentSnapshot document =
                                    task.getResult().getDocuments().get(0);

                            document.getReference().update(
                                    "name", product.getName(),
                                    "description", product.getDescription(),
                                    "price", product.getPrice(),
                                    "image", product.getImage(),
                                    "latitud", product.getLatitud(),
                                    "longitud", product.getLongitud()
                            );
                        }
                    }
                });
    }

    public void deleteData(String id){
        db.collection("products").whereEqualTo("id", id)
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful()){
                            for(QueryDocumentSnapshot document : task.getResult()){
                                document.getReference().delete();
                            }
                        }
                    }
                });
    }

}
