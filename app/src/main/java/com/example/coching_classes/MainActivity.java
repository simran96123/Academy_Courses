package com.example.coching_classes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private EditText email , password;
    private Button login;

    private FirebaseAuth firebaseAuth;

    private Dialog loadingDialog;

    //for admin
    private TextView AdminLink , NotAdminLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.admin_Email);
        password = findViewById(R.id.admin_passwrd);
        login = findViewById(R.id.admin_start);

        //fir admin
        AdminLink = findViewById(R.id.admin_panel);
        NotAdminLink = findViewById(R.id.user_panel);


        loadingDialog = new Dialog(MainActivity.this);
        loadingDialog.setContentView(R.layout.loading_progressbar);
        loadingDialog.setCancelable(false);
        loadingDialog.getWindow().setBackgroundDrawableResource(R.drawable.drawable_background);
        loadingDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT);

                firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (email.getText().toString().isEmpty()) {
                    email.setError("Enter Email id");
                    return;
                } else {
                    email.setError(null);
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Enter Password");
                    return;
                } else {
                    password.setError(null);
                }


                firebaseLogin();
            }




        });

        //for admin
        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);


            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);

            }
        });



        if (firebaseAuth.getCurrentUser() != null)
        {
            Intent intent = new Intent(MainActivity.this , Category_Activity.class);
            startActivity(intent);
            finish();
        }
    }
    private  void firebaseLogin()
    {
        loadingDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(MainActivity.this, "Successfull Login", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(MainActivity.this, Category_Activity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        }

                        loadingDialog.dismiss();

                    }



                });

    }
}