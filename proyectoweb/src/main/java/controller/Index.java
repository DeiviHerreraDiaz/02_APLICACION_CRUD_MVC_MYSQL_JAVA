package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        String vista = req.getParameter("vista");

        switch (vista) {


            case "inicio":
                req.getRequestDispatcher("index.jsp").forward(req, resp);
                break;
            
            case "login":
                req.getRequestDispatcher("views/login.jsp").forward(req, resp);
                break;

            default:
                break;
        }


    }


}
