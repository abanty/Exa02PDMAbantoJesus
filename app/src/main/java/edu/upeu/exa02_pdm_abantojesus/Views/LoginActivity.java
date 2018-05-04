package edu.upeu.exa02_pdm_abantojesus.Views;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import edu.upeu.exa02_pdm_abantojesus.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnlogin,btnfacebook,btngoogle;
    private EditText eduser, edpass;
    private TextView txtforgetpass,txtcreateacount;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        btnlogin = (Button) findViewById(R.id.login);
        btnfacebook = (Button) findViewById(R.id.loginFace);
        btngoogle = (Button) findViewById(R.id.loginGoogle);
        eduser = (EditText) findViewById(R.id.username);
        edpass = (EditText) findViewById(R.id.password);
        txtforgetpass = (TextView) findViewById(R.id.forgotAccount);
        txtcreateacount = (TextView) findViewById(R.id.createHere);

        btnlogin.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    Log.i("SESION","sesion iniciada con email: "+user.getEmail());
                }else{
                    Log.i("SESION", "sesion cerrada");
                }
            }
        };
    }

    private void IniciarSesion(String email, String pass){
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(LoginActivity.this, "Sesion Iniciada", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, halfActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Sesion erronea no pudo iniciar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                String email = eduser.getText().toString();
                String pass = edpass.getText().toString();
                IniciarSesion(email,pass);
            break;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener!=null){
            FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}