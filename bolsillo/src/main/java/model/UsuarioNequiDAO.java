package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioNequiDAO {

    /* Atributos para realizar operaciones sobre la BD */

    Connection con; // objeto de conexión
    PreparedStatement ps; // preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql = null;
    int filas; // cantidad de filas que devuelve una sentencia

    // REGISTRAR

    public int registrar(UsuarioNequiVO usuario) throws SQLException {
        sql = "INSERT INTO usuarionequi(nombreUsuario,apellidoUsuario, numero, contraseña) values(?,?,?,?)";
        try {
            con = Conexion.conectar(); // abrir conexión
            ps = con.prepareStatement(sql); // preparar sentencia

            ps.setString(1, usuario.getNombreUSuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getNumero());
            ps.setString(4, usuario.getPassword());

            System.out.println(ps);

            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // cerrar sentencia
            System.out.println("Se registró usuario Nequi correctamente");
        } catch (Exception e) {
            System.out.println("Error en el regisro " + e.getMessage().toString());
        } finally {
            con.close();// cerrando conexión
        }
        return filas;
    }

    // LISTAR

    public List<UsuarioNequiVO> listar() throws SQLException {
        List<UsuarioNequiVO> usuarios = new ArrayList<>();
        sql = "SELECT * FROM Usuarionequi";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                UsuarioNequiVO Lista = new UsuarioNequiVO();
                // Escribir en el setter cada valor encontrado

                Lista.setIdUsuario(rs.getInt("idUsuario"));
                Lista.setNombreUSuario(rs.getString("nombreUSuario"));
                Lista.setApellidoUsuario(rs.getString("apellidoUsuario"));
                Lista.setNumero(rs.getString("numero"));
                Lista.setPassword(rs.getString("contraseña"));
                usuarios.add(Lista);
            }
            ps.close();
            System.out.println("consulta exitosa");
        } catch (Exception e) {
            System.out.println("La consulta no pudo ser ejecutado " + e.getMessage().toString());
        } finally {
            con.close();
        }

        return usuarios;
    }

    // ACTUALIZAR

    public int actualizar(UsuarioNequiVO usuario) throws SQLException {
        sql = "UPDATE usuarionequi SET nombreUsuario=?, apellidoUsuario=?, numero=?, contraseña=? WHERE idUsuario=?";
        try {
            con = Conexion.conectar(); // Abrir conexión
            ps = con.prepareStatement(sql); // Preparar sentencia

            ps.setString(1, usuario.getNombreUSuario());
            ps.setString(2, usuario.getApellidoUsuario());
            ps.setString(3, usuario.getNumero());
            ps.setString(4, usuario.getPassword());
            ps.setInt(5, usuario.getIdUsuario());

            System.out.println(ps);
            ps.executeUpdate(); // Ejecutar sentencia
            ps.close(); // Cerrar sentencia
            System.out.println("Se actualizó el usuario correctamente");

        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());

        } finally {
            con.close(); // Cerrar conexión
        }
        return filas;
    }

}
