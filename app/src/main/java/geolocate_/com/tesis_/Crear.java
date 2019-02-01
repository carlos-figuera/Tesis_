package geolocate_.com.tesis_;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Crear extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       toolbar.setTitle("Crear cuenta");
        toolbar.setNavigationIcon(R.drawable.atras);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent( Crear.this,Login.class);
                startActivity(i);
            }
        });

    }
}
