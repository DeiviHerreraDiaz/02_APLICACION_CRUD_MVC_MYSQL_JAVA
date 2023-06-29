package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; // objeto de conexión
    PreparedStatement ps; // preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql = null;
    int filas; // cantidad de filas que devuelve una sentencia


    // ------------------------------------ REGISTRAR USUARIO ------------------------------------

    public int registrarUsuario(UsuarioVO usuario) throws SQLException{

        sql = "INSERT INTO usuario(nombreUsuario, correoUsuario, telefono, usuario, password, estado) VALUES (?,?,?,?,?,?)";

        try {
            
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getCorreoUsuario());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getUsuario());
            ps.setString(5, usuario.getPassword());
            ps.setBoolean(6, usuario.isEstado());

            System.out.println(ps);

            ps.executeUpdate();
            ps.close();

            System.out.println("Se registro correctamente");

        } catch (Exception e) {
            System.out.println("ERROR"+e.getMessage().toString());
        }

        return filas;
    }

    // ------------------------------------ LISTAR USUARIOS ------------------------------------

    public List<UsuarioVO> Listar() throws SQLException{

        List<UsuarioVO> usuarioVO = new ArrayList<>();

        sql = "SELECT * FROM usuario";

        try {
            
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            
            UsuarioVO Lista = new UsuarioVO();

            Lista.setIdUsuario(rs.getInt("idUsuario"));
            Lista.setNombreUsuario(rs.getString("nombreUsuario"));
            Lista.setCorreoUsuario(rs.getString("correoUsuario"));
            Lista.setTelefono(rs.getString("telefono"));
            Lista.setUsuario(rs.getString("usuario"));
            Lista.setPassword(rs.getString("password"));
            Lista.setEstado(rs.getBoolean("estado"));

            usuarioVO.add(Lista);
        }
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage().toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println("Error"+e.getMessage().toString());
            }
        }
        return usuarioVO;
    }

    // ------------------------------------ ACTUALIZAR USUARIOS ------------------------------------

    public int actualizarUsuarios(UsuarioVO usuarioVO) throws SQLException{
    
        sql = "Update usuario set nombreUsuario = ?, correoUsuario = ?, telefono = ?, usuario = ?, password = ?, estado = ? WHERE idUsuario = ?";

        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuarioVO.getNombreUsuario());
            ps.setString(2, usuarioVO.getCorreoUsuario());
            ps.setString(3, usuarioVO.getTelefono());
            ps.setString(4, usuarioVO.getUsuario());
            ps.setString(5, usuarioVO.getPassword());
            ps.setBoolean(6, usuarioVO.isEstado());
            ps.setInt(7, usuarioVO.getIdUsuario());

            System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage().toString());
        }   finally {

            if (ps != null) {                
                ps.close();
            }
            if (con != null) {
                con.close();
          
            }
        } 
    
        return filas;
    }



    // ------------------------------------ INICIAR SESION ------------------------------------


    public int iniciarSesion(UsuarioVO usuario) throws SQLException{

        sql = "SELECT * FROM usuario WHERE usuario = ? and password = ?";

        int resultado = 0;

        try {
            
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());

            rs = ps.executeQuery();
            if (rs.next()) {
                resultado = 1;
        }
            
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage().toString());
        } finally{

            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("ERROR" + e.getMessage().toString());
            }

        }
        return resultado;
    }


    

    
    
}
