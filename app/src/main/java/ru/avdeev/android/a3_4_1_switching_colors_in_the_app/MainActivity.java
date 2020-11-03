package ru.avdeev.android.a3_4_1_switching_colors_in_the_app;

import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner languageSpinner;
    Spinner colorSpinner;
    String choiceLanguage;
    int choiceColor;
    private static @StyleRes int sTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(sTheme);
        setContentView(R.layout.activity_main);
        languageSpinner=findViewById(R.id.languageSpinner);
        colorSpinner=findViewById(R.id.colorSpinner);
        givLanguage();
        givColor();
    }

    public void onClick(View view) {
        ConstraintLayout myView = findViewById(R.id.myLayout);
        if (choiceLanguage.equals("Russian")) {
            Locale locale = new Locale("ru");
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
            recreate();
        } else {
            if (choiceLanguage.equals("Английский")) {
                Locale locale = new Locale("en");
                Configuration config = new Configuration();
                config.setLocale(locale);
                getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                recreate();
            }
        }
        switch (choiceColor) {
            case 0:
                sTheme = R.style.ThemeGreen;
                myView.setBackgroundResource(R.color.colorPrimaryDarkGreen);
                recreate();
                break;
            case 1:
                sTheme = R.style.ThemeBlue;
                myView.setBackgroundResource(R.color.colorPrimaryDarkBlue);
                recreate();
                break;
            case 2:
                sTheme = R.style.ThemeBlack;
                myView.setBackgroundResource(R.color.colorPrimaryDarkBlack);
                recreate();
                break;
            default:
                break;
        }
    }
    private void givLanguage () {
        ArrayAdapter<CharSequence> adapterLanguages = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapterLanguages.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapterLanguages);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choiceLanguages = getResources().getStringArray(R.array.languages);
                choiceLanguage = choiceLanguages[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void givColor() {
        ArrayAdapter<CharSequence> adapterColors = ArrayAdapter.createFromResource(this, R.array.colors, android.R.layout.simple_spinner_item);
        adapterColors.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorSpinner.setAdapter(adapterColors);

        colorSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] choiceColors = getResources().getStringArray(R.array.colors);
                choiceColor = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //showMyMessage("Ничего не выбрано", MainActivity.this);
            }
        });
    }
}