package com.gmail.avoishel.foxminded_anagram.UI;

import static com.gmail.avoishel.foxminded_anagram.Utils.Utils.createAnagram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.gmail.avoishel.foxminded_anagram.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.textInputView.addTextChangedListener(this);
        binding.textFilterView.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void afterTextChanged(Editable editable) {
        binding.resultTextView.setText(createAnagram(
                binding.textInputView.getText().toString(),
                binding.textFilterView.getText().toString()));
    }
}