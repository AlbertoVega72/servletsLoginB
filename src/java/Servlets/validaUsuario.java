/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sr. Alberto
 */
@WebServlet(name = "validaUsuario", urlPatterns = {"/validaUsuario"})
public class validaUsuario extends HttpServlet {

    private String comprobar = "";

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse res)
            throws ServletException, IOException {

        String usuario = request.getParameter("user");
        String contra = request.getParameter("password");

        guardaUsuario(usuario,contra);
        
        res.setContentType("text/html");
        PrintWriter out = new PrintWriter(res.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Login</title></head>");
        out.println("<body>");
        out.println("<h1><center>Se ha registrado exitosamente al usuario: "+usuario+"</center></h1>");
        out.println("</body></html>");
        out.close();

    }
    public void guardaUsuario(String usuario, String contra){
        
        cDatos bd = new cDatos();
        try {
            bd.conectar();
            ResultSet rsVal = bd.consulta("call guardaUsuario('" + usuario + "', '"+contra+"');");            

        } catch (Exception xxD) {
            comprobar = xxD.getMessage();
        }
    }
}
