package pe.edu.ulima.loginapp.model.dto;

import pe.edu.ulima.loginapp.model.beans.Usuario;

/**
 * Created by sodm on 03/10/2016.
 */
public class LoginResponse {
    private String msg;
    private Usuario usuario;

    public LoginResponse() {
    }

    public LoginResponse(String msg, Usuario usuario) {
        this.msg = msg;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
