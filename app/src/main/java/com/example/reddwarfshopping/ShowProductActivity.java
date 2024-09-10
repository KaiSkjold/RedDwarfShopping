package com.example.reddwarfshopping;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class ShowProductActivity extends AppCompatActivity {

    Button closeProductBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_show_product);

        Intent intent = getIntent();
        Product product = (Product) intent.getSerializableExtra("product");

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.show_product_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // close activity
        closeProductBtn = findViewById(R.id.close_product_btn);
        closeProductBtn.setOnClickListener(view -> {
            finish();
        });

        TextView name = findViewById(R.id.product_name);
        TextView description = findViewById(R.id.product_description);
        TextView quote = findViewById(R.id.product_quote);
        TextView series = findViewById(R.id.product_series_number);
        TextView price = findViewById(R.id.product_price);
        ImageView image = findViewById(R.id.product_image);

        if (product != null) {
            // Set product details to views
            name.setText(product.getName());
            description.setText(product.getDescription());
            quote.setText(String.format("Famous quote: %s", product.getQuote()));
            series.setText(String.format("First appeared in series: %s", product.getSeriesNumber()));
            price.setText(String.format("%s£", product.getPrice()));

            Glide.with(this)
                    .load(product.getImage())
                    .placeholder(R.mipmap.red_dwarf_ship)
                    .error(R.mipmap.red_dwarf_ship)
                    .into(image);
        }
    }
}