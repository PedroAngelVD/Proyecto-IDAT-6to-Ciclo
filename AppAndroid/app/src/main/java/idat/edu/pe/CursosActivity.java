package idat.edu.pe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import idat.edu.pe.Modelo.Cursos;

public class CursosActivity extends AppCompatActivity {


    private RecyclerView rvCursos;
    private CursosAdapter adapter;
    private RequestQueue mQueue;
    private ArrayList<Cursos> vCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);

        rvCursos = findViewById(R.id.rvCursos);
        rvCursos.setLayoutManager(new LinearLayoutManager(CursosActivity.this));
        adapter = new CursosAdapter(CursosActivity.this);
        rvCursos.setAdapter(adapter);
        vCursos = new ArrayList<>();
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
                                    Toast.makeText(CursosActivity.this, "Ud. no esta reinscrito", Toast.LENGTH_SHORT).show();
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
        String url = "http://"+ MainActivity.IP+":3000/rest/cursoAlumno/"+MenuActivity.USUARIO;
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
                                vCursos.add(new Cursos(
                                        obj.getString("id_curso"),
                                        obj.getString("curso")
                                ));
                            }
                            adapter.agregarElementos(vCursos);
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
