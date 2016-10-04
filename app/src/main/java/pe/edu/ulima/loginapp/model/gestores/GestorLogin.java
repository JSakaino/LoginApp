package pe.edu.ulima.loginapp.model.gestores;

import android.widget.Toast;

import pe.edu.ulima.loginapp.MainActivity;
import pe.edu.ulima.loginapp.model.LoginService;
import pe.edu.ulima.loginapp.model.dto.LoginRequest;
import pe.edu.ulima.loginapp.model.dto.LoginResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sodm on 03/10/2016.
 */
public class GestorLogin {

    public void login(String usuario, String password, final OnLoginTerminado callback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://ul-pokemon.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //creamos una instancia del service
        LoginService service = retrofit.create(LoginService.class);

        //usar el service
        service.login(new LoginRequest(usuario,password)).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                callback.onExito(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
    public interface  OnLoginTerminado{
        public void onExito(LoginResponse response);
        public void onError(String msgError);
    }

}
