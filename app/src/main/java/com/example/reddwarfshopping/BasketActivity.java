package com.example.reddwarfshopping;

import static com.example.reddwarfshopping.ProductsData.basketList;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import java.util.List;

public class BasketActivity extends AppCompatActivity {
    ListView shoppingList;
    List<Product> shoppingListBasket;
    ProductAdapter myAdapter;
    Button closeBasketbtn;
    Button buyStuff;
//    Button updatePriceBtn;
    TextView totalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_basket);

        shoppingList = findViewById(R.id.basket_list);
        shoppingListBasket = basketList;
        myAdapter = new ProductAdapter(this, 0, shoppingListBasket);
        shoppingList.setAdapter(myAdapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_basket), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setTotal();
        initGui();
    }


    void initGui() {

//        // update price
//        updatePriceBtn = findViewById(R.id.update_price_btn);
//        updatePriceBtn.setOnClickListener(view -> {
//            setTotal();
//        });

        // buy and finish
        buyStuff = findViewById(R.id.buy_btn);
        if (shoppingListBasket.isEmpty()) {
            buyStuff.setOnClickListener(view -> {
                setTotal();
                showCustomToast(getApplicationContext(), "Your shoppingcart is empty.");
            });
        } else {
            buyStuff.setOnClickListener(view -> {
                setTotal();
                FragmentManager fm = getSupportFragmentManager();
                new buyStuffMsg().show(fm, "Dialog");
            });
        }


        // close activity
        closeBasketbtn = findViewById(R.id.close_basket_btn);
        closeBasketbtn.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();
        });
    }

    void setTotal(){
        totalAmount = findViewById(R.id.total_in_basket);
        double sum = 1e-6;
        for (Product i : basketList){
            sum += (i.getPrice() * i.getQuantity());
        }
        sum = (double)Math.round(sum * 100d) / 100d;

        totalAmount.setText(String.format("Total : %s", sum));
        myAdapter.notifyDataSetChanged();
    }

    public static class buyStuffMsg extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("You are about to buy everything currently in the shoppingcart. \n" +
                            "Money will automatically be withdrawn from your account. \n " +
                            "Do you want to continue?")
                    .setTitle("Express Delivery Guarenteed by the Boys from the Dwarf")
                    .setIcon(R.mipmap.red_dwarf_logo)
                    .setNegativeButton("Don't buy", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            showCustomToast(getContext(), "Well, then you get nothing.");
                            getActivity().finish();
                        }

                    })
                    .setPositiveButton("Buy it all!!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            showCustomToast(getContext(), "Your delivery will arrive in approximately 3 million years.");
                            showCustomToast(getContext(), "Oh, and thank you for your business.");
                            basketList.clear();
                            startActivity(new Intent(getContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        }

                    });
            // Create the AlertDialog object and return it.
            return builder.create();
        }
    }

    public static void showCustomToast(Context context, String message) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast, null);

        // Find the TextView and ImageView in the custom layout
        TextView text = layout.findViewById(R.id.toast_message);
        ImageView icon = layout.findViewById(R.id.toast_icon);

        // Set the message and icon (optional)
        text.setText(message);
        // icon.setImageResource(R.mipmap.red_dwarf_logo);

        // Create and show the Toast
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}