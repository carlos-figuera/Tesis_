package geolocate_.com.tesis_.Presentador;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import geolocate_.com.tesis_.Login;
import geolocate_.com.tesis_.menu_administrador;

public class Presentador_login {
    Context contex;
    FirebaseAuth mAuth;

    public Presentador_login(Context contex, FirebaseAuth mAuth) {
        this.contex = contex;
        this.mAuth = mAuth;
    }

    public void Login( String email,String password ){

        final ProgressDialog mProgressDialog = new ProgressDialog(contex);
        mProgressDialog.setMessage("Validando usuario...");
        //mProgressDialog.setIndeterminate(false);
        //mProgressDialog.setMax(100);
        // mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        mAuth.signInWithEmailAndPassword(email , password)
                .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent i = new Intent(contex,menu_administrador.class);
                            contex.startActivity(i);
                            mProgressDialog.dismiss();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("usuarios", "signInWithEmail:failure", task.getException());
                            Toast.makeText( contex, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            mProgressDialog.dismiss();
                        }


                    }
                });


    }


}
