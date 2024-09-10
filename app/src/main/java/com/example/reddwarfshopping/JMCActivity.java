package com.example.reddwarfshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class JMCActivity extends AppCompatActivity {

    ImageView groupPhoto;
    Button closeAboutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_jmcactivity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.jmc_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setPhoto();
        closeAboutBtn = findViewById(R.id.close_about_btn);
        closeAboutBtn.setOnClickListener(view -> {
            finish();
        });
    }

        void setPhoto(){
        groupPhoto = findViewById(R.id.JMC_photo);
        Glide.with(this)
                .load("https://static.wikia.nocookie.net/reddwarf/images/0/0b/Jmc_recruitment_by_san_tus-d61wni8.jpg/revision/latest?cb=20140603010844")
                .placeholder(R.mipmap.red_dwarf_ship)
                .error(R.mipmap.red_dwarf_ship)
                .into(groupPhoto);
    }
}