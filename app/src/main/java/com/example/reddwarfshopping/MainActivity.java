package com.example.reddwarfshopping;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView shoppingList;
    private RequestQueue requestQueue;
    private String url = "http://192.168.39.181:8080/reddwarf";
    List<Product> productList;
    ProductAdapter myAdapter;
    Button jmcBtn;
    Button crewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        requestQueue = Volley.newRequestQueue(this);
        getProducts();

        jmcBtn = findViewById(R.id.about_JMC_btn);
        jmcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                Intent intent = new Intent(getApplicationContext(), JMCActivity.class);
                startActivity(intent);
            }
        });

        crewBtn = findViewById(R.id.about_crew_btn);
        crewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent intent = new Intent(getApplicationContext(), CrewActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onResume() {
        super.onResume();
        openGoogleSearch();
        openShoppingCart();
    }

    void openGoogleSearch() {
        EditText input = findViewById(R.id.input_google_text);
        Button checkGoogle = findViewById(R.id.google_btn);

        checkGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = input.getText().toString();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, str);
                startActivity(intent);
            }
        });
    }

    void openShoppingCart() {
        Button checkBasketBtn = findViewById(R.id.basket_btn);

        checkBasketBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), BasketActivity.class);
                startActivity(intent);
            }
        });
    }

    void getProducts() {
        StringRequest stringRequest
                = new StringRequest(
                Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {
                        Type listType = new TypeToken<List<Product>>() {}.getType();
                        productList = new Gson().fromJson(response, listType);
                        shoppingList = findViewById(R.id.product_list);
                        myAdapter = new ProductAdapter(MainActivity.this, 0, productList);
                        shoppingList.setAdapter(myAdapter);
                        myAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Log.e("Volley", "onErrorResponse", error);
                    }
                });
        requestQueue.add(stringRequest);
    }

}