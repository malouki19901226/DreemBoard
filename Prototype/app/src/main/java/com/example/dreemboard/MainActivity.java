package com.example.dreemboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ProtoApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ..get the button
        Button btn_char = (Button) findViewById(R.id.btn_char);
        Button btn_settings = (Button) findViewById(R.id.btn_settings);

        // ..set event onclick
        btn_char.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.i(TAG, "Navigated to Character Profiles Menu.");
                Toast.makeText(getApplicationContext(), "Navigating to Character Profiles Menu.", Toast.LENGTH_SHORT)
                        .show();
                openCharActivity();
            }
        });

        btn_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Navigating to Settings.", Toast.LENGTH_SHORT)
                        .show();
                openSettingsActivity();
            }
        });
    }

    public void openCharActivity() {
        Intent intent = new Intent(this, CharacterProfileActivity.class);
        startActivity(intent);
    }

    public void openSettingsActivity() {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }
}
