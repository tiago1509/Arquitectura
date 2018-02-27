/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAOLab.EstudianteFacadeLocal;
import DAOLab.MateriaFacadeLocal;
import DAOLab.MatriculaFacadeLocal;
import ModeloLab.Estudiante;
import ModeloLab.Materia;
import ModeloLab.Matricula;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Personal
 */
public class ServletLab extends HttpServlet {

    @EJB
    private EstudianteFacadeLocal estudianteFacade;
    @EJB
    private MateriaFacadeLocal materiaFacade;
     @EJB
    private MatriculaFacadeLocal matriculaFacade;

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

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            String action = request.getParameter("action");
            String url = "index.jsp";
            if ("list".equals(action)) {
                List<Materia> findAll = materiaFacade.findAll();
                request.getSession().setAttribute("materia", findAll);
                url = "listMaterias.jsp";
            } else if ("login".equals(action)) {
                String u = request.getParameter("name");
                String p = request.getParameter("password");
                boolean checkLogin = estudianteFacade.checkLogin(u, p);

                if (checkLogin) {
                    request.getSession().setAttribute("login", u);
                    url = "manager.jsp";
                } else {
                    url = "login.jsp?error=1";
                }
            } else if ("logout".equals(action)) {
                request.getSession().removeAttribute("login");
                url = "login.jsp";
            } else if ("enrollment".equals(action)) {
                Matricula a = new Matricula();
                Estudiante e =  new Estudiante ();
                int aux = Integer.parseInt(request.getParameter(""));
                e.setId(aux);
//              
//                a.setPassword(request.getParameter("password"));
//                a.setEmail(request.getParameter("email"));
                matriculaFacade.create(a);
                url = "login.jsp";
            }
            response.sendRedirect(url);
        } finally {
            out.close();
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
