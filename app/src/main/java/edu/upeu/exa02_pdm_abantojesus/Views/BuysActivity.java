package edu.upeu.exa02_pdm_abantojesus.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import edu.upeu.exa02_pdm_abantojesus.R;

public class BuysActivity extends AppCompatActivity {

    private TextView npro,total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buys);


        String producto= "";
        String precio="";
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            producto = extras.getString("producto");
            precio = extras.getString("precio");
        }

        npro = (TextView) findViewById(R.id.textnamepro);
        npro.setText(producto);

        total = (TextView) findViewById(R.id.totalpro);
        total.setText("S/. "+precio);

    }
}
