package edu.upeu.exa02_pdm_abantojesus.Views;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import edu.upeu.exa02_pdm_abantojesus.R;


public class ListarActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        rv = (RecyclerView) findViewById(R.id.recycler);
    }
}
