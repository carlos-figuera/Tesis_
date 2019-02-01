package geolocate_.com.tesis_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;


public class Tipo_cuenta extends AppCompatActivity implements View.OnClickListener{
   private ImageView Ima_persona,Ima_empresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_cuenta);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Tipo de  cuenta");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.atras);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplication(),Login.class);
                startActivity(i);
            }
        });


        Ima_persona=(ImageView)findViewById(R.id.Ima_persona);
        Ima_persona.setOnClickListener(this);
        Ima_empresa=(ImageView)findViewById(R.id.Ima_persona);
        Ima_empresa.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Ima_persona:
                Intent i= new Intent(getApplication(),Crear.class);
                startActivity(i);
                break;
            case R.id.Ima_empresa:
                Intent ii= new Intent(getApplication(),Crear_cuenta.class);
                startActivity(ii);
                break;

        }

    }
}
