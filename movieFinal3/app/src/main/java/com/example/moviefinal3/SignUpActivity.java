package com.example.moviefinal3;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {
private EditText emailEt , passwordEt1 , passwordEt2 ;
private Button SignUpButton ;
private TextView SignInTv;
private ProgressDialog progressDialog;
private FirebaseAuth firebaseAuth;
    user us =new user();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        firebaseAuth=FirebaseAuth.getInstance();
        emailEt=findViewById(R.id.title_movie);
        passwordEt1=findViewById(R.id.description);
        passwordEt2=findViewById(R.id.password2);
        SignUpButton=findViewById(R.id.register);
        progressDialog=new ProgressDialog(this);
        SignInTv=findViewById(R.id.SignIbTv);
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();

            }

        }
        );
        SignInTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this , Main.class);
                startActivity(intent);
                finish();

            }
        });
        }
        private void Register(){
            us.setEmail(emailEt.getText().toString());
            us.setPass(passwordEt1.getText().toString());
            String email=us.getEmail();
            String password1 = us.getPass();
            String password2 = passwordEt2.getText().toString();

      if (TextUtils.isEmpty(email)){
          emailEt.setError("Enter your email");
       return ;
      }
      else if (TextUtils.isEmpty(password1)){
        passwordEt1.setError("Enter your password");
         return ;
      }
       else if (TextUtils.isEmpty(password2)){
       passwordEt2.setError("confirm your password");
        return ;
      }
      else if (!password1.equals(password2)){
      passwordEt2.setError("Diffrent password");
      return;
}
else if (password1.length()<4){
    passwordEt1.setError("the password must have more than 4 charaters ");
    return;
}
//else if (!isvallidEmmail(email)){
   // emailEt.setError("invalid email");
    //return;

progressDialog.setMessage("Please wait...");
progressDialog.show();
progressDialog.setCanceledOnTouchOutside(false);
firebaseAuth.createUserWithEmailAndPassword(email , password1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        if (task.isSuccessful()){
            Toast.makeText(SignUpActivity.this , "Successfully registered" ,Toast.LENGTH_LONG).show();
            Intent intent = new Intent(SignUpActivity.this , Main.class);
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(SignUpActivity.this , "Sign Up Fiald" ,Toast.LENGTH_LONG).show();
        }
        progressDialog.dismiss();

    }

});




        }
private boolean isvallidEmmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches() );
}
    }


