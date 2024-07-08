package com.example.midterm;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {

    TextView textView;

    EditText editTextEmail, editTextPassword;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_first, container, false);

        editTextEmail = v.findViewById(R.id.email_input);
        editTextPassword = v.findViewById(R.id.password_input);
        button = v.findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();
                String data = "Email: " + email + "\nPassword: " + password;
                ((MainActivity) getActivity()).updateTextView(data);

            }
        });

        textView = v.findViewById(R.id.text_view);
        return v;
    }

    public void receiveData(String text){
        textView.setText(text);
    }

}