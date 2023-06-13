package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioNequiDAO;
import model.UsuarioNequiVO;

public class UsuarioNequi extends HttpServlet {

    UsuarioNequiVO UsuarioNequiVO = new UsuarioNequiVO();
    UsuarioNequiDAO UsuarioNequiDAO = new UsuarioNequiDAO();

    // DIRECCIONAMIENTO

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vista = req.getParameter("vista");
        System.out.println(vista);

        switch (vista) {
            case "registrarUsuNequi":
                req.getRequestDispatcher("views/formularioNequi.jsp").forward(req, resp);
                break;

            case "Listar":

                listar(req, resp);

                break;

            default:
                break;
        }

    }

    // FUNCIONALIDADES

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {
            case "registrarUsuNequi":
                registrarUsuNeq(req, resp);

                break;

            case "Listar":

                listar(req, resp);

                break;

            case "actualizar":

                actualizarUsuario(req, resp);
                listar(req, resp);

                break;

            default:
                break;
        }

    }

    private void registrarUsuNeq(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("nombre") != null) {
            UsuarioNequiVO.setNombreUSuario(req.getParameter("nombre"));
        }
        if (req.getParameter("apellido") != null) {
            UsuarioNequiVO.setApellidoUsuario(req.getParameter("apellido"));
        }
        if (req.getParameter("numero") != null) {
            UsuarioNequiVO.setNumero(req.getParameter("numero"));
        }
        if (req.getParameter("password") != null) {
            UsuarioNequiVO.setPassword(req.getParameter("password"));
        }

        try {
            UsuarioNequiDAO.registrar(UsuarioNequiVO);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("views/daviplata.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro: " + e.getMessage());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<UsuarioNequiVO> usuarios = UsuarioNequiDAO.listar();
            req.setAttribute("usuarios", usuarios);
            System.out.println("Datos listados correctamente");
            System.out.println(usuarios);
            req.getRequestDispatcher("views/usuarioNequi.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos: " + e.getMessage());
        }
    }

    private void actualizarUsuario(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String nombre = req.getParameter("nombreUsuario");
        String apellido = req.getParameter("apellidoUsuario");
        String numero = req.getParameter("numero");
        String password = req.getParameter("password");

        UsuarioNequiDAO UsuarioNequiDAO = new UsuarioNequiDAO();

        try {
            UsuarioNequiVO usuario = new UsuarioNequiVO();
            usuario.setIdUsuario(idUsuario);
            usuario.setNombreUSuario(nombre);
            usuario.setApellidoUsuario(apellido);
            usuario.setNumero(numero);
            usuario.setPassword(password);

            UsuarioNequiDAO.actualizar(usuario);

            System.out.println("Usuario actualizado correctamente");

            // Actualizar la lista de usuarios
            listar(req, resp);

        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }

        // Redireccionar a la página usuarioDaviplata.jsp después de la actualización
        req.getRequestDispatcher("views/usuarioNequi.jsp").forward(req, resp);
    }

}
