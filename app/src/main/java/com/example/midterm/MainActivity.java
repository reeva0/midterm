package com.example.midterm;

import android.app.ActionBar;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button alertButton, buttonSend;
    FirstFragment fragment1;
    SecondFragment fragment2;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);
        buttonSend = findViewById(R.id.button1_id);

        textView = findViewById(R.id.text_view);

        if(savedInstanceState==null){

            fragment1 = new FirstFragment();
            fragment2 = new SecondFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.add(R.id.first_frag, fragment1);
            fragmentTransaction.add(R.id.second_frag, fragment2);

            fragmentTransaction.commit();

        }

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                fragment1.receiveData(text);
                fragment2.receiveData(text);
            }
        });

        alertButton = findViewById(R.id.button2_id);

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBox = new AlertDialog.Builder(MainActivity.this);
                alertDialogBox.setTitle("Alert Dialog Box");
                alertDialogBox.setMessage("Navigate to another activity");
                alertDialogBox.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Create an intent to start the new activity
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        // Start the new activity
                        startActivity(intent);
                    }
                });

                alertDialogBox.create();
                alertDialogBox.show();


            }
        });

    }

    public void updateTextView(String data){
        textView.setText(data);
    }
}