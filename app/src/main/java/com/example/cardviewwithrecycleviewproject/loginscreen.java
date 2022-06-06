package com.example.cardviewwithrecycleviewproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class loginscreen extends AppCompatActivity {
  GoogleSignInOptions gso;
  GoogleSignInClient  gsc;

  TextView forgetpassword;
  EditText loginUsername;
  EditText loginPassword;
  Button signINButton;
  Intent in;
  String uname,passwrd;
  //SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);
        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_GAMES_SIGN_IN).requestEmail().build();
        gsc=GoogleSignIn.getClient(this,gso);
        GoogleSignInAccount acct=  GoogleSignIn.getLastSignedInAccount(this);
        if (acct != null) {
            navigateToSecondActivity();
        }
        forgetpassword=(TextView) findViewById(R.id.forgetpasswordtextview);
        loginUsername=(EditText) findViewById(R.id.usernameedittext);
        loginPassword=(EditText) findViewById(R.id.PasswordeditText);
        signINButton=(Button) findViewById(R.id.siginbutton);
       // sharedPreferences = getSharedPreferences("user-details",MODE_PRIVATE);

        in= getIntent();
        uname=in.getStringExtra("user");
        loginUsername.setText(uname);
        passwrd=in.getStringExtra("key");
        loginPassword.setText(passwrd);


        signINButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             String enUsername=loginUsername.getText().toString();
             String enPassword=loginPassword.getText().toString();

             if (enUsername.equals(uname) && enPassword.equals(passwrd)){
                 in=new Intent(getApplicationContext(),coursepage.class);
                 startActivity(in);
             }else {
                 Toast.makeText(getApplicationContext(),"Invalid Credential",Toast.LENGTH_LONG).show();
             }

            }
        });
    }

    public void registerHere(View view) {
        Intent ir = new Intent(getApplicationContext(), registrationscreen.class);
        startActivity(ir);
    }

    public void integration(View view) {
        signIn();
    }
    void signIn(){
        Intent signInIntent = gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode ==1000){
            Task<GoogleSignInAccount>task= GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                task.getResult(ApiException.class);
                navigateToSecondActivity();
            } catch (ApiException e){
                Toast.makeText(getApplicationContext(), "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        }
    }

    void navigateToSecondActivity(){
        finish();
        Intent intent = new Intent(loginscreen.this,googleintegrationactivity.class);
        startActivity(intent);
    }

}