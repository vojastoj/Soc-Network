/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Covek;

/**
 *
 * @author Voja
 */
public class Svi extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        ArrayList<Covek> SviLjudi = new ArrayList <Covek> ();
        
        try {
           
           Class.forName("com.mysql.jdbc.Driver");
           Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat","root","");
           
           Statement st = konekcija.createStatement();
           String ispisLjudi = "Select * from ljudi";
           ResultSet rs = st.executeQuery(ispisLjudi);
           
           while (rs.next()) {
               SviLjudi.add(new Covek(rs.getInt("ID"), rs.getNString("Ime"), rs.getNString("Prezime"), rs.getInt("Godine"), rs.getNString("Pol"), rs.getNString("Prijatelji")));
               
           }
           request.setAttribute("ListaLjudi", SviLjudi);
           request.getRequestDispatcher("index.jsp").forward(request, response);
                   
           
                   
        
        }
        catch (ClassNotFoundException cnfe){ 
            request.setAttribute("Greska", cnfe.toString()
            );
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch (SQLException sqle) {
            request.setAttribute("Greska", sqle.toString());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
    }

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
        processRequest(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
