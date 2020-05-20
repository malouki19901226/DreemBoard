package com.example.dreemboard;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class NewCharacterActivity extends AppCompatActivity {

    ArrayList<String> profileList;
    String name, desc;

    EditText nameInput;
    EditText descInput;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_character);

        //ArrayList<ProfileItem> profileList = new ArrayList<>();
        //profileList.add(new ProfileItem(R.drawable.ic_def_char, "Line 1", "Line 2"));
        //profileList.add(new ProfileItem(R.drawable.ic_def_char, "Line 3", "Line 4"));
        //profileList.add(new ProfileItem(R.drawable.profile_img_test, "Line 5", "Line 6"));

        loadData();
        nameInput = (EditText) findViewById(R.id.nameInput);
        descInput = (EditText) findViewById(R.id.descInput);
        submitBtn = (Button) findViewById(R.id.btn_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString().trim();
                showToast(name);
                saveData();
                //finish();
            }
        });
    }

    private void saveData() {
        SharedPreferences pref = getSharedPreferences("Shared Preferences", MODE_PRIVATE); //PreferenceManager.getDefaultSharedPreferences(NewCharacterActivity.this);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String json = gson.toJson(profileList);
        editor.putString("profile list", json); // Stores in list as key
        editor.apply();
    }

    private void loadData() {
        SharedPreferences pref = getSharedPreferences("Shared Preferences", MODE_PRIVATE); //PreferenceManager.getDefaultSharedPreferences(NewCharacterActivity.this);
        Gson gson = new Gson();
        String json = pref.getString("profile list", null);
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        profileList = gson.fromJson(json, type);

        if (profileList == null) {
            profileList = new ArrayList<>();
        }
    }

    private void showToast(String text) {
        Toast.makeText(NewCharacterActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}
