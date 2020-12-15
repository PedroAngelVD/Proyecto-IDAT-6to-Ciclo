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
import idat.edu.pe.Modelo.Cursos;
import idat.edu.pe.R;

public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.ViewHolder>{

    private Context context;
    private ArrayList<Cursos> lista;

    public CursosAdapter(Context context) {
        this.context = context;
        lista = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(context).
                inflate(R.layout.item_cursos, viewGroup, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        final Cursos item = lista.get(i);

        viewHolder.tvIdCursos.setText(item.getId_curso());

        viewHolder.tvNombreCursos.setText(item.getCurso());

        viewHolder.contenedorCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intDetalle = new Intent(context, CursosDetalleActivity.class);
                intDetalle.putExtra("objcursos", item);
                context.startActivity(intDetalle);

            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvIdCursos, tvNombreCursos;
        CardView contenedorCursos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdCursos = itemView.findViewById(R.id.tvIdCursos);
            tvNombreCursos = itemView.findViewById(R.id.tvNombreCursos);
            contenedorCursos = itemView.findViewById(R.id.contenedorCursos);

        }
    }

    public void agregarElementos(ArrayList<Cursos> data){
        lista.clear();
        lista.addAll(data);
        notifyDataSetChanged();
    }

}
