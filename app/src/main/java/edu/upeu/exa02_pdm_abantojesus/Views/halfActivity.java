package edu.upeu.exa02_pdm_abantojesus.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import edu.upeu.exa02_pdm_abantojesus.R;

public class halfActivity extends AppCompatActivity {

    private ImageButton lista,compra,user,agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half);

        lista = (ImageButton) findViewById(R.id.listaproducto);
        compra = (ImageButton) findViewById(R.id.compra);
        user = (ImageButton) findViewById(R.id.user);
        agregar = (ImageButton) findViewById(R.id.agregar);


        lista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(halfActivity.this,ListarActivity.class);
                startActivity(intent);
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(halfActivity.this,RegistrarProductoActivity.class);
                startActivity(intent);
            }
        });


    }
}
