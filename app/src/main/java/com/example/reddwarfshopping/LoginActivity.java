package com.example.reddwarfshopping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    Button buttonLogin;
    ImageView loginImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize UI elements
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        loginImg = findViewById(R.id.login_image);
        Glide.with(getApplicationContext())
                .load("https://images.immediate.co.uk/production/volatile/sites/3/2020/03/dear-dave.v1-1f059c8.jpg?quality=90&webp=true&resize=1050,700")
                .placeholder(R.mipmap.red_dwarf_ship) // optional placeholder while loading
                .error(R.mipmap.red_dwarf_ship) // optional error image if the URL fails to load
                .into(loginImg);

        // Set a click listener for the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve entered username and password
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();

//                https://images.immediate.co.uk/production/volatile/sites/3/2020/03/dear-dave.v1-1f059c8.jpg?quality=90&webp=true&resize=1050,700

                // Implement authentication logic here
                if (username.equals("Admin") | (username.equals("User")) && password.equals("aMoose")) {
                    // Successful login
                    BasketActivity.showCustomToast(getApplicationContext(), "Login successful");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    // Failed login
                    BasketActivity.showCustomToast(getApplicationContext(), "Invalid username or password");
                }
            }
        });
    }
}