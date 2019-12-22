/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import model.Covek;

/**
 *
 * @author Voja
 */
public class Prijatelji extends HttpServlet {

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
        String id = request.getParameter("id");
        String tip = request.getParameter("tip");
        String prijatelji = null;
        ArrayList<Covek> listadirektnih = new ArrayList();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/projekat", "root", "");

            Statement st = konekcija.createStatement();
            String ispisLjudi = "Select * from ljudi where id =  " + id;
            ResultSet rs = st.executeQuery(ispisLjudi);
            if (rs.next()) {
                prijatelji = rs.getString("prijatelji");
            }

            if (tip.equals("direct")) {
                String[] idPrijatelji = new String[1];
                idPrijatelji = vracaniz(prijatelji);

                for (String prijatelj : idPrijatelji) {
                    String ispisID = "Select * from ljudi where id = " + prijatelj;
                    rs = st.executeQuery(ispisID);
                    if (rs.next()) {
                        listadirektnih.add(new Covek(rs.getInt("ID"), rs.getNString("Ime"), rs.getNString("Prezime"), rs.getInt("Godine"), rs.getNString("Pol"), rs.getNString("Prijatelji")));
                    }
                }

                request.setAttribute("ListaLjudi", listadirektnih);
                request.getRequestDispatcher("drugastrana.jsp").forward(request, response);

            }

            if (tip.equals("fof")) {
                ArrayList<Covek> ljudi = new ArrayList<Covek>();
                String[] idPrijatelji = new String[1];

                idPrijatelji = vracaniz(prijatelji);

                String upit = "SELECT * FROM ljudi WHERE id !=" + id;
                rs = st.executeQuery(upit);
                while (rs.next()) {
                    ljudi.add(new Covek(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("godine"), rs.getString("pol"), rs.getString("prijatelji")));
                }

                for (Covek covek : ljudi) {
                    String idPoredjenje[] = new String[1];
                    idPoredjenje = vracaniz(covek.getPrijatelji());
                    for (String s : idPoredjenje) {
                        for (String idPrijatelja : idPrijatelji) {
                            if (s.equals(idPrijatelja) && !s.equals(id)) {
                                listadirektnih.add(covek);
                            }
                        }
                    }
                }

                request.setAttribute("ListaLjudi", listadirektnih);
                request.getRequestDispatcher("drugastrana.jsp").forward(request, response);
            }

            if (tip.equals("suggested")) {
                ArrayList<Covek> ljudi = new ArrayList<Covek>();
                String[] idPrijatelji = new String[1];

                idPrijatelji = vracaniz(prijatelji);

                String upit = "SELECT * FROM ljudi WHERE id !=" + id;
                rs = st.executeQuery(upit);
                while (rs.next()) {
                    ljudi.add(new Covek(rs.getInt("id"), rs.getString("ime"), rs.getString("prezime"), rs.getInt("godine"), rs.getString("pol"), rs.getString("prijatelji")));
                }

                for (Covek covek : ljudi) {
                    int count = 0;
                    String idPoredjenje[] = new String[1];
                    idPoredjenje = vracaniz(covek.getPrijatelji());

                    for (String s : idPoredjenje) {
                        for (String idPrijatelja : idPrijatelji) {
                            if (s.equals(idPrijatelja) && !s.equals(id)) {
                                count++;
                            }

                        }

                    }
                    if (count >= 2) {
                        listadirektnih.add(covek);
                    }

                }

                request.setAttribute("ListaLjudi", listadirektnih);
                request.getRequestDispatcher("drugastrana.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException cnfe) {
            request.setAttribute("Greska", cnfe.toString()
            );
            request.getRequestDispatcher("drugastrana.jsp").forward(request, response);
        } catch (SQLException sqle) {
            request.setAttribute("Greska", sqle.toString());
            request.getRequestDispatcher("drugastrana.jsp").forward(request, response);
        }

    }

    String[] vracaniz(String prijatelji) {
        String nizniz[] = new String[1];
        if (prijatelji.contains(",")) {
            nizniz = prijatelji.split(",");
        } else {
            nizniz[0] = prijatelji;
        }
        return nizniz;
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
