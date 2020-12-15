package idat.edu.pe.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import idat.edu.pe.CursosDetalleActivity;
import idat.edu.pe.MensualidadDetalleActivity;
import idat.edu.pe.Modelo.Mensualidad;
import idat.edu.pe.R;

public class MensualidadAdapter extends RecyclerView.Adapter<MensualidadAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Mensualidad> lista;

    public MensualidadAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(context).
                inflate(R.layout.item_mensualidad, viewGroup, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Mensualidad item = lista.get(i);

        viewHolder.tvIdMensualidad.setText(item.getCod_mensualidad());

        viewHolder.tvFechaMensualidad.setText(item.getVencimiento());

        viewHolder.contenedorMensualidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intDetalle = new Intent(context, MensualidadDetalleActivity.class);
                intDetalle.putExtra("objmensualidad", item);
                context.startActivity(intDetalle);

            }
        });

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIdMensualidad, tvFechaMensualidad;
        CardView contenedorMensualidad;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdMensualidad = itemView.findViewById(R.id.tvIdMensualidad);
            tvFechaMensualidad = itemView.findViewById(R.id.tvFechaMensualidad);
            contenedorMensualidad = itemView.findViewById(R.id.contenedorMensualidad);
        }
    }

    public void agregarElementos(ArrayList<Mensualidad> data){
        lista.clear();
        lista.addAll(data);
        notifyDataSetChanged();
    }
}
