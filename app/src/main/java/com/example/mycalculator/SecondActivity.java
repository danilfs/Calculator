package com.example.mycalculator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String RESULT_EXTRA_KEY = "RESULT_EXTRA_KEY";

    private TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        resultTextView = findViewById(R.id.expr_text_view);

        final Intent intent = getIntent();
        if (intent != null) {
            String value = intent.getStringExtra(RESULT_EXTRA_KEY);
            resultTextView.setText(value);
        }

    }
}
