package idat.edu.pe;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    ImageButton btnReinscripcion, btnMensualidad, btnDatosAlumno, btnCursos;
    //TextView tvUsuario;
    ImageButton btnCerrarSesion;
    public static String USUARIO;

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnReinscripcion = findViewById(R.id.btnReinscripcion);
        btnMensualidad = findViewById(R.id.btnMensualidad);
        btnDatosAlumno = findViewById(R.id.btnDatosAlumno);
        btnCursos = findViewById(R.id.btnCursos);
        //tvUsuario = findViewById(R.id.tvUsuario);

        btnCerrarSesion = findViewById(R.id.btnCerrarSesion);

        SharedPreferences preferences = getSharedPreferences("appProyecto", MODE_PRIVATE);

        USUARIO = preferences.getString("usuario", "");

        //tvUsuario.setText(USUARIO);

        btnReinscripcion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ReinscripcionActivity.class));
            }
        });

        btnMensualidad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MensualidadActivity.class));
            }
        });

        btnCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CursosActivity.class));
            }
        });

        btnDatosAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DatosAlumnoActivity.class));
            }
        });


    }


    @Override
    public void onBackPressed() {

        if(backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(),"Presione otra vez para salir",Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    @Override
        protected void onResume(){
            super.onResume();

            btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor
                            = getSharedPreferences("appProyecto", MODE_PRIVATE).edit();
                    editor.clear();
                    editor.apply();

                    Intent intent = new Intent(MenuActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }
            });


    }
}
