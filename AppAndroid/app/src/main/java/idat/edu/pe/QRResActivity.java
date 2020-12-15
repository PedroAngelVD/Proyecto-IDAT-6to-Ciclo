package idat.edu.pe;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

public class QRResActivity extends AppCompatActivity {

    private long backPressedTime;

    ImageView ivQr2;
    ImageButton btnCapturar2;
    Button btnContinuar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrres);

        Toast.makeText(QRResActivity.this, "El Pago se Realizo Con exito", Toast.LENGTH_SHORT).show();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
        }else{

        }

        ivQr2 = findViewById(R.id.ivQr2);

        btnCapturar2 = findViewById(R.id.btnCaptura2);

        btnCapturar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
                Bitmap bitmap =getScreenShoot(rootView);
                Date date = new Date();
                CharSequence now = android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss",date);
                store(bitmap, "ScreenShoot"+now+".jpg");
            }
        });


        btnContinuar2 = findViewById(R.id.btnContinuar2);

        btnContinuar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        String texto = MenuActivity.USUARIO;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(texto, BarcodeFormat.QR_CODE, 2000,2000);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ivQr2.setImageBitmap(bitmap);
        }catch (WriterException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1000){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permiso Concedido! :)", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Permiso No Concedido :c", Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }

    public static Bitmap getScreenShoot(View view){
        View screenView = view.getRootView();
        screenView.setDrawingCacheEnabled(true);
        Bitmap bitmap = Bitmap.createBitmap(screenView.getDrawingCache());
        screenView.setDrawingCacheEnabled(false);
        return bitmap;
    }

    public void store(Bitmap bm, String filename){
        String dirPath = Environment.getExternalStorageDirectory().getAbsolutePath()+"/DCIM/Camera";
        File dir = new File(dirPath);
        if(!dir.exists()){
            dir.mkdirs();
        }
        File file = new File(dirPath, filename);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
            Toast.makeText(this, "Guardado Correctamente!", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            ex.printStackTrace();
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        backPressedTime = System.currentTimeMillis();

        if(backPressedTime + 3000 > System.currentTimeMillis()) {

            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();

            //startActivity(new Intent(QRResActivity.this, MenuActivity.class));
            return;
        }else{
            Toast.makeText(getBaseContext(),"Presione otra vez para ir al menu",Toast.LENGTH_SHORT);
        }
    }

}
