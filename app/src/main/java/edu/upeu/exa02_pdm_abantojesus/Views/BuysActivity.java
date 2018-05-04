package edu.upeu.exa02_pdm_abantojesus.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import edu.upeu.exa02_pdm_abantojesus.R;

public class BuysActivity extends AppCompatActivity {

    private TextView npro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buys);

        npro = (TextView) findViewById(R.id.textnamepro);

    }
}
