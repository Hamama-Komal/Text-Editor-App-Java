package com.example.texteditorapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.texteditorapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayAdapter<String> colorAdapter, styleAdapter, fontAdapter, allignmentAdapter;
    String[] colorArray = {"Red", "Green", "Blue", "Gray", "Black"};
    String[] styleArray = {"Bold", "Italic", "Bold Italic", "Underline", "None"};
    String[] fontArray = {"BebasNeue", "Marcellus", "OpenSans", "Poppins", "Slabo", "Ubuntu"};
    String[] allignmentArray = {"Left", "Right", "Center"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setupColorOptions();
        setupStyleOptions();
        setupFontOptions();
        setupAllignmentOptions();


    }

    private void setupAllignmentOptions() {
        allignmentAdapter = new ArrayAdapter<>(this, R.layout.list_item, allignmentArray);
        binding.allignmentOptions.setAdapter(allignmentAdapter);

        binding.allignmentOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String allignment = adapterView.getItemAtPosition(i).toString();
                applyAllignment(allignment);
            }
        });
    }

    private void applyAllignment(String allignment) {

        switch (allignment) {

            case "Right":
                binding.inputText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
                SpannableString spannableString1 = new SpannableString(binding.inputText.getText());
                binding.inputText.setText(spannableString1);
                break;
            case "Center":
                binding.inputText.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                SpannableString spannableString2 = new SpannableString(binding.inputText.getText());
                binding.inputText.setText(spannableString2);
                break;
            default:
                binding.inputText.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
                SpannableString spannableString3 = new SpannableString(binding.inputText.getText());
                binding.inputText.setText(spannableString3);
        }
    }

    private void setupFontOptions() {

        fontAdapter = new ArrayAdapter<>(this, R.layout.list_item, fontArray);
        binding.fontsOptions.setAdapter(fontAdapter);

        binding.fontsOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String font = adapterView.getItemAtPosition(i).toString();
                applyFont(font);
            }
        });
    }

    private void applyFont(String font) {

        switch (font) {
            case "BebasNeue":
                Typeface typeface = Typeface.createFromAsset(getAssets(), "BebasNeue.ttf");
                binding.inputText.setTypeface(typeface);
                break;
            case "Marcellus":
                Typeface typeface1 = Typeface.createFromAsset(getAssets(), "Marcellus.ttf");
                binding.inputText.setTypeface(typeface1);
                break;
            case "OpenSans":
                Typeface typeface2 = Typeface.createFromAsset(getAssets(), "OpenSans.ttf");
                binding.inputText.setTypeface(typeface2);
                break;
            case "Poppins":
                Typeface typeface3 = Typeface.createFromAsset(getAssets(), "Poppins.ttf");
                binding.inputText.setTypeface(typeface3);
                break;
            case "Slabo":
                Typeface typeface4 = Typeface.createFromAsset(getAssets(), "Slabo.ttf");
                binding.inputText.setTypeface(typeface4);
                break;
            case "Ubuntu":
                Typeface typeface5 = Typeface.createFromAsset(getAssets(), "Ubuntu.ttf");
                binding.inputText.setTypeface(typeface5);
                break;
            default:
                binding.inputText.setTypeface(Typeface.DEFAULT);
        }

    }

    private void setupColorOptions() {
        colorAdapter = new ArrayAdapter<>(this, R.layout.list_item, colorArray);
        binding.colorsOptions.setAdapter(colorAdapter);

        binding.colorsOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String color = adapterView.getItemAtPosition(i).toString();
                applyFontColor(color);
            }
        });
    }

    private void applyFontColor(String color) {
        switch (color) {
            case "Red":
                binding.inputText.setTextColor(Color.RED);
                break;
            case "Green":
                binding.inputText.setTextColor(Color.GREEN);
                break;
            case "Blue":
                binding.inputText.setTextColor(Color.BLUE);
                break;
            case "Gray":
                binding.inputText.setTextColor(Color.GRAY);
                break;
            case "Black":
                binding.inputText.setTextColor(Color.BLACK);
                break;
        }
    }

    private void setupStyleOptions() {
        styleAdapter = new ArrayAdapter<>(this, R.layout.list_item, styleArray);
        binding.styleOptions.setAdapter(styleAdapter);

        binding.styleOptions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String style = adapterView.getItemAtPosition(i).toString();
                applyFontStyle(style);
            }
        });
    }

    private void applyFontStyle(String style) {
        SpannableString spannableString = new SpannableString(binding.inputText.getText());
        switch (style) {
            case "Bold":
                spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, spannableString.length(), 0);
                break;
            case "Italic":
                spannableString.setSpan(new StyleSpan(Typeface.ITALIC), 0, spannableString.length(), 0);
                break;
            case "Bold Italic":
                spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), 0, spannableString.length(), 0);
                break;
            case "Underline":
                spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
                break;
            case "None":
                break;
        }
        binding.inputText.setText(spannableString);
    }
}