package model;

public class UsuarioVO {
    
    // ATRIBUTOS

    private int idUsuario;
    private String nombreUsuario; 
    private String correoUsuario;
    private String telefono;
    private String usuario;
    private String password;
    private boolean estado;

    // CONSTRUCTORES

    public UsuarioVO(){
    }

    public UsuarioVO(int idUsuario, String nombreUsuario, String correoUsuario, String telefono, String usuario,
            String password, boolean estado) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.correoUsuario = correoUsuario;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
        this.estado = estado;
    }

    

    // GETTERS AND SETTERS

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }



}
