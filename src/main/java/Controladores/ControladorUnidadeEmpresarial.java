package Controladores;

import Dominios.UnidadeEmpresarial;
import Interfaces.InterfaceUnidadeEmpresarial;
import Repositorios.RepositorioUnidadeEmpresarial;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorUnidadeEmpresarial", urlPatterns = {"/unidadeempresarial"})
public class ControladorUnidadeEmpresarial extends HttpServlet {

    private InterfaceUnidadeEmpresarial _iUniEmp;

    public ControladorUnidadeEmpresarial() {
        this._iUniEmp = new RepositorioUnidadeEmpresarial();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession();

            if (sessao.getAttribute("unidade") == null) {
                //Verifica se o usuario esta logado.
                RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
                dispatcher.forward(request, response);
            } else {
                //Lista todas as unidades empresarial
                List<UnidadeEmpresarial> tu = _iUniEmp.GetAll(new Integer(sessao.getAttribute("unidade").toString()));

                request.setAttribute("lista", tu);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/unidadeEmpresarial.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            if (new Integer(request.getParameter("id")) != 0) {
//                doPut(request, response);
//            } else {
//                UnidadeEmpresarial unidadeEmp = new UnidadeEmpresarial();
//
//                unidadeEmp.setNomeUnidade(request.getParameter("nome"));
//
//                _iUniEmp.Add(unidadeEmp,0);
//            }
//
//        } catch (Exception e) {
//        }
//
//    }
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        UnidadeEmpresarial unidadeEmp = new UnidadeEmpresarial();
//
//        String id = request.getParameter("id");
//
//        unidadeEmp.setId(new Integer(id));
//
//        _iUniEmp.Remove(unidadeEmp.getId());
//        request.removeAttribute("id");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/unidadeempresarial?acao=listar");
//        dispatcher.forward(request, response);
//
//    }
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UnidadeEmpresarial unidadeEmp = new UnidadeEmpresarial();

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");

        unidadeEmp.setId(new Integer(id));
        unidadeEmp.setNomeUnidade(nome);

        _iUniEmp.Update(unidadeEmp);

    }

}
