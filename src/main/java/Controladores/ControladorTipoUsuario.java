/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dominios.TipoUsuario;
import Interfaces.InterfaceTipoUsuario;
import Repositorios.RepositorioTipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorTipoUsuario", urlPatterns = {"/TipoUsuario"})
public class ControladorTipoUsuario extends HttpServlet {

    private InterfaceTipoUsuario _iTipoUser;

    public ControladorTipoUsuario() {
        this._iTipoUser = new RepositorioTipoUsuario();
    }

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorTipoUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorTipoUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        List<TipoUsuario> tu = _iTipoUser.GetAll();

        request.setAttribute("listaUsuarios", tu);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/usuarios.jsp");
        dispatcher.forward(request, response);
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
        TipoUsuario tipoUser = new TipoUsuario();

        tipoUser.setNome(request.getParameter("nome"));

        request.setAttribute("nome", tipoUser.getNome());

        _iTipoUser.Add(tipoUser);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/usuarios.jsp");
        dispatcher.forward(request, response);

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

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoUsuario tipoUser = new TipoUsuario();
        
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        
        tipoUser.setId(new Integer(id));


        _iTipoUser.Remove(tipoUser.getId());
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/usuarios.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoUsuario tipoUser = new TipoUsuario();
        
        String id = request.getParameter("id");
        String nome = request.getParameter("nome");
        
        request.setAttribute("id", id);
        request.setAttribute("nome", nome);
        
        tipoUser.setId(new Integer(id));
        tipoUser.setNome(nome);

        _iTipoUser.Update(tipoUser);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/usuarios.jsp");
        dispatcher.forward(request, response);
    }

}
