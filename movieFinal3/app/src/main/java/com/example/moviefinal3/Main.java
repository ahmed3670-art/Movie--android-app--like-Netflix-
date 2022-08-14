package com.example.moviefinal3;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main extends AppCompatActivity {
    private EditText emailEt , passwordEt  ;
    private Button SignInButton ;
    private TextView SignUpTv;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ativity_m);
        firebaseAuth=FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.title_movie);
        passwordEt=findViewById(R.id.password);
        SignInButton=findViewById(R.id.login);
        progressDialog=new ProgressDialog(this);
        SignUpTv=findViewById(R.id.signUp);






        SignInButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                Login();

                                            }

                                        }
        );
        SignUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main.this , SignUpActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
    private void Login(){
        String email=emailEt.getText().toString();
        String password = passwordEt.getText().toString();

        if ( TextUtils.isEmpty(email)){
            emailEt.setError("Enter your email");
            return ;
        }
        else if ( TextUtils.isEmpty(password)){
            passwordEt.setError("Enter your password");
            return ;
        }

        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);

        firebaseAuth.signInWithEmailAndPassword( email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(email.equals("admin@gmail.com")&&password.equals("admin123")){

                    Toast.makeText(Main.this , "Successfully login admin " ,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main.this , Admin.class);
                    startActivity(intent);
                    //finish();

                }
                else if (task.isSuccessful()){
                    Toast.makeText(Main.this , "Successfully login" ,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Main.this , MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Toast.makeText(Main.this , "Sign In Fiald" ,Toast.LENGTH_LONG).show();
                }
                progressDialog.dismiss();

            }

        });




    }

}
    /*private boolean isvallidEmmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches() );
    }*/

