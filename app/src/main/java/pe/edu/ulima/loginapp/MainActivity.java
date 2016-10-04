package pe.edu.ulima.loginapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import pe.edu.ulima.loginapp.model.LoginService;
import pe.edu.ulima.loginapp.model.dto.LoginRequest;
import pe.edu.ulima.loginapp.model.dto.LoginResponse;
import pe.edu.ulima.loginapp.model.gestores.GestorLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GestorLogin gestor = new GestorLogin();
        gestor.login("hernan", "123", new GestorLogin.OnLoginTerminado() {
            @Override
            public void onExito(LoginResponse response) {
                onExito(response);
            }

            @Override
            public void onError(String msgError) {
                onError(msgError);
            }
        });

    }

    private void onExito(LoginResponse response){
        Log.i("MainActivity",String.valueOf(response.getUsuario().getId()));
    }

    private void onError(String msg){
        Toast.makeText(MainActivity.this, "msg", Toast.LENGTH_SHORT).show();
    }


}
