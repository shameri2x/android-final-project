package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class scan extends AppCompatActivity {

    TextView tv_qr_readTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

       TextView welc = findViewById(R.id.welcome);
        TextView id = findViewById(R.id.id2);

      /*  Bundle i = getIntent().getExtras();
         welc.setText(i.getString("info"));
        id.setText(i.getString("info2"));
       // id.setText("المسمى الوظيفي : " + id.getText().toString());
        welc.setText("حياك الله " + welc.getText().toString() + " !!");
        welc.setTextColor(Color.rgb(0,0,0)); */

     /*  SharedPreferences preferences = getApplication().getSharedPreferences("pref", Context.MODE_PRIVATE);
        String user = preferences.getString("name","");
        TextView t = findViewById(R.id.welcome);
        t.setText(user);


        SharedPreferences preferences2 = getApplication().getSharedPreferences("pref2", Context.MODE_PRIVATE);
        String user2 = preferences2.getString("number","");
        TextView t2 = findViewById(R.id.id);
        t2.setText(user2); */

      Button out = findViewById(R.id.out);
      out.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              IntentIntegrator integrator2 = new IntentIntegrator(scan.this);
              integrator2.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
              integrator2.setPrompt("تسجيل خروج");
              integrator2.setCameraId(0);
              integrator2.setBeepEnabled(false);
              integrator2.setBarcodeImageEnabled(false);
              integrator2.initiateScan();

          }
      });

        Button btnScan = findViewById(R.id.scan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                IntentIntegrator integrator = new IntentIntegrator(scan.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("اخذ صورة");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();



                /*Intent n = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(n);*/
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

       /* Intent n = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(n);*/

        if(result != null) {
            if(result.getContents() == null) {
                Log.e("Scan*******", "Cancelled scan");


            } else {
                Log.e("Scan", "Scanned");

               //  tv_qr_readTxt.setText(result.getContents());
               // Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                String[] finalResult = result.getContents().split("#");

                Intent n = new Intent(scan.this,data.class);
                n.putExtra("name",finalResult[0]);
                n.putExtra("number",finalResult[1]);
                n.putExtra("civil",finalResult[2]);
                startActivity(n);
            }
        } else {
            // This is important, otherwise the result will not be passed to the fragment
            super.onActivityResult(requestCode, resultCode, data);
        }

    }

}
