package idat.edu.pe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    
    // IP de la red del servidor
    public static String IP = "10.10.10.10";

    private ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivLogo = findViewById(R.id.ivLogo);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transicion);
        ivLogo.startAnimation(animation);
        final Intent intentLogin = new Intent(MainActivity.this,LoginActivity.class);

        Thread timer = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(6000);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(intentLogin);

                    finish();
                }
            }
        };
        timer.start();
    }
}
