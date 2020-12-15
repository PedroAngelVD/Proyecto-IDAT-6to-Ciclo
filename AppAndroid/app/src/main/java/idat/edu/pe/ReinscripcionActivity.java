package idat.edu.pe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ReinscripcionActivity extends AppCompatActivity {

    private TextView tvCodReinscripcionRes, tvDescripcionRes, tvMontoRes, tvVencimientoRes;
    public static TextView tvEstadoRes;
    private Button btnPagarRes;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinscripcion);

        tvCodReinscripcionRes = findViewById(R.id.tvCodRescripcionRes);
        tvDescripcionRes = findViewById(R.id.tvDescripcionRes);
        tvMontoRes = findViewById(R.id.tvMontoRes);
        tvVencimientoRes = findViewById(R.id.tvVencimientoRes);
        tvEstadoRes = findViewById(R.id.tvEstadoRes);

        btnPagarRes = findViewById(R.id.btnPagarRes);

        btnPagarRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReinscripcionActivity.this, PagoRes1Activity.class));
                finish();
            }
        });

        mQueue = Volley.newRequestQueue(this);

        ConsumirWS();
    }

    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
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

                                String codigo = obj.getString("cod_reinscripcion");
                                String descripcion = obj.getString("descripcion");
                                String monto = obj.getString("monto");
                                String vencimiento = obj.getString("vencimiento").substring(0,10);
                                String estado = obj.getString("estado");

                                tvCodReinscripcionRes.append(codigo);
                                tvDescripcionRes.append(descripcion);
                                tvMontoRes.append(monto);
                                tvVencimientoRes.append(vencimiento);
                                tvEstadoRes.append(estado);

                                if(tvEstadoRes.getText().toString().equals("Pendiente")){
                                    btnPagarRes.setVisibility(View.VISIBLE);
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
