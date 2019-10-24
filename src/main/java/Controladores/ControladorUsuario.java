package Controladores;

import Dominios.TipoUsuario;
import Dominios.UnidadeEmpresarial;
import Dominios.Usuario;
import Interfaces.InterfaceTipoUsuario;
import Interfaces.InterfaceUnidadeEmpresarial;
import Interfaces.InterfaceUsuario;
import Repositorios.RepositorioTipoUsuario;
import Repositorios.RepositorioUnidadeEmpresarial;
import Repositorios.RepositorioUsuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/usuario"})
public class ControladorUsuario extends HttpServlet {

    private InterfaceUsuario _iusuario;
    private InterfaceTipoUsuario _iTipoUser;
    private InterfaceUnidadeEmpresarial _iUnidadeEmp;

    public ControladorUsuario() {
        this._iusuario = new RepositorioUsuario();
        this._iTipoUser = new RepositorioTipoUsuario();
        this._iUnidadeEmp = new RepositorioUnidadeEmpresarial();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String acao = "listar";
            if (!request.getParameter("acao").isEmpty()) {
                acao = request.getParameter("acao");
            }

            if (acao.equalsIgnoreCase("listar")) {

                List<Usuario> u = _iusuario.GetAll();
                List<UnidadeEmpresarial> ue = _iUnidadeEmp.GetAll();
                List<TipoUsuario> tu = _iTipoUser.GetAll();
                request.setAttribute("lista", u);
                request.setAttribute("listaunidade", ue);
                request.setAttribute("listatipousuario", tu);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios.jsp");
                dispatcher.forward(request, response);

            } else if (acao.equalsIgnoreCase("deletar")) {
                doDelete(request, response);
            }

        } catch (ServletException e) {
        } catch (IOException e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (new Integer(request.getParameter("id")) != 0) {
                doPut(request, response);
            } else {
                Usuario user = new Usuario();

                user.setEmail(request.getParameter("email"));
                user.setSenha(request.getParameter("senha"));
                user.setIdUnidadeEmp(new Integer(request.getParameter("idunidade")));
                user.setidCargo(new Integer(request.getParameter("idcargo")));
                _iusuario.Add(user);
            }

        } catch (NumberFormatException e) {
        } catch (ServletException e) {
        } catch (IOException e) {
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario user = new Usuario();

        String id = request.getParameter("id");

        user.setId(new Integer(id));

        _iusuario.Remove(user.getId());

        request.removeAttribute("id");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario?acao=listar");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = new Integer(request.getParameter("id"));
        int idUnidade = new Integer(request.getParameter("idunidade"));
        int idCargo = new Integer(request.getParameter("idcargo"));
        String Email = request.getParameter("email");
        
        Usuario user = new Usuario();
        user.setEmail(Email);
        user.setId(id);
        
        user.setidCargo(idCargo);
        user.setIdUnidadeEmp(idUnidade);
        _iusuario.Update(user);

    }

}
