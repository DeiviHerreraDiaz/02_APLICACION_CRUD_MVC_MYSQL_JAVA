package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDaviplataDAO;
import model.UsuarioDaviplataVO;

public class Usuario extends HttpServlet {

    UsuarioDaviplataVO UsuarioDaviplataVO = new UsuarioDaviplataVO();
    UsuarioDaviplataDAO UsuarioDaviplataDAO = new UsuarioDaviplataDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String vista = req.getParameter("vista");
        System.out.println(vista);

        switch (vista) {

            
        // INICIO

            case "inicio":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;

        // APARTADO NEQUI


            case "nequi":
                req.getRequestDispatcher("views/nequi.jsp").forward(req, resp);
                break;

            case "interN":
                req.getRequestDispatcher("views/inter_Nequi.jsp").forward(req, resp);
                break;

            case "recargaN":
                req.getRequestDispatcher("views/recargar_nequi.jsp").forward(req, resp);
                break;

            case "retirarN":
                req.getRequestDispatcher("views/retirar_nequi.jsp").forward(req, resp);
                break;

            case "consultarN":
                req.getRequestDispatcher("views/consultar_nequi.jsp").forward(req, resp);
                break;

        // APARTADO DAVIPLATA


            case "daviplata":
                req.getRequestDispatcher("views/daviplata.jsp").forward(req, resp);
                break;

            case "interD":
                req.getRequestDispatcher("views/inter_Daviplata.jsp").forward(req, resp);
                break;

            case "recargaD":
                req.getRequestDispatcher("views/recargar_daviplata.jsp").forward(req, resp);
                break;

            case "retirarD":
                req.getRequestDispatcher("views/retirar_daviplata.jsp").forward(req, resp);
                break;

            case "consultarD":
                req.getRequestDispatcher("views/consultar_daviplata.jsp").forward(req, resp);
            
                break;


            // Redireccionamiento usuario DAVIPLATA

            case "registrarUsu":
                req.getRequestDispatcher("views/formulario.jsp").forward(req, resp);
                break;

            case "Listar":
                listar(req, resp);
                break;


            case "actualizar":
                actualizarUsuario(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");
        System.out.println(accion);

        switch (accion) {
            case "registrarUsuDav":
                registrarUsuDav(req, resp);
                break;

            case "listar":
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

    private void registrarUsuDav(HttpServletRequest req, HttpServletResponse resp) {
        if (req.getParameter("nombre") != null) {
            UsuarioDaviplataVO.setNombreUsuario(req.getParameter("nombre"));
        }
        if (req.getParameter("apellido") != null) {
            UsuarioDaviplataVO.setApellidoUsuario(req.getParameter("apellido"));
        }
        if (req.getParameter("cedula") != null) {
            UsuarioDaviplataVO.setCedula(req.getParameter("cedula"));
        }
        if (req.getParameter("password") != null) {
            UsuarioDaviplataVO.setPassword(req.getParameter("password"));
        }

        try {
            UsuarioDaviplataDAO.registrar(UsuarioDaviplataVO);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("views/daviplata.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Error en la inserción del registro: " + e.getMessage());
        }
    }

    private void listar(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<UsuarioDaviplataVO> usuarios = UsuarioDaviplataDAO.listar();
            req.setAttribute("usuarios", usuarios);
            System.out.println("Datos listados correctamente");
            System.out.println(usuarios);
            req.getRequestDispatcher("views/usuarioDaviplata.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos: " + e.getMessage());
        }
    }

   
    private void actualizarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String nombre = req.getParameter("nombreUsuario");
        String apellido = req.getParameter("apellido");
        String cedula = req.getParameter("cedula");
        String contrasenia = req.getParameter("password");
    
        UsuarioDaviplataDAO usuarioDAO = new UsuarioDaviplataDAO();
    
        try {
            UsuarioDaviplataVO usuario = new UsuarioDaviplataVO();
            usuario.setIdUsuario(idUsuario);
            usuario.setNombreUsuario(nombre);
            usuario.setApellidoUsuario(apellido);
            usuario.setCedula(cedula);
            usuario.setPassword(contrasenia);
    
            usuarioDAO.actualizar(usuario);
    
            System.out.println("Usuario actualizado correctamente");
    
            // Actualizar la lista de usuarios
            listar(req, resp);
    
        } catch (Exception e) {
            System.out.println("Error al actualizar el usuario: " + e.getMessage());
        }
    
        // Redireccionar a la página usuarioDaviplata.jsp después de la actualización
        req.getRequestDispatcher("views/usuarioDaviplata.jsp").forward(req, resp);
    }
    
    }
    
    
    
    

