package edu.psu.sweng888.shareproducts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductDatabaseHelper databaseHelper;
    private ProductAdapter productAdapter;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize recyclerView and databaseHelper
        recyclerView = findViewById(R.id.recycler_view);
        databaseHelper = new ProductDatabaseHelper(this);

        // reset the database
        this.deleteDatabase("products_db");
        List<Product> products = databaseHelper.getAllProducts();

        if (products.isEmpty()) {
            databaseHelper.populateProductsDatabase();
            products = databaseHelper.getAllProducts();
        }

        // populate recyclerView with products in database
        productAdapter = new ProductAdapter(products);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(productAdapter);
        databaseHelper.getAllProducts();
    }
}