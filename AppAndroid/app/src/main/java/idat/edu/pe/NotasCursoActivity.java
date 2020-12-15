package idat.edu.pe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class NotasCursoActivity extends AppCompatActivity {

    TextView tvnota1, tvnota2, tvnota3,tvnota4;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas_curso);

        tvnota1 = findViewById(R.id.tvNota1);
        tvnota2 = findViewById(R.id.tvNota2);
        tvnota3 = findViewById(R.id.tvNota3);
        tvnota4 = findViewById(R.id.tvNota4);

        mQueue = Volley.newRequestQueue(this);

        ConsumirWS();
    }

    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+ MainActivity.IP+":3000/rest/notasCurso/"+MenuActivity.USUARIO+"/"+CursosDetalleActivity.id_curso;
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
                                String nota1 = obj.getString("nota1");
                                String nota2 = obj.getString("nota2");
                                String nota3 = obj.getString("nota3");
                                String nota4 = obj.getString("nota4");

                                tvnota1.append(nota1);
                                tvnota2.append(nota2);
                                tvnota3.append(nota3);
                                tvnota4.append(nota4);
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
