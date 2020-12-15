package idat.edu.pe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import idat.edu.pe.Modelo.Cursos;

public class CursosDetalleActivity extends AppCompatActivity {

    public static String id_curso;

    private TextView tvCursosDetalle, tvNombresProfesor,
            tvApellidosProfesor, tvGradoDetalle,
            tvSeccionDetalle, tvPrimSecDetalle, tvHoraInicio, tvHoraFin;
    private AppCompatButton btnverNotas;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos_detalle);

        tvCursosDetalle = findViewById(R.id.tvCursosDetalle);
        tvNombresProfesor = findViewById(R.id.tvNombProfesor);
        tvApellidosProfesor = findViewById(R.id.tvApeProfesor);
        tvGradoDetalle = findViewById(R.id.tvGradoDetalle);
        tvSeccionDetalle = findViewById(R.id.tvSeccionDetalle);
        tvPrimSecDetalle = findViewById(R.id.tvPrimSecDetalle);
        tvHoraInicio = findViewById(R.id.tvHoraInicio);
        tvHoraFin = findViewById(R.id.tvHoraFin);

        mQueue = Volley.newRequestQueue(this);

        if(getIntent().hasExtra("objcursos")) {
            Cursos obj = getIntent().getParcelableExtra("objcursos");
            id_curso = obj.getId_curso();
        }

        btnverNotas = findViewById(R.id.btnVerNotas);

        btnverNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CursosDetalleActivity.this, NotasCursoActivity.class));
            }
        });

        ConsumirWS();
    }


    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+ MainActivity.IP+":3000/rest/detalleCursosAlumno/"+MenuActivity.USUARIO+"/"+id_curso;
        JsonArrayRequest request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for(int i = 0; i < response.length(); i++){
                                JSONObject obj = response.getJSONObject(i);
                                String curso = obj.getString("curso");
                                String nombres = obj.getString("nombres");
                                String apellidos = obj.getString("apellidos");
                                String grado = obj.getString("grado");
                                String seccion = obj.getString("seccion");
                                String primsec = obj.getString("primsec");
                                String horario_inicio = obj.getString("horario_inicio");
                                String horario_fin = obj.getString("horario_fin");

                                tvCursosDetalle.append(curso);
                                tvNombresProfesor.append(nombres);
                                tvApellidosProfesor.append(apellidos);
                                tvGradoDetalle.append(grado);
                                tvSeccionDetalle.append(seccion);
                                tvPrimSecDetalle.append(primsec);
                                tvHoraInicio.append(horario_inicio);
                                tvHoraFin.append(horario_fin);
                            }

                        }catch (JSONException ex){
                            ex.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        mQueue.add(request);
    }
}
