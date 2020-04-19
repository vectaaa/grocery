package com.example.groscerry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class GroceryList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);
        Intent intent = getIntent();
        cart = (ArrayList) intent.getSerializableExtra("cart");

        recyclerView = findViewById(R.id.rvl);
    }
}
