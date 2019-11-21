package Controladores;

import Dominios.Funcionario;
import Dominios.TipoUsuario;
import Dominios.UnidadeEmpresarial;
import Dominios.Usuario;
import Interfaces.InterfaceFuncionario;
import Interfaces.InterfaceTipoUsuario;
import Interfaces.InterfaceUnidadeEmpresarial;
import Interfaces.InterfaceUsuario;
import Repositorios.RepositorioFuncionario;
import Repositorios.RepositorioTipoUsuario;
import Repositorios.RepositorioUnidadeEmpresarial;
import Repositorios.RepositorioUsuario;
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

@WebServlet(name = "ControladorUsuario", urlPatterns = {"/usuario"})
public class ControladorUsuario extends HttpServlet {

    private InterfaceUsuario _iusuario;
    private InterfaceTipoUsuario _iTipoUser;
    private InterfaceUnidadeEmpresarial _iUnidadeEmp;
    private InterfaceFuncionario _iFuncionario;

    public ControladorUsuario() {
        this._iusuario = new RepositorioUsuario();
        this._iTipoUser = new RepositorioTipoUsuario();
        this._iUnidadeEmp = new RepositorioUnidadeEmpresarial();
        this._iFuncionario = new RepositorioFuncionario();
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

                String acao = "listar";
                if (!request.getParameter("acao").isEmpty()) {
                    acao = request.getParameter("acao");
                }

                if (acao.equalsIgnoreCase("listar")) {

                    List<Usuario> u = _iusuario.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
                    List<UnidadeEmpresarial> ue = _iUnidadeEmp.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
                    List<TipoUsuario> tu = _iTipoUser.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
                    request.setAttribute("lista", u);
                    request.setAttribute("listaunidade", ue);
                    request.setAttribute("listatipousuario", tu);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/usuarios.jsp");
                    dispatcher.forward(request, response);

                } else if (acao.equalsIgnoreCase("deletar")) {
                    doDelete(request, response);
                }
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
                Funcionario func = new Funcionario();
                user.setEmail(request.getParameter("email"));
                user.setSenha(request.getParameter("senha"));
                user.setIdUnidadeEmp(new Integer(request.getParameter("idunidade")));
                user.setidCargo(new Integer(request.getParameter("idcargo")));
                int id_ultimo_usuario = _iusuario.cadastraUsuario(user);

                System.out.println(id_ultimo_usuario);
                func.setCpf(request.getParameter("cpf"));
                func.setNome(request.getParameter("nome"));
                func.setSalario(new BigDecimal(request.getParameter("salario")));
                func.setEnderecoCompleto(request.getParameter("endereco"));
                func.setTelefone(request.getParameter("telefone"));
                func.setIdUser(id_ultimo_usuario);
                HttpSession sessao = request.getSession();
                
                _iFuncionario.Add(func,new Integer(sessao.getAttribute("unidade").toString()));
            }

        } catch (Exception e) {

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
        String senha = (request.getParameter("senha"));
        String Email = request.getParameter("email");
        int idUnidade = new Integer(request.getParameter("idunidade"));
        int idCargo = new Integer(request.getParameter("idcargo"));

        Usuario user = new Usuario();
        user.setEmail(Email);
        user.setId(id);
        user.setSenha(senha);
        user.setidCargo(idCargo);
        user.setIdUnidadeEmp(idUnidade);
        _iusuario.Update(user);

    }

}
