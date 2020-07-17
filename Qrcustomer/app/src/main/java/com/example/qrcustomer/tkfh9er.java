package com.example.qrcustomer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class tkfh9er extends AppCompatActivity {

    EditText name , last , number , email , pass , pass2 ;
    Button create ;
    FirebaseAuth fAuth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tkfh9er);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        last = findViewById(R.id.last);
        number = findViewById(R.id.phone);
        pass = findViewById(R.id.pass);
        pass2 = findViewById(R.id.pass2);
        create = findViewById(R.id.next);

        fAuth = FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser() !=null);
        startActivity(new Intent(getApplicationContext(),store.class));
        finish();


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String password = pass.getText().toString();

                if (TextUtils.isEmpty(Email)){
                    email.setError("الايميل مطلوب ");
                    return;
                }

                if (TextUtils.isEmpty(password)){
                    pass.setError("الايميل مطلوب ");
                    return;
                }

                if (password.length()< 6){
                    pass.setError("ايجب ان يكون الرقم السري اكثر نت 6");
                    return;

                }

                fAuth.createUserWithEmailAndPassword(Email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful()){
                            Toast.makeText(tkfh9er.this," الحساب تفعل ",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(),store.class));

                        }else {
                            Toast.makeText(tkfh9er.this, "Error" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }                        }
                });
            }
        });

    }
}
