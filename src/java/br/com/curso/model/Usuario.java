
package br.com.curso.model;

/**
 *
 * @author USUARIO
 */
public class Usuario {

    private int idUsuario;
    private String email;
    private String senha;
    private String nomeCompleto;
    private String tipoUsuario;
    

    public Usuario() {

        this.idUsuario = 0;
        this.email = "";
        this.senha = "";
        this.nomeCompleto = "";
        this.tipoUsuario = "";
    }

    public Usuario(int idUsuario, String email, String senha, String nomeCompleto, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.email = email;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}

