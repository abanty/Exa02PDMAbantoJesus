package edu.upeu.exa02_pdm_abantojesus.Interfaces.Objetos;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import edu.upeu.exa02_pdm_abantojesus.Models.Producto;
import edu.upeu.exa02_pdm_abantojesus.R;

/**
 * Created by JEMA on 01/05/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ProductosviewHolder> {

    List<Producto> productos;

    public Adapter(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public ProductosviewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vistalista, parent, false);
        ProductosviewHolder holder = new ProductosviewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProductosviewHolder holder, int position) {
        Producto producto = productos.get(position);
        holder.productoname.setText(producto.getNombre());
        holder.stock.setText(Integer.toString(producto.getStock()));
        holder.precio.setText(Double.toString(producto.getStock()));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public static class ProductosviewHolder extends RecyclerView.ViewHolder{

         TextView productoname, precio, stock;

          public ProductosviewHolder(View itemView) {
             super(itemView);
             productoname = (TextView) itemView.findViewById(R.id.txtproducto);
              stock = (TextView) itemView.findViewById(R.id.txtstock);
             precio = (TextView) itemView.findViewById(R.id.txtprecio);
         }
     }


}
