package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDAO;
import model.UsuarioVO;

public class Usuario extends HttpServlet {

    // Creacion de objetos

    UsuarioVO usuarioVO = new UsuarioVO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    // ------------------------------------ MENU DO - GET ------------------------------------

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String vista = req.getParameter("vista");
        switch (vista) {
            case "registrarUsuario":
            req.getRequestDispatcher("views/formulario.jsp").forward(req, resp);
                break;
            
            case "listar":

            Listar(req, resp);

                break;
        
            default:
                break;
        }
    }

    // ------------------------------------ MENU DO - POST ------------------------------------

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String accion = req.getParameter("accion");

        switch (accion) {
            
            case "login":
            login(req,resp);

            case "registrarUsuario":
            registrarUsuario(req, resp);
                break;

            case "listar":
            Listar(req, resp);
                break;

            case "actualizar":
            actualizarUsuario(req, resp);
                break;

            default:
                break;
        }
    }
    
    // ------------------------------------ REGISTRAR USUARIOS ------------------------------------
    
    private void registrarUsuario(HttpServletRequest req, HttpServletResponse resp) {

            if (req.getParameter("nombreUsuario") != null) {
               usuarioVO.setNombreUsuario(req.getParameter("nombreUsuario")); 
            }
            if (req.getParameter("correoUsuario") != null) {
                usuarioVO.setCorreoUsuario(req.getParameter("correoUsuario"));
            }
            if (req.getParameter("telefono") != null) {
                usuarioVO.setTelefono(req.getParameter("telefono"));
            }
            if (req.getParameter("usuario") != null) {
                usuarioVO.setUsuario(req.getParameter("usuario"));
            }
            if (req.getParameter("password") != null) {
                usuarioVO.setPassword(req.getParameter("password"));
            }
            if (req.getParameter("estado") != null)  {
                usuarioVO.setEstado(req.getParameter("estado").equals("on"));
            }
        
            try {
                usuarioDAO.registrarUsuario(usuarioVO);
                System.out.println("REGISTRADO CORRECTAMENTE");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (Exception e) {
                System.out.println("ERROR AL INSERTAR USUARIO:"+e.getMessage().toString());
            }


        }

    // ------------------------------------ LISTAR USUARIOS ------------------------------------

        public void Listar(HttpServletRequest req, HttpServletResponse resp){

        try {
    
            List<UsuarioVO> usuarioVO = usuarioDAO.Listar();
            req.setAttribute("usuarioVO", usuarioVO);
            req.getRequestDispatcher("views/listaUsuarios.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage().toString());
        }
    }
       
    // ------------------------------------ ACTUALIZAR USUARIOS ------------------------------------
    
    public void actualizarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

        int idUsuario = Integer.parseInt(req.getParameter("idUsuario"));
        String nombreUsuario = req.getParameter("nombreUsuario");
        String correoUsuario = req.getParameter("correoUsuario");
        String telefono = req.getParameter("telefono");
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        Boolean estado = Boolean.parseBoolean(req.getParameter("estado"));

        try {
            usuarioVO.setIdUsuario(idUsuario);
            usuarioVO.setNombreUsuario(nombreUsuario);
            usuarioVO.setCorreoUsuario(correoUsuario);
            usuarioVO.setTelefono(telefono);
            usuarioVO.setUsuario(usuario);
            usuarioVO.setPassword(password);
            usuarioVO.setEstado(estado);

            usuarioDAO.actualizarUsuarios(usuarioVO);

            Listar(req, resp);

        } catch (Exception e) {
            System.out.println("Error"+e.getMessage().toString());
        }

        // REDIRECCIONAMIENTO A LISTAR DESPUES DE LA ACTUALIZACION 
        req.getRequestDispatcher("views/listaUsuarios.jsp").forward(req, resp);

    } 

    // ------------------------------------ INICIAR SESION ------------------------------------
        
    public void login(HttpServletRequest req, HttpServletResponse resp) {
        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");
        usuarioVO.setUsuario(usuario);
        usuarioVO.setPassword(password);

    try {
        int resultado = usuarioDAO.iniciarSesion(usuarioVO);
        if (resultado == 1) {
            req.getRequestDispatcher("views/inter.jsp").forward(req, resp);
        } else {
            req.setAttribute("mensajeError", "No se pudo iniciar sesión. Verifique su nombre de usuario y contraseña.");
            req.getRequestDispatcher("views/login.jsp").forward(req, resp);
        }
    } catch (SQLException e) {
        System.out.println("Error:" + e.getMessage().toString());
    } catch (ServletException | IOException e) {
        System.out.println("Error:" + e.getMessage().toString());
    }
}

}
