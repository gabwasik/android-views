package com.example.widoki;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.MessageFormat;

public class SecondActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        // domyślne wartości pól
        String name = getResources().getString(R.string.name_unspecified);
        String gender = getResources().getString(R.string.gender_unspecified);
        String isAdult = getResources().getString(R.string.no);
        boolean switchName;

        // jeżeli pierwsze activity przekaże drugiemu bundle'a
        if (bundle != null) {
            // imię i nazwisko
            String bundleName = bundle.getString("NAME");
            if (bundleName != null && !bundleName.isEmpty()) {
                name = bundleName;

                // skracanie nazwiska
                switchName = bundle.getBoolean("NAME_SHORTEN", false);
                if (switchName) {
                    String[] nameSurname;
                    nameSurname = name.split(" ");
                    if (nameSurname.length >= 2) name = nameSurname[0] + ' ' + nameSurname[1].charAt(0) + '.';
                }
            }

            // płeć
            String bundleGender = bundle.getString("GENDER");
            if (bundleGender != null && !bundleGender.isEmpty()) gender = bundleGender;

            // "wiek"
            if (bundle.getBoolean("ADULT", false)) isAdult = getResources().getString(R.string.yes);
        }

        TextView textViewSummary = findViewById(R.id.textView);
        textViewSummary.setText(MessageFormat.format("Imię i nazwisko: {0}\nPłeć: {1}\nOsoba pełnoletnia: {2}", name, gender, isAdult));

        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonNext = findViewById(R.id.buttonNext);

        buttonBack.setOnClickListener(view -> finish());
        buttonNext.setOnClickListener(view -> openThirdActivity());
    }

    private void openThirdActivity() {
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);
    }
}
