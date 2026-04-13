package com.example.buttonstextfieldscheckboxes;


import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    CheckBox checkJava, checkPython;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Link UI elements
        editTextName = findViewById(R.id.editTextName);
        checkJava = findViewById(R.id.checkJava);
        checkPython = findViewById(R.id.checkPython);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Button click event
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = editTextName.getText().toString();
                String selected = "";

                if (checkJava.isChecked()) {
                    selected += "Java ";
                }

                if (checkPython.isChecked()) {
                    selected += "Python ";
                }

                // Show result
                Toast.makeText(MainActivity.this,
                        "Name: " + name + "\nSelected: " + selected,
                        Toast.LENGTH_LONG).show();
            }
        });

        // Checkbox event handling
        checkJava.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Java Selected", Toast.LENGTH_SHORT).show();
            }
        });

        checkPython.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Python Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}