package idat.edu.pe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
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

public class DatosAlumnoActivity extends AppCompatActivity {

    TextView tvNombres, tvApellidos, tvGrado, tvSeccion, tvPrimSec;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_alumno);

        tvNombres = findViewById(R.id.tvNombAlumno);
        tvApellidos = findViewById(R.id.tvApeAlumno);
        tvGrado = findViewById(R.id.tvGrado);
        tvSeccion = findViewById(R.id.tvSeccion);
        tvPrimSec = findViewById(R.id.tvPrimSec);

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
                                    ConsumirWS(1);
                                    Toast.makeText(DatosAlumnoActivity.this, "Ud. no esta reinscrito", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    ConsumirWS(2);
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

    private void ConsumirWS(final int a) {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+ MainActivity.IP+":3000/rest/datosAlumno/"+MenuActivity.USUARIO;
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

                                String nombres = obj.getString("nombres_alumno");
                                String apellidos = obj.getString("apellidos_alumno");
                                String grado = obj.getString("grado");
                                String seccion = obj.getString("seccion");
                                String primsec = obj.getString("primsec");

                                if(a == 1) {
                                    tvNombres.append(nombres);
                                    tvApellidos.append(apellidos);
                                }else{
                                    tvNombres.append(nombres);
                                    tvApellidos.append(apellidos);
                                    tvGrado.append(grado);
                                    tvSeccion.append(seccion);
                                    tvPrimSec.append(primsec);
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

}
