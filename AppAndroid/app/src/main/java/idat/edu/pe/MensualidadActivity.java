package idat.edu.pe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import idat.edu.pe.Adapter.CursosAdapter;
import idat.edu.pe.Adapter.MensualidadAdapter;
import idat.edu.pe.Modelo.Cursos;
import idat.edu.pe.Modelo.Mensualidad;

public class MensualidadActivity extends AppCompatActivity {

    private RecyclerView rvMensualidad;
    private MensualidadAdapter adapter;

    private RequestQueue mQueue;
    private ArrayList<Mensualidad> vMensualidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensualidad);

        rvMensualidad = findViewById(R.id.rvMensualidad);
        rvMensualidad.setLayoutManager(new LinearLayoutManager(MensualidadActivity.this));
        adapter = new MensualidadAdapter(MensualidadActivity.this);
        rvMensualidad.setAdapter(adapter);
        vMensualidad = new ArrayList<>();
        mQueue = Volley.newRequestQueue(this);

            String url = "http://"+ MainActivity.IP+":3000/rest/mostrarReinscripcion/"+MenuActivity.USUARIO;
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
                                    String estado = obj.getString("estado");

                                    if(estado.equals("Pendiente")){
                                        Toast.makeText(MensualidadActivity.this, "Ud. no esta reinscrito", Toast.LENGTH_SHORT).show();
                                    }
                                    else{
                                        ConsumirWS();
                                    }
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

    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+ MainActivity.IP+":3000/rest/fechasMensualidad/"+MenuActivity.USUARIO;
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
                                vMensualidad.add(new Mensualidad(
                                        obj.getString("cod_mensualidad"),
                                        obj.getString("vencimiento").substring(0,10)
                                ));
                            }
                            adapter.agregarElementos(vMensualidad);
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
