package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class iam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iam);
        Button cus = findViewById(R.id.button);
        Button emp = findViewById(R.id.button2);

        cus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent n = new Intent(iam.this,form.class);
                startActivity(n);

            }
        });

        emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent n1 = new Intent(iam.this,form2.class);
                startActivity(n1);

            }
        });
    }
}
