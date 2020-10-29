package ru.avdeev.android.a3_4_1_switching_colors_in_the_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Spinner languageSpinner;
    Spinner colorSpinner;
    String choiceLanguage;
    String choiceColor;
    private static int sTheme;
    public final static int THEME_GREEN = 0;
    public final static int THEME_BLUE = 1;
    public final static int THEME_BACK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        languageSpinner=findViewById(R.id.languageSpinner);
        colorSpinner=findViewById(R.id.colorSpinner);
        givLanguage();
        givColor();
    }

    public void onClick(View view) {
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
                //showMyMessage("Ничего не выбрано", MainActivity.this);
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
                choiceColor = choiceColors[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //showMyMessage("Ничего не выбрано", MainActivity.this);
            }
        });
    }
    private void setColor() {

    }
}