package pe.edu.ulima.loginapp.model;

import pe.edu.ulima.loginapp.model.dto.LoginRequest;
import pe.edu.ulima.loginapp.model.dto.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by sodm on 03/10/2016.
 */
public interface LoginService {
    @POST("/usuarios/login")
    public Call<LoginResponse> login(@Body LoginRequest request);
}
