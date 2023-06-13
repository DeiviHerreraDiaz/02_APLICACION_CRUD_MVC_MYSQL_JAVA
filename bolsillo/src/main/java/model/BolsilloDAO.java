package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BolsilloDAO {

    Connection con; // objeto de conexión
    PreparedStatement ps; // preparar sentencias
    ResultSet rs; // almacenar consutas
    String sql = null;
    int filas; // cantidad de filas que devuelve una sentencia

    // APARTADO REGISTRO BOLSILLO

    public int registrar(BolsilloVO bolsillo) throws SQLException {

        sql = "INSERT INTO bolsillo(nombreBolsillo, saldo, estado) values (?,?,1)";

        try {

            con = Conexion.conectar(); // ABRIREMOS LA CONEXIÓN
            ps = con.prepareStatement(sql); // PREPARAR SENTENCIAS

            ps.setString(1, bolsillo.getNombreBolsillo());
            ps.setDouble(2, bolsillo.getSaldo());

            System.out.println(ps);

            ps.executeUpdate(); // Ejecutar la sentencia anterior
            ps.close(); // CIERRE DE SENTENCIA UPDATE

            System.out.println("Bolsillo registrado correctamente");

        } catch (Exception e) {

            System.out.println("Error en registro de Bolsillo" + e.getMessage().toString());

        } finally {

            con.close(); // Cierre de conexion

        }
        return filas;
    }

    // APARTADO LISTAR BOLSILLO

    public List<BolsilloVO> listar() throws SQLException {

        List<BolsilloVO> bolsillo = new ArrayList<>();
        sql = "SELECT * FROM bolsillo";

        try {

            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                BolsilloVO Lista = new BolsilloVO();

                // ESCRIBIR EN EL SETTER CADA VALOR ENCONTRADO

                Lista.setIdBolsillo(rs.getInt("IdBolsillo"));
                Lista.setNombreBolsillo(rs.getString("nombreBolsillo"));
                Lista.setSaldo(rs.getDouble("saldo"));
                Lista.setEstado(rs.getBoolean("estado"));
                bolsillo.add(Lista);
            }
            ps.close(); // CIERRE DE SENTENCIAS
            System.out.println("CONSULTA EXITOSA DE BOLSILLO");

        } catch (Exception e) {
            System.out.println("LA CONSULTA NO SE EJECUTO" + e.getMessage().toString());
        } finally {

            con.close(); // CIERRE DE CONEXIÓN
        }

        return bolsillo;

    }

    // APARTADO ACTUALZAR BOLSILLO

    public int actualizar(BolsilloVO bolsillo) throws SQLException {

        sql = "UPDATE bolsillo SET estado = ? WHERE IdBolsillo = ?";

        try {

            con = Conexion.conectar(); // CONEXIÓN
            ps = con.prepareStatement(sql);

            ps.setBoolean(1, bolsillo.isEstado());
            ps.setInt(2, bolsillo.getIdBolsillo());

            System.out.println(ps);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("NO FUNCIONA LA ACTUALIZACIÓN DE BOLSILLO" + e.getMessage());
        } finally {

            con.close();
        }

        return filas;
    }

}
