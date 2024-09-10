package com.example.reddwarfshopping;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import java.util.List;

public class CrewActivity extends AppCompatActivity {

    ImageView groupPhoto;
    Button closeBtn;
    ListView crewList;
    CrewAdapter myAdapter;
    List<Crew> crewPeopleList = CrewData.addCrewMembers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_crew);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.crew_activity), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        crewList = findViewById(R.id.crew_list);
        myAdapter = new CrewAdapter(
                this, 0, crewPeopleList);
        crewList.setAdapter(myAdapter);

        setPhoto();
        closeBtn = findViewById(R.id.close_about_btn);
        closeBtn.setOnClickListener(view -> {
            finish();
        });
    }

    void setPhoto(){
        groupPhoto = findViewById(R.id.group_photo);
        Glide.with(this)
                .load("https://reddwarf.co.uk/about/images/so-what-is-it.jpg")
                .placeholder(R.mipmap.red_dwarf_ship)
                .error(R.mipmap.red_dwarf_ship)
                .into(groupPhoto);
    }
}