package com.example.dreemboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CharacterProfileActivity extends AppCompatActivity {

    RecyclerView view;
    RecyclerView.Adapter mAdapter;  // Provides only amount of items needed, for performance
    RecyclerView.LayoutManager mLayoutManager;  // Provides only amount of items needed, for performance

    ArrayList<ProfileItem> profileList;
    String s1[], s2[];
    int images[] = {R.drawable.profile_img_test};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_profile);

        profileList = new ArrayList<>();
        profileList.add(new ProfileItem(R.drawable.ic_def_char, "Line 1", "Line 2"));
        profileList.add(new ProfileItem(R.drawable.profile_img_test, "Line 3", "Line 4"));
        profileList.add(new ProfileItem(R.drawable.profile_img_test, "Line 5", "Line 6"));

        s1 = getResources().getStringArray(R.array.name_values);
        s2 = getResources().getStringArray(R.array.desc_values);
        Button btn = (Button) findViewById(R.id.btn_new_char);
        view = findViewById(R.id.profileView);

        view.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MyAdapter(profileList);

        view.setLayoutManager((mLayoutManager));
        view.setAdapter(mAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Creating a New Character.", Toast.LENGTH_SHORT).show();
                openNewCharActivity();
            }
        });
    }

    public void openNewCharActivity() {
        Intent intent = new Intent(this, NewCharacterActivity.class);
        startActivity(intent);
    }
}
