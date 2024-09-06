package com.example.reddwarfshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class BasketActivity extends AppCompatActivity {
    ListView shoppingList;
    List<Product> shoppingListBasket;
    ProductAdapter myAdapter;
    Button closeBasketbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basket);

        shoppingList = findViewById(R.id.basket_list);
        shoppingListBasket = ProductsData.basketList;
        myAdapter = new ProductAdapter(this, 0, shoppingListBasket);
        shoppingList.setAdapter(myAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_basket), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initGui();
    }

    void initGui(){



        // close activity
        closeBasketbtn = findViewById(R.id.close_basket_btn);
        closeBasketbtn.setOnClickListener(view -> {
            finish();
        });
    }
}