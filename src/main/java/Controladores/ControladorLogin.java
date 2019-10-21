
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        LoginViewModel loginVM = new LoginViewModel();

        loginVM.setEmail(request.getParameter("email"));
        loginVM.setSenha(request.getParameter("senha"));

        request.setAttribute("email", loginVM.getEmail());
        request.setAttribute("senha", loginVM.getSenha());

        Usuario usuarioBuscado = _iusuario.buscarPorEmailSenha(loginVM.getEmail(), loginVM.getSenha());

        if (usuarioBuscado != null) {
            HttpSession sessao = request.getSession();
            sessao.setAttribute("id", usuarioBuscado.getId());
            sessao.setAttribute("nivelacesso",usuarioBuscado.getIdTipoUsuario().getNivel());
            sessao.setAttribute("unidade",usuarioBuscado.getIdUnidadeEmp());

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
