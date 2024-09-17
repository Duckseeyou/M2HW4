package com.m2.m2hw4;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        Button button = findViewById(R.id.button1);
        EditText editText1 = findViewById(R.id.editText1);
        EditText editText2 = findViewById(R.id.editText2);



        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                button.setEnabled(!editText1.getText().toString().isEmpty() && !editText2.getText().toString().isEmpty());
                if (!editText1.getText().toString().isEmpty() && !editText2.getText().toString().isEmpty()) {
                    button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.orange)));
                } else {
                    button.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.grey)));
                }
            }

        };

        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);

        button.setOnClickListener(view -> {
            if (editText1.getText().toString().equals("admin") && editText2.getText().toString().equals("admin")){
                Snackbar.make(view, "Вы успешно зарегистрировались", Snackbar.LENGTH_SHORT).show();
                textView1.setVisibility(View.GONE);
                textView3.setVisibility(View.GONE);
                textView4.setVisibility(View.GONE);
                textView5.setVisibility(View.GONE);
                editText1.setVisibility(View.GONE);
                editText2.setVisibility(View.GONE);
                button.setVisibility(View.GONE);

            } else {
                Snackbar.make(view, "Неправильный логин и пароль" , Snackbar.LENGTH_SHORT).show();

            }

        });
    }
}