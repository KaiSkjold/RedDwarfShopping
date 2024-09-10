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

import com.bumptech.glide.Glide;

import java.util.List;

public class CrewAdapter extends ArrayAdapter<Crew> {
    private List<Crew> crewList;
    private Context context;

    public CrewAdapter(@NonNull Context context, int resource, @NonNull List<Crew> crewList) {
        super(context, resource, crewList);

        this.crewList = crewList;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View crewListPerson = convertView;

        if (crewListPerson == null)
            crewListPerson = LayoutInflater.from(context).inflate(R.layout.crew_list, parent, false);


        Crew currentCrewMember = crewList.get(position);

        TextView name = crewListPerson.findViewById(R.id.crew_name);
        name.setText(String.format("Name: %s",currentCrewMember.name));

        TextView nickname = crewListPerson.findViewById(R.id.crew_nickname);
        nickname.setText(String.format("Nickname: %s", currentCrewMember.nickName));

        TextView job = crewListPerson.findViewById(R.id.crew_job);
        job.setText(String.format("Job: %s", currentCrewMember.job));

        TextView species = crewListPerson.findViewById(R.id.species);
        species.setText(String.format("Species: %s", currentCrewMember.species));

        TextView quote = crewListPerson.findViewById(R.id.crew_quote);
        quote.setText(String.format("Famous quote: %s", currentCrewMember.quote));

        TextView origin = crewListPerson.findViewById(R.id.crew_place_of_origin);
        origin.setText(String.format("Origin: %s", currentCrewMember.placeOfOrigin));


        ImageView image = crewListPerson.findViewById(R.id.crew_portrait);
        Glide.with(getContext())
                .load(currentCrewMember.portrait)
                .placeholder(R.mipmap.red_dwarf_ship) // optional placeholder while loading
                .error(R.mipmap.red_dwarf_ship) // optional error image if the URL fails to load
                .into(image);

        return crewListPerson;
    }
}
