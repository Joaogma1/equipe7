
package Controladores;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorLogout", urlPatterns = {"/logout"})
public class ControladorLogout extends HttpServlet {
    
    private void sair(HttpServletRequest request, 
            HttpServletResponse response) 
            throws ServletException, IOException {
        // Invalidar sessao do usuario fazendo com o que o mesmo seja deslogado.
        HttpSession sessao = request.getSession();
        sessao.invalidate();
        
        response.sendRedirect(request.getContextPath() + "/login");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        sair(request, response);
    }

}
