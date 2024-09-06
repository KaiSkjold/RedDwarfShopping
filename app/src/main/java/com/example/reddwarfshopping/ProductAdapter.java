package com.example.reddwarfshopping;


import static com.example.reddwarfshopping.ProductsData.basketList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

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
        name.setText(currentProduct.Name);

        TextView description = productListItem.findViewById(R.id.product_description);
        description.setText(currentProduct.Description);

        TextView quote = productListItem.findViewById(R.id.product_quote);
        quote.setText(currentProduct.Quote);

        TextView series = productListItem.findViewById(R.id.product_series_number);
        series.setText(String.valueOf(currentProduct.SeriesNumber));

        TextView price = productListItem.findViewById(R.id.product_price);
        price.setText(String.format("%s£", String.valueOf(currentProduct.Price)));

        ImageView image = productListItem.findViewById(R.id.product_image);
//        image.setImageResource(currentProduct.Image);
        image.setImageResource(R.mipmap.red_dwarf_logo);

        TextView quantity = productListItem.findViewById(R.id.number_of_items_in_basket);
        quantity.setText(String.valueOf(currentProduct.Quantity));


        Button addToBasketBtn = productListItem.findViewById(R.id.add_to_basket_btn);
        addToBasketBtn.setOnClickListener(view -> {
            int quan = currentProduct.Quantity + 1;
            currentProduct.setQuantity(quan);
            quantity.setText(String.valueOf(currentProduct.Quantity));
            if(!basketList.contains(currentProduct)) {
                basketList.add(currentProduct);
            }

        });

        Button removeFromBasketBtn = productListItem.findViewById(R.id.remove_from_basket_btn);
        removeFromBasketBtn.setOnClickListener(view -> {
            int quan = currentProduct.Quantity - 1;
            if(currentProduct.Quantity <= 0) {
                currentProduct.setQuantity(0);
            } else {
                currentProduct.setQuantity(quan);
            }
            quantity.setText(String.valueOf(currentProduct.Quantity));
            if(currentProduct.Quantity == 0) {
                basketList.remove(currentProduct);
            }
        });

        return productListItem;
    }
}
