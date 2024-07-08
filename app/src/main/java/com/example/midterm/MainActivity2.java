package com.example.midterm;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater myInflater = getMenuInflater();
        myInflater.inflate(R.menu.my_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        View view = findViewById(android.R.id.content);
        int color = 0;

        if (item.getItemId() == R.id.menu_red) {
            color = Color.RED;
        } else if (item.getItemId() == R.id.menu_green) {
            color = Color.GREEN;
        } else if (item.getItemId() == R.id.menu_yellow) {
            color = Color.YELLOW;
        }

        if (color != 0) {
            view.setBackgroundColor(color);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}