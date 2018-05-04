package edu.upeu.exa02_pdm_abantojesus.Interfaces.Objetos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import edu.upeu.exa02_pdm_abantojesus.Models.Producto;
import edu.upeu.exa02_pdm_abantojesus.R;
import edu.upeu.exa02_pdm_abantojesus.Views.BuysActivity;


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
//        holder.idpro.setText(Integer.toString(producto.getId()));
        holder.idpro.setText(producto.getId());
        holder.productoname.setText(producto.getNombre());
        holder.stock.setText(Integer.toString(producto.getStock()));
        holder.precio.setText(Double.toString(producto.getPrecio()));

        holder.setOnclickListeners();

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }


    public static class ProductosviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        TextView idpro, productoname, precio, stock;
        Button comprarpro;

        public ProductosviewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            idpro = (TextView) itemView.findViewById(R.id.idproducto);
            productoname = (TextView) itemView.findViewById(R.id.txtproducto);
            stock = (TextView) itemView.findViewById(R.id.txtstock);
            precio = (TextView) itemView.findViewById(R.id.txtprecio);
            comprarpro = (Button) itemView.findViewById(R.id.dobuy);

        }

        void setOnclickListeners() {
            comprarpro.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.dobuy:
                    Intent intent = new Intent(context, BuysActivity.class);
                    context.startActivity(intent);

                    break;

            }
        }
    }



}
