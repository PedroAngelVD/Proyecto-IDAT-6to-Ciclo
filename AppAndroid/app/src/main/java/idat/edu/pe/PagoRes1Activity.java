package idat.edu.pe;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class PagoRes1Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String TAG = "PagoRes1Activity";

    Button btnPagarReinscripcion;

    private EditText idMesAnio2;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private RequestQueue mQueue;

    private Spinner sp_tipoDoc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago_res1);

        sp_tipoDoc2 = findViewById(R.id.sp_tipoDoc2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.tipoDocumento, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tipoDoc2.setAdapter(adapter);
        sp_tipoDoc2.setOnItemSelectedListener(this);

        btnPagarReinscripcion = findViewById(R.id.btnPagarReinscripcion);

        idMesAnio2 =  findViewById(R.id.idMesAnio2);

        idMesAnio2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePickerDialog dialog = new DatePickerDialog(
                        PagoRes1Activity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        2020,1,0);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/yyy: " + month + "/" + year);

                String date = month + "/" + year;
                idMesAnio2.setText(date);
            }
        };

        mQueue = Volley.newRequestQueue(this);

        btnPagarReinscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pagar();
            }
        });
    }

    private void Pagar() {
        String url = "http://"+MainActivity.IP+":3000/rest/pagoReinscripcion/"+MenuActivity.USUARIO;

        JsonArrayRequest request;
        request = new JsonArrayRequest(
                Request.Method.POST, url,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try{

                        }catch (Exception ex){
                            Toast.makeText(PagoRes1Activity.this, "Intentelo más tarde.", Toast.LENGTH_SHORT).show();
                            ex.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Intent intent = new  Intent(PagoRes1Activity.this, QRResActivity.class);
                startActivity(intent);
                finish();
            }
        });
        mQueue.add(request);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView) adapterView.getChildAt(0)).setTextColor(Color.parseColor("#0376AD"));
        ((TextView) adapterView.getChildAt(0)).setTextSize(20);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
