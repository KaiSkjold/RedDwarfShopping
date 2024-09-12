package com.example.reddwarfshopping;


import static com.example.reddwarfshopping.ProductsData.basketList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import java.util.List;

public class ProductAdapter extends ArrayAdapter<Product> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(@NonNull Context context, int resource, @NonNull List<Product> productList) {
        super(context, resource, productList);

        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View productListItem = convertView;

        if (productListItem == null)
            productListItem = LayoutInflater.from(context).inflate(R.layout.product_list, parent, false);


        Product currentProduct = productList.get(position);

        TextView name = productListItem.findViewById(R.id.product_name);
        name.setText(currentProduct.name);

        TextView description = productListItem.findViewById(R.id.product_description);
        description.setText(currentProduct.description);

        TextView price = productListItem.findViewById(R.id.product_price);
        price.setText(String.format("%s £ ", currentProduct.price));

        TextView quantity = productListItem.findViewById(R.id.number_of_items_in_basket);
        quantity.setText(String.valueOf(currentProduct.quantity));


        Button addToBasketBtn = productListItem.findViewById(R.id.add_to_basket_btn);
        addToBasketBtn.setOnClickListener(view -> {
            int quan = currentProduct.quantity + 1;
            currentProduct.setQuantity(quan);
            quantity.setText(String.valueOf(currentProduct.quantity));

            if (!basketList.contains(currentProduct)) {
                basketList.add(currentProduct);
            }
        });

        Button removeFromBasketBtn = productListItem.findViewById(R.id.remove_from_basket_btn);
        removeFromBasketBtn.setOnClickListener(view -> {

            int quan = currentProduct.quantity - 1;
            quantity.setText(String.valueOf(currentProduct.quantity));

            if(currentProduct.quantity <= 0) {
                currentProduct.setQuantity(0);
            } else {
                currentProduct.setQuantity(quan);
            }

            if(currentProduct.quantity == 0) {
                basketList.remove(currentProduct);
                notifyDataSetChanged();
            }
        });

        ImageView image = productListItem.findViewById(R.id.product_image);
        Glide.with(getContext())
                .load(currentProduct.image)
                .placeholder(R.mipmap.red_dwarf_ship) // optional placeholder while loading
                .error(R.mipmap.red_dwarf_ship) // optional error image if the URL fails to load
                .into(image);


        Button showPro = productListItem.findViewById(R.id.details_btn);
        showPro.setOnClickListener(view -> {
            getProductById(currentProduct.getId());
        });

        return productListItem;
    }

    void getProductById(int productId) {
//        String url = "http://192.168.39.181:8080/reddwarf";
        String url = "http://192.168.0.121:8080/reddwarf";
        RequestQueue requestQueue = Volley.newRequestQueue(context);

        String urlId = url + "/" + productId;

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET, urlId,
                response -> {
                    try {
                        // Deserialize the response into a Product object
                        Product product = new Gson().fromJson(response, Product.class);

                        // Create an Intent to start the ShowProductActivity
                        Intent intent = new Intent(context, ShowProductActivity.class);
                        intent.putExtra("product", product); // Ensure Product implements Serializable or Parcelable

                        // Start the activity
                        context.startActivity(intent);
                    } catch (Exception e) {
                        Log.e("ProductAdapter", "Error parsing product or starting activity", e);
                    }
                },
                error -> Log.e("Volley", "Error fetching product by ID", error)
        );

        requestQueue.add(stringRequest);
    }
}
