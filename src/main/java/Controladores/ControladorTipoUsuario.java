package Controladores;

import Dominios.TipoUsuario;
import Interfaces.InterfaceTipoUsuario;
import Repositorios.RepositorioTipoUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorTipoUsuario", urlPatterns = {"/tipousuario"})
public class ControladorTipoUsuario extends HttpServlet {

    private InterfaceTipoUsuario _iTipoUser;

    public ControladorTipoUsuario() {
        this._iTipoUser = new RepositorioTipoUsuario();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            HttpSession sessao = request.getSession();

            if (sessao.getAttribute("unidade") == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
                dispatcher.forward(request, response);
            } else {

                    List<TipoUsuario> tu = _iTipoUser.GetAll(new Integer(sessao.getAttribute("unidade").toString()));

                    request.setAttribute("lista", tu);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/tiposUsuarios.jsp");;;;;
                    dispatcher.forward(request, response);

            }

        } catch (ServletException e) {
        } catch (IOException e) {
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            if (new Integer(request.getParameter("id")) != 0) {
//                doPut(request, response);
//            } else {
//                TipoUsuario tipoUser = new TipoUsuario();
//
//                tipoUser.setNome(request.getParameter("nome"));
//
//                _iTipoUser.Add(tipoUser,0);
//            }
//
//        } catch (Exception e) {
//        }
//
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TipoUsuario tipoUser = new TipoUsuario();
//
//        String id = request.getParameter("id");
//
//        tipoUser.setId(new Integer(id));
//
//        _iTipoUser.Remove(tipoUser.getId());
//        request.removeAttribute("id");
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/tiposUsuarios?acao=listar");
//        dispatcher.forward(request, response);
//
//    }
//
//    @Override
//    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        TipoUsuario tipoUser = new TipoUsuario();
//
//        String id = request.getParameter("id");
//        String nome = request.getParameter("nome");
//        tipoUser.setId(new Integer(id));
//        tipoUser.setNome(nome);
//
//        _iTipoUser.Update(tipoUser);
//
//    };;

}
