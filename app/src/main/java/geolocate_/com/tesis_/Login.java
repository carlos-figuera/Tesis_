package geolocate_.com.tesis_;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import geolocate_.com.tesis_.Presentador.Presentador_login;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private EditText Edit_email, Edit_password;
    private Button Btn_ingresar;
    private FirebaseAuth mAuth;
    Presentador_login presentador_login;
    private TextView Txt_crear_cuenta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

         presentador_login= new Presentador_login(this,mAuth);
        Btn_ingresar = (Button) findViewById(R.id.Btn_ingresar);
        Btn_ingresar.setOnClickListener(this);
        Edit_email = (EditText) findViewById(R.id.Edit_email);
        Edit_password = (EditText) findViewById(R.id.Edit_password);

        Txt_crear_cuenta= (TextView) findViewById(R.id.Txt_crear_cuenta);
        Txt_crear_cuenta.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.Btn_ingresar:
                String email=Edit_email.getText().toString();
                String password=Edit_password.getText().toString();
               presentador_login.Login(email,password);
                break;

            case R.id.Txt_crear_cuenta:
                 Intent i = new Intent (Login.this,Tipo_cuenta.class);
                 startActivity(i);
                break;

        }

    }



}
