package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class form2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        final EditText name = findViewById(R.id.name);
        final EditText id = findViewById(R.id.id);
        final EditText pass = findViewById(R.id.pass);
        final EditText pass2 = findViewById(R.id.pass2);
        Button next = findViewById(R.id.button10);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String n = name.getText().toString();
                String i = id.getText().toString();

                Intent p = new Intent(form2.this,scan.class);
               p.putExtra("info",n);
                p.putExtra("info2",i);

                if (pass.getText().toString().equals(pass2.getText().toString())) {
                    startActivity(p);
                } else if (pass.getText().toString().equalsIgnoreCase(pass2.getText().toString())) {
                    pass2.setTextColor(Color.rgb(255, 0, 0));
                } else {
                    pass2.setTextColor(Color.rgb(255, 0, 0));
                    Toast.makeText(form2.this, "الرقم السري غير متطابق ", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
