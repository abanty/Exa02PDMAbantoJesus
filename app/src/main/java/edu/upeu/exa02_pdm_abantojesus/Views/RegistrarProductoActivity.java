package edu.upeu.exa02_pdm_abantojesus.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import edu.upeu.exa02_pdm_abantojesus.R;

public class RegistrarProductoActivity extends AppCompatActivity {

    private EditText idpro,namepro,preciopro,stockpro;
    private Button registrar;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);



        idpro = (EditText) findViewById(R.id.edID);
        namepro = (EditText) findViewById(R.id.edproducto);
        preciopro = (EditText) findViewById(R.id.edprecio);
        stockpro = (EditText) findViewById(R.id.edstock);
        registrar = (Button) findViewById(R.id.registrar);

        databaseReference = FirebaseDatabase.getInstance().getReference().getRoot();

       registrar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                        registrarproducto();
               idpro.setFocusable(true);
           }
       });
    }

    private void registrarproducto(){
//        int identificador = Integer.parseInt(idpro.getText().toString().trim());
        String identificador = idpro.getText().toString().trim();
        String nombreproducto = namepro.getText().toString().trim();
        double precioproducto = Double.parseDouble(preciopro.getText().toString().trim());
        int stockproducto = Integer.parseInt(stockpro.getText().toString().trim());

//        if (String.valueOf(identificador)==""){
        if (TextUtils.isEmpty(identificador)){
            Toast.makeText(this, "Por favor ingresa un ID", Toast.LENGTH_SHORT).show();
            return;
        }else if(TextUtils.isEmpty(nombreproducto)){
            Toast.makeText(this, "Por favor ingresa un producto", Toast.LENGTH_SHORT).show();
            return;
        }else if (String.valueOf(precioproducto)==""){
            Toast.makeText(this, "Por favor ingresa un precio", Toast.LENGTH_SHORT).show();
            return;
        }else if (String.valueOf(stockproducto)==""){
            Toast.makeText(this, "Por favor ingresa un stock", Toast.LENGTH_SHORT).show();
            return;
        }else{
            String id = databaseReference.push().getKey();
//            Producto producto = new Producto(id,nombre,precio,stock);
//            databaseReference.child(id).child("id").setValue(identificador);
            databaseReference.child(id).child("id").setValue(identificador.toString().trim());
            databaseReference.child(id).child("nombre").setValue(nombreproducto.toString().trim());
            databaseReference.child(id).child("precio").setValue(precioproducto);
            databaseReference.child(id).child("stock").setValue(stockproducto);
            Toast.makeText(this, "Producto Registrado Satisfactoriamente, Por favor revisar Lista", Toast.LENGTH_SHORT).show();
        }


        limpiarcampos();

    }

    private void limpiarcampos() {
        idpro.setText("");
        namepro.setText("");
        preciopro.setText("");
        stockpro.setText("");
    }

}



























