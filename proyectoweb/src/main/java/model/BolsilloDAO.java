package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolsilloDAO {
    
    /* Atributos para realizar operaciones sobre la BD */

    Connection con; // objeto de conexión
    PreparedStatement ps; // preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql = null;
    int filas; // cantidad de filas que devuelve una sentencia

    // CRUD 

    // ------------------------------------ REGISTRAR UN BOLSILLO ------------------------------------

    public int registrarBolsillo (BolsilloVO bolsillo) throws SQLDataException{

        sql = "INSERT INTO bolsillo (nombreBolsillo, saldo, estado) values (?,0,?)";

        try {
            
        con = Conexion.conectar(); 
        ps = con.prepareStatement(sql);

        ps.setString(1, bolsillo.getNombreBolsillo());
        
        ps.setBoolean(2, bolsillo.isEstado());

        ps.executeUpdate();
        ps.close();

        System.out.println("Se registró bolsillo correctamente");

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage().toString());
        }
        return filas;
    }

    // ------------------------------------ LISTAR USUARIOS ------------------------------------

    public List<BolsilloVO> Listar() throws SQLException{

        List<BolsilloVO> bolsillo = new ArrayList<>();
        sql = "SELECT * FROM bolsillo";
        try {
            
        con = Conexion.conectar();
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            
            BolsilloVO Lista = new BolsilloVO();

            Lista.setIdBolsillo(rs.getInt("idBolsillo"));
            Lista.setNombreBolsillo(rs.getString("nombreBolsillo"));
            Lista.setSaldo(rs.getDouble("saldo"));
            Lista.setEstado(rs.getBoolean("estado"));

            bolsillo.add(Lista);

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
        return bolsillo;
    }

    // ------------------------------------ CONSULTAR SALDO ------------------------------------

    public double consultarSaldo(BolsilloVO bolsillo) throws SQLException{

        sql = "SELECT saldo FROM bolsillo where idBolsillo = ?";

        double saldo = 0;

        try {

            con = Conexion.conectar(); 
            ps = con.prepareStatement(sql);

            ps.setInt(1, bolsillo.getIdBolsillo());

            rs = ps.executeQuery();
    
            if (rs.next()) {                
                saldo = rs.getDouble("saldo");
            }

        } catch (Exception e) {

            System.out.println("ERROR"+e.getMessage().toString());

        } finally{

            try {
                if (rs != null) {
                rs.close();
            }

            if (ps != null) {
                ps.close();
            }

            if (con != null) {
                con.close();
            }

            } catch (Exception e) {
                System.out.println("ERROR"+e.getMessage().toString());
            }
        } 
        return saldo;
    }

    // ------------------------------------ RECARGAR SALDO ------------------------------------

    public int recargaSaldo(int idBolsillo, double valorRecarga) throws SQLException{

        sql = "UPDATE bolsillo set saldo = saldo + ? where idBolsillo = ?";

        try {
            
            con = Conexion.conectar(); 
            ps = con.prepareStatement(sql);

            ps.setDouble(1, valorRecarga);
            ps.setInt(2, idBolsillo);
            ps.executeUpdate();


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

            } catch (Exception e) {
                System.out.println("Error"+e.getMessage().toString());
            }

        }

        return filas;
    }

    // ------------------------------------ RETIRAR SALDO ------------------------------------

    public int retirarSaldo(int idBolsillo, double valorRetiro) throws SQLException {
    sql = "UPDATE bolsillo SET saldo = saldo - ? WHERE idBolsillo = ?";
    int filas = 0;
    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = Conexion.conectar(); 
        ps = con.prepareStatement(sql);

        double saldoActual = obtenerSaldo(con, idBolsillo);
        if (saldoActual >= valorRetiro) {
            ps.setDouble(1, valorRetiro);
            ps.setInt(2, idBolsillo);
            filas = ps.executeUpdate();
        } else {
          
            System.out.println("Saldo insuficiente para realizar el retiro.");
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Cerrar recursos
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }

    return filas;
}



private double obtenerSaldo(Connection con, int idBolsillo) throws SQLException {
    String sql = "SELECT saldo FROM bolsillo WHERE idBolsillo = ?";
    double saldo = 0.0;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, idBolsillo);
        rs = ps.executeQuery();

        if (rs.next()) {
            saldo = rs.getDouble("saldo");
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        // Cerrar recursos
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
    }

    return saldo;
}



    
}
