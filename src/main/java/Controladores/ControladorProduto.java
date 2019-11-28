
package Controladores;

import Dominios.Produto;
import Interfaces.InterfaceProduto;
import Repositorios.RepositorioProduto;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorProduto", urlPatterns = {"/produto"})
public class ControladorProduto extends HttpServlet {

    private InterfaceProduto _iProduto;

    public ControladorProduto() {
        this._iProduto = new RepositorioProduto();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        if (sessao.getAttribute("unidade") == null) {
            //Vereficia se o usuario está logado, se não estiver ele retorna para a pagina acesso negado.
            RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
            dispatcher.forward(request, response);
        } else {
            //Lista todos os produtos selecionados na sessão do usuario.
            List<Produto> p = _iProduto.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
            request.setAttribute("lista", p);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/produtos.jsp");
            dispatcher.forward(request, response);
        }
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

        HttpSession sessao = request.getSession();

        Produto p = new Produto();
        p.setNomeProduto(request.getParameter("nome"));
        p.setPreco(new BigDecimal(request.getParameter("preco")));
        if (sessao != null && !sessao.getAttribute("unidade").equals(1)) {
            p.setIdOrigemNav(new Integer(sessao.getAttribute("unidade").toString()));
        }
        _iProduto.Add(p,0);
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
