package com.example.steve.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    public static final String SET_COLOR = "com.example.myfirstapp.COLOR";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);
        RadioGroup rg = findViewById(R.id.radioGroup);
        Bundle b = new Bundle();

        final int color = ((RadioButton)findViewById(rg.getCheckedRadioButtonId()))
                            .getCurrentTextColor();
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        b.putInt("COLOR", color);
        intent.putExtras(b);
        startActivity(intent);
    }
}
