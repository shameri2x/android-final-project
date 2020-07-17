package com.example.qrcustomer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class form extends AppCompatActivity {
    String EditTextValue;
    Bitmap bitmap ;
    EditText name ;
    EditText number ;
    EditText civil ;
    ImageView qrCode ;
    public final static int QRcodeWidth = 350 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        final EditText name = findViewById(R.id.name);
        final EditText number = findViewById(R.id.number);
        final EditText civil = findViewById(R.id.civil);
        Button qr = findViewById(R.id.qr);
        final ImageView qrCode = findViewById(R.id.imageView2);






        qr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /*  Intent intent = new Intent(form.this,data.class);
                intent.putExtra("name",name.getText().toString());
                intent.putExtra("number",number.getText().toString());
                intent.putExtra("civil",civil.getText().toString()); */




               /* SharedPreferences preferences = form.this.getSharedPreferences("pref", Context.MODE_PRIVATE);
                SharedPreferences.Editor edt = preferences.edit();
                edt.putString("name",name.getText().toString());
                edt.commit();

                SharedPreferences preferences2 = form.this.getSharedPreferences("pref2", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = preferences2.edit();
                edit.putString("number" , number.getText().toString());
                edit.commit(); */

              /* SharedPreferences preferences3 = form.this.getSharedPreferences("pref3", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit2 = preferences3.edit();
                edit2.putString("civil" , civil.getText().toString());
                edit2.commit(); */





               /* Intent a = new Intent(form.this,data.class);
                a.putExtra("name",name.toString());
                a.putExtra("number",number.toString());
                a.putExtra("civil",civil.toString());*/





                // error ... form2
               /*  Intent v = new Intent(form.this,scan.class);
                v.putExtra("name",name.toString());
                startActivity(v); */





                String n = name.getText().toString();
                String n2 = number.getText().toString();
                String n3 = civil.getText().toString();

                String all = n +"#"+ n2 +"#"+ n3;


                if(!all.isEmpty()){

                  //  EditTextValue =all.toString();

                   /* Intent n = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(n); */

                    try {
                        bitmap = TextToImageEncode(all);

                        qrCode.setImageBitmap(bitmap);

                     /*   Intent n = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(n); */

                    } catch (WriterException e) {

                      /*  Intent n = new Intent(MainActivity.this,Main2Activity.class);
                        startActivity(n); */

                        e.printStackTrace();
                    }
                }
                else{
                    name.requestFocus();
                    Toast.makeText(form.this, "Please Enter Your Scanned Test" , Toast.LENGTH_LONG).show();

                }

                // startActivity(intent);

            }
        });


    }

    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {

          /*  Intent n = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(n); */

            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null







            );

        } catch (IllegalArgumentException Illegalargumentexception) {
           /* Intent n = new Intent(MainActivity.this,Main2Activity.class);
            startActivity(n);*/


            return null;


        }

       /* Intent n = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(n); */



        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.QRCodeBlackColor):getResources().getColor(R.color.QRCodeWhiteColor);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 350, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;

    }

}
