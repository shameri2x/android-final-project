package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class data extends AppCompatActivity {

    TextView name ;
    TextView number ;
    TextView civil ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        TextView name = findViewById(R.id.textView5);
        TextView number = findViewById(R.id.textView6);
        TextView civil = findViewById(R.id.textView7);



         Bundle w = getIntent().getExtras();
        name.setText(w.getString("name"));
        number.setText(w.getString("number"));
        civil.setText(w.getString("civil"));

       /* SharedPreferences preferences = getApplication().getSharedPreferences("pref", Context.MODE_PRIVATE);
        String user = preferences.getString("name","");

        TextView t = findViewById(R.id.textView5);
        t.setText(user);


        SharedPreferences preferences2 = getApplication().getSharedPreferences("pref2", Context.MODE_PRIVATE);
        String user2 = preferences2.getString("number","");

        TextView t2 = findViewById(R.id.textView6);
        t2.setText(user2);

        SharedPreferences preferences3 = getApplication().getSharedPreferences("pref3", Context.MODE_PRIVATE);
        String user3 = preferences3.getString("civil","");

        TextView t3 = findViewById(R.id.textView7);
        t3.setText(user3); */


        Button back = findViewById(R.id.button11);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(data.this,scan.class);
                startActivity(intent);


            }
        });














        /* Bundle i = getIntent().getExtras();


        name.setText(i.getString("name"));
        number.setText(i.getString("number"));
        civil.setText(i.getString("civil")); */





    }
}
