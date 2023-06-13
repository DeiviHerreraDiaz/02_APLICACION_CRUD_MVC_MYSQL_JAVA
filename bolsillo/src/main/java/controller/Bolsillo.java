package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BolsilloDAO;
import model.BolsilloVO;


public class Bolsillo extends HttpServlet {
    

    // CREACIÓN DE OBJETOS

    BolsilloDAO BolsilloDAO = new BolsilloDAO();
    BolsilloVO BolsilloVO = new BolsilloVO();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    String vista = req.getParameter("vista");
    System.out.println(vista);

    // CASOS DE LAS VISTAS

    switch (vista) {
        case "registrarBolsillo": 

        // VISTA FORMULARIO
        req.getRequestDispatcher("views/formularioprueba.jsp").forward(req, resp);
            
            break;
    
        case "Listar":

        listar(req, resp);

            break;

        case "actualizar":

            actualizar(req, resp);

            break;


        default:
            break;
    }


    }





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    String accion = req.getParameter("accion");
    System.out.println(accion);


    switch (accion) {
        case "registrarBolsillo":
        

        registrarBolsillo(req, resp);

            break;

        case "listar":


        listar(req, resp);

            break;
    

        case "actualizar":

        actualizar(req, resp);
        listar(req, resp);

            break;


        default:
            break;
    }

    

    }


    // METODO REGISTRAR


    private void registrarBolsillo(HttpServletRequest req, HttpServletResponse resp){

    

        if (req.getParameter("nombreBolsillo") != null) {
            BolsilloVO.setNombreBolsillo(req.getParameter("nombreBolsillo"));
        } 
        
         if (BolsilloVO.getSaldo() == null) {
            // Si el saldo es null, establecer un valor predeterminado
            BolsilloVO.setSaldo(0.0);
        }
    
        try {
            
            BolsilloDAO.registrar(BolsilloVO);
            System.out.println("Registro insertado correctamente");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
    
        } catch (Exception e) {
            System.out.println("Error en el registro del bolsillo" + e.getMessage());
        }
    
    }


    // METODO LISTAR


    private void listar(HttpServletRequest req, HttpServletResponse resp) {


        try {
            
        List<BolsilloVO> bolsillo = BolsilloDAO.listar();
        req.setAttribute("bolsillo", bolsillo);
        System.out.println("DATOS LISTADOS CORRECTAMENTE");
        System.out.println(bolsillo);
        req.getRequestDispatcher("views/listabolsillo.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println("FALLO EN LISTADO DE DATOS DE BOLSILLO"+ e.getMessage());
        }

    }


    private void actualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    int IdBolsillo = Integer.parseInt(req.getParameter("IdBolsillo"));
    boolean estado = Boolean.parseBoolean(req.getParameter("estado"));

    BolsilloDAO BolsilloDAO = new BolsilloDAO();

    try {
        
    BolsilloVO BolsilloVO = new BolsilloVO();

    BolsilloVO.setIdBolsillo(IdBolsillo);
    BolsilloVO.setEstado(estado);

    BolsilloDAO.actualizar(BolsilloVO);

    System.out.println("BOLSILLO ACTUALIZADO CORRECTAMENTE");

    
    listar(req, resp);


    } catch (Exception e) {
        System.out.println("Error al actualizar el bolsillo" +e.getMessage());
    }

    req.getRequestDispatcher("views/listabolsillo.jsp").forward(req, resp);

    }


}
