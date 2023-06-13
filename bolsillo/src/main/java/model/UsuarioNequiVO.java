package model;

public class UsuarioNequiVO {

    // ATRIBUTOS

    private int idUsuario;
    private String nombreUSuario;
    private String apellidoUsuario;
    private String numero;
    private String password;

    // CONSTRUCTORES

    public UsuarioNequiVO() {

    }

    public UsuarioNequiVO(int idUsuario, String nombreUSuario, String apellidoUsuario, String numero, String password) {
        this.idUsuario = idUsuario;
        this.nombreUSuario = nombreUSuario;
        this.apellidoUsuario = apellidoUsuario;
        this.numero = numero;
        this.password = password;
    }

    // GETTERS AND SETTERS

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUSuario() {
        return nombreUSuario;
    }

    public void setNombreUSuario(String nombreUSuario) {
        this.nombreUSuario = nombreUSuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
