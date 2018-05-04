package edu.upeu.exa02_pdm_abantojesus.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import edu.upeu.exa02_pdm_abantojesus.Interfaces.Objetos.Adapter;
import edu.upeu.exa02_pdm_abantojesus.Models.Producto;
import edu.upeu.exa02_pdm_abantojesus.R;


public class ListarActivity extends AppCompatActivity {

    private RecyclerView rv;
    List<Producto> productos;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        rv = (RecyclerView) findViewById(R.id.recycler);

        rv.setLayoutManager(new LinearLayoutManager(this));

        productos = new ArrayList<>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        adapter = new Adapter(productos);

        rv.setAdapter(adapter);

        database.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                productos.removeAll(productos);
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    Producto producto=snapshot.getValue(Producto.class);
                    productos.add(producto);
                }
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
