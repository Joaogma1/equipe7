/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dominios.Usuario;
import Interfaces.InterfaceUsuario;
import Repositorios.RepositorioUsuario;
import ViewModel.LoginViewModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorLogin", urlPatterns = {"/login"})
public class ControladorLogin extends HttpServlet {

    private InterfaceUsuario _iusuario;

    public ControladorLogin() {
        this._iusuario = new RepositorioUsuario();
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
            out.println("<title>Servlet ControladorLogin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorLogin at " + request.getContextPath() + "</h1>");
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

        LoginViewModel loginVM = new LoginViewModel();

        loginVM.setEmail(request.getParameter("email"));
        loginVM.setSenha(request.getParameter("senha"));

        request.setAttribute("email", loginVM.getEmail());
        request.setAttribute("senha", loginVM.getSenha());

        Usuario usuarioBuscado = _iusuario.buscarPorEmailSenha(loginVM.getEmail(), loginVM.getSenha());

        Usuario teste = usuarioBuscado;

        if (usuarioBuscado != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("id", usuarioBuscado.getId());
            //sessao.setAttribute("cargo",usuarioBuscado.getIdTipoUsuario());
            //sessao.setAttribute("unidade",usuarioBuscado.getIdUnidade());

            response.sendRedirect("/EquipeSetePi/index.jsp");
        } else {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
        }

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
