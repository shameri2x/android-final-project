package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class sign extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        final Button next = findViewById(R.id.create);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button next = findViewById(R.id.create);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(sign.this, tkfh9er.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }
}

