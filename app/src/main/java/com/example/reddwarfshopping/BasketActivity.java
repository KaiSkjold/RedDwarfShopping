package com.example.reddwarfshopping;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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

    void initGui() {

        buyStuff = findViewById(R.id.buy_btn);
        if(shoppingListBasket.isEmpty()) {
            buyStuff.setOnClickListener(view -> {
                showCustomToast(getApplicationContext(), "Your shoppingcart is empty.");
            });
        } else {
            buyStuff.setOnClickListener(view -> {
                FragmentManager fm = getSupportFragmentManager();
                new buyStuffMsg().show(fm, "Dialog");
            });
        }


        // close activity
        closeBasketbtn = findViewById(R.id.close_basket_btn);
        closeBasketbtn.setOnClickListener(view -> {
            finish();
        });
    }

    public static class buyStuffMsg extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setMessage("You are about to buy everything currently in the shoppingcart. Do you want to continue?")
                    .setTitle("Express Delivery Guarenteed by the boys from the Dwarf")
                    .setIcon(R.mipmap.red_dwarf_logo)
                    .setNegativeButton("Don't buy", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//                            Toast.makeText(getContext(), "Well, then you get nothing.", Toast.LENGTH_LONG).show();
                            showCustomToast(getContext(), "Well, then you get nothing.");
                            getActivity().finish();
                        }

                    })
                    .setPositiveButton("Buy it all!!", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
//                            Toast.makeText(getContext(), "Great. Money has been automatically withdrawn from your account.", Toast.LENGTH_LONG).show();
//                            Toast.makeText(getContext(), "Your delivery will arrive in approximately 3 million years.", Toast.LENGTH_LONG).show();
//                            Toast.makeText(getContext(), "Oh, and thank you for your business.", Toast.LENGTH_LONG).show();
                            showCustomToast(getContext(), "Great. Money has been automatically withdrawn from your account.");
                            showCustomToast(getContext(), "Your delivery will arrive in approximately 3 million years.");
                            showCustomToast(getContext(), " Oh, and thank you for your business.");
                            getActivity().finish();
                        }

                    });
            // Create the AlertDialog object and return it.
            return builder.create();
        }
    }

    private static void showCustomToast(Context context, String message) {
        // Inflate the custom toast layout
        LayoutInflater inflater = LayoutInflater.from(context);
        View layout = inflater.inflate(R.layout.custom_toast, null);

        // Find the TextView and ImageView in the custom layout
        TextView text = layout.findViewById(R.id.toast_message);
        ImageView icon = layout.findViewById(R.id.toast_icon);

        // Set the message and icon (optional)
        text.setText(message);

        // Create and show the Toast
        Toast toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}