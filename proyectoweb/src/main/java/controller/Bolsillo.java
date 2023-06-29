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

    BolsilloVO bolsilloVO = new BolsilloVO();
    BolsilloDAO bolsilloDAO = new BolsilloDAO();

    // ------------------------------------ MENU DO - GET ------------------------------------

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String vista = req.getParameter("vista");
        switch (vista) {
            case "listar":
            Listar(req, resp);
                break;
            
            case "consultar":
            consultarSaldo(req, resp);
                break;
            
            case "recargar":

            String idBolsilloParam = req.getParameter("idBolsillo");
                if (idBolsilloParam != null && !idBolsilloParam.isEmpty()) {
                    int idBolsillo = Integer.parseInt(idBolsilloParam);
                    req.setAttribute("idBolsillo", idBolsillo);
                }


            req.getRequestDispatcher("views/recargarSaldo.jsp").forward(req, resp);
                break;

            case "retirar":

            String idBolsilloPara = req.getParameter("idBolsillo");
                if (idBolsilloPara != null && !idBolsilloPara.isEmpty()) {
                    int idBolsillo = Integer.parseInt(idBolsilloPara);
                    req.setAttribute("idBolsillo", idBolsillo);
                }


            req.getRequestDispatcher("views/retirarSaldo.jsp").forward(req, resp);
                break;

            case "registrarBolsillo":
                req.getRequestDispatcher("views/registrarBol.jsp").forward(req, resp);
                break;

            case "inter":

                req.getRequestDispatcher("views/inter.jsp").forward(req, resp);

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
            case "registrarBolsillo":
            registrarBolsillo(req, resp);
                break;
        
            case "listar":
            Listar(req, resp);
                break;
            
            case "consultar":  
            consultarSaldo(req, resp);
                break;
            
            case "recargar":
            recargarSaldo(req, resp);
                break;

            case "retirar":
            retirarSaldo(req, resp);
                break;


            default:
                break;
        }
    }

    // ------------------------------------ REGISTRAR BOLSILLO ------------------------------------
    
    public void registrarBolsillo(HttpServletRequest req, HttpServletResponse res){

       if (req.getParameter("nombreBolsillo") != null) {
            bolsilloVO.setNombreBolsillo(req.getParameter("nombreBolsillo"));
       } 

       if (req.getParameter("estado") != null) {
            bolsilloVO.setEstado(req.getParameter("estado").equals("on"));
       }

       try {
        bolsilloDAO.registrarBolsillo(bolsilloVO);
        System.out.println("BOLSILLO REGISTRADO CORRECTAMENTE");
        req.getRequestDispatcher("views/inter.jsp").forward(req, res);
       } catch (Exception e) {
        System.out.println("ERROR AL INSERTAR EL BOLSILLO:"+e.getMessage().toString());
       }

    }

    // ------------------------------------ LISTAR BOLSILLOS ------------------------------------

    public void Listar(HttpServletRequest req, HttpServletResponse resp) {

        try {
            
            List<BolsilloVO> bolsillo = bolsilloDAO.Listar(); 
            req.setAttribute("bolsillo", bolsillo);
            System.out.println("DATOS LISTADOS");
            req.getRequestDispatcher("views/listaBolsillo.jsp").forward(req, resp);


        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage().toString());
        }
    }

    // ------------------------------------ CONSULTAR SALDO  ------------------------------------
    
    public void consultarSaldo(HttpServletRequest req, HttpServletResponse resp) {
    
    int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
    
    try { 
        bolsilloVO.setIdBolsillo(idBolsillo);    
        double saldo = bolsilloDAO.consultarSaldo(bolsilloVO);    
        req.setAttribute("saldo", saldo);
        req.getRequestDispatcher("views/consultarSaldo.jsp").forward(req, resp);
    } catch (Exception e) {
        System.out.println("ERROR"+e.getMessage().toString());
    }
    
    }

    // ------------------------------------ RECARGAR SALDO ------------------------------------

    public void recargarSaldo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
        int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
        double valorRecarga = Double.parseDouble(req.getParameter("valorRecarga"));


        try {
            
            bolsilloDAO.recargaSaldo(idBolsillo, valorRecarga);
            Listar(req, resp);

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage().toString());
        }
        
        req.getRequestDispatcher("views/listaBolsillo.jsp").forward(req, resp);

    }

    // ------------------------------------ RETIRAR SALDO ------------------------------------

    public void retirarSaldo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
 
        int idBolsillo = Integer.parseInt(req.getParameter("idBolsillo"));
        double valorRetiro = Double.parseDouble(req.getParameter("valorRetiro"));


        try {
            
            bolsilloDAO.retirarSaldo(idBolsillo, valorRetiro);
            Listar(req, resp);

        } catch (Exception e) {
            System.out.println("Error:"+e.getMessage().toString());
        }
        
        req.getRequestDispatcher("views/listaBolsillo.jsp").forward(req, resp);

    }

    
}
