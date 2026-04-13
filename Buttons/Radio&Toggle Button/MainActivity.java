package com.example.radiotoggle;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton selectedRadio;
    ToggleButton toggleButton;
    Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        toggleButton = findViewById(R.id.toggleButton);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        // Toggle Button event
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "Toggle is ON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Toggle is OFF", Toast.LENGTH_SHORT).show();
            }
        });

        // Submit Button event
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedId = radioGroup.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this,
                            "Please select an option",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                selectedRadio = findViewById(selectedId);
                String gender = selectedRadio.getText().toString();

                String toggleStatus = toggleButton.isChecked() ? "ON" : "OFF";

                Toast.makeText(MainActivity.this,
                        "Selected: " + gender + "\nToggle: " + toggleStatus,
                        Toast.LENGTH_LONG).show();
            }
        });

        // RadioGroup event
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton rb = findViewById(checkedId);
            Toast.makeText(this,
                    rb.getText() + " Selected",
                    Toast.LENGTH_SHORT).show();
        });
    }
}