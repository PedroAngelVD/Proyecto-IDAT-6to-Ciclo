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

import idat.edu.pe.Modelo.Mensualidad;

public class MensualidadDetalleActivity extends AppCompatActivity {

    public static String cod_mensualidad;

    private TextView tvCodMensualidad, tvDescripcion, tvMonto, tvVencimiento, tvCodReinscripcion, tvEstado;
    private Button btnPagarMen;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensualidad_detalle);

        tvCodMensualidad = findViewById(R.id.tvCodMensualidadMen);
        tvDescripcion = findViewById(R.id.tvDescripcionMen);
        tvMonto = findViewById(R.id.tvMontoMen);
        tvVencimiento = findViewById(R.id.tvVencimientoMen);
        tvCodReinscripcion = findViewById(R.id.tvCodRescripcionMen);
        tvEstado = findViewById(R.id.tvEstadoMen);

        if(getIntent().hasExtra("objmensualidad")) {
            Mensualidad obj = getIntent().getParcelableExtra("objmensualidad");
            cod_mensualidad = obj.getCod_mensualidad();

        }

        btnPagarMen = findViewById(R.id.btnPagarMen);

        btnPagarMen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MensualidadDetalleActivity.this, PagoMen1Activity.class));
            }
        });

        mQueue = Volley.newRequestQueue(this);

        ConsumirWS();
    }

    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+ MainActivity.IP+":3000/rest/mostrarMensualidad/"+cod_mensualidad+"/"+MenuActivity.USUARIO;
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

                                String codigo = obj.getString("cod_mensualidad");
                                String descripcion = obj.getString("descripcion");
                                String monto = obj.getString("monto");
                                String vencimiento = obj.getString("vencimiento").substring(0,10);
                                String cod_reinscripcion = obj.getString("codigo_reinscripcion");
                                String estado = obj.getString("estado");

                                tvCodMensualidad.append(codigo);
                                tvDescripcion.append(descripcion);
                                tvMonto.append(monto);
                                tvVencimiento.append(vencimiento);
                                tvCodReinscripcion.append(cod_reinscripcion);
                                tvEstado.append(estado);

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
