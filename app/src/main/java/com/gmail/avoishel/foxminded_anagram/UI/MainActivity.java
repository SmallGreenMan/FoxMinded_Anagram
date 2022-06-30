package com.gmail.avoishel.foxminded_anagram.UI;

import static com.gmail.avoishel.foxminded_anagram.Utils.Utils.CreateAnagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.gmail.avoishel.foxminded_anagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.textInputView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.resultTextView.setText(CreateAnagram(s.toString(),binding.textFilterView.getText().toString()));
            }
        });

        binding.textFilterView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.resultTextView.setText(CreateAnagram(binding.textInputView.getText().toString(),s.toString()));
            }
        });
    }
}