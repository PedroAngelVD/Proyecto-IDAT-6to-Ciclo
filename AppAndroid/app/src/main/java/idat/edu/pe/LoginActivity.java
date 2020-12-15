package idat.edu.pe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
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

public class LoginActivity extends AppCompatActivity {

    private EditText etUsuario, etPassword;
    private Button btnLogin;
    private RequestQueue mQueue;

    private String user, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = findViewById(R.id.etUsuario);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);


        //Instanciar la cola de peticiones
        mQueue = Volley.newRequestQueue(this);

        SharedPreferences preferences = getSharedPreferences("appProyecto", MODE_PRIVATE);

        if(preferences.contains("usuario")){
            startActivity(new Intent(LoginActivity.this, MenuActivity.class));
            finish();
        }

        etPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    //do what you want on the press of 'done'
                    btnLogin.performClick();
                }
                return false;
            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConsumirWS();
            }
        });

    }



    private void ConsumirWS() {
        //Cambiar IP por la Conexión LAN de la Computadora
        String url = "http://"+MainActivity.IP+":3000/rest/usuario";
        JsonArrayRequest request;
        request = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            for(int i = 0; i < response.length(); i++) {
                                JSONObject obj = response.getJSONObject(i);
                                user = obj.getString("usuario");
                                password = obj.getString("pass");

                                //esta en un for por eso sale el Toast..
                                //a través del for hace un recorrido por todos los usuarios por eso es que sale el toast asi este correcto
                                if (etUsuario.getText().toString().equals(user) && etPassword.getText().toString().equals(password)) {
                                    SharedPreferences.Editor editor = getSharedPreferences("appProyecto", MODE_PRIVATE).edit();
                                    editor.putString("usuario", user);
                                    editor.putString("password", password);
                                    editor.apply();
                                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                                    finish();
                                    break;
                                }
                            }

                            if (!etUsuario.getText().toString().equals(user) || !etPassword.getText().toString().equals(password)) {
                                Toast.makeText(LoginActivity.this, "Usuario o Contraseña Incorrecto", Toast.LENGTH_SHORT).show();
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
