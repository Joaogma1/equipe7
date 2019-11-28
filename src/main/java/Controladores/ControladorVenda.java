/*package Controladores;

import Dominios.Cliente;
import Dominios.Funcionario;
import Dominios.ItemVenda;
import Dominios.TipoUsuario;
import Dominios.UnidadeEmpresarial;
import Dominios.Usuario;
import Dominios.Venda;
import Interfaces.InterfaceFuncionario;
import Interfaces.InterfaceTipoUsuario;
import Interfaces.InterfaceUnidadeEmpresarial;
import Interfaces.InterfaceUsuario;
import Interfaces.InterfaceVenda;
import Repositorios.RepositorioFuncionario;
import Repositorios.RepositorioTipoUsuario;
import Repositorios.RepositorioUnidadeEmpresarial;
import Repositorios.RepositorioUsuario;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControladorVenda", urlPatterns = {"/venda"})
public class ControladorVenda extends HttpServlet {

    private InterfaceUsuario _iusuario;
    private InterfaceTipoUsuario _iTipoUser;
    private InterfaceUnidadeEmpresarial _iUnidadeEmp;
    private InterfaceFuncionario _iFuncionario;
    private InterfaceVenda _iVenda;

    public ControladorVenda() {
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

                    List<Venda> v = _iVenda.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
                    request.setAttribute("lista", v);
                    

                    RequestDispatcher dispatcher = request.getRequestDispatcher("/vendas.jsp");
                    dispatcher.forward(request, response);

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
  
                Cliente cliente = new Cliente();
                cliente.setNome(request.getParameter("cliente"));
                Funcionario func = new Funcionario();
                func.setNome(request.getParameter("nome"));
               
                Venda venda = new Venda();
                venda.setCliente(cliente);
                venda.setFuncionario(func);
                venda.setValorTotal(request.getParameter("valorTotal"));
                venda.setMetodoPagamento(request.getParameter("modoPagamento"));
                venda.setItemVendaCollection(null);
               
                int id = new Integer(request.getParameter("id"));
                String metodoPagamento = new String(request.getParameter("modoPagamento"));
                BigDecimal valorTotal = new BigDecimal(request.getParameter("valorTotal"));
                String funcionario = new String(request.getParameter("funcionario"));
                String client = new String(request.getParameter("cliente"));
                List<ItemVenda> listaProdutos = new  List<ItemVenda>(request.getParameter("itens"));
               
                HttpSession sessao = request.getSession();
                
                _iVenda.Add(venda,new Integer(sessao.getAttribute("unidade").toString()));
            }

        } catch (Exception e) {

        }

    }

   

 /*   @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        int id = new Integer(request.getParameter("id"));
        String metodoPagamento = new String(request.getParameter("modoPagamento"));
        BigDecimal valorTotal = new BigDecimal(request.getParameter("valorTotal"));
        String funcionario = new String(request.getParameter("funcionario"));
        String cliente = new String(request.getParameter("cliente"));
        List<ItemVenda> listaProdutos = new  List<ItemVenda>(request.getParameter("itens")); {};
        
        
        Venda venda = new Venda()
        venda.getCliente().setNome(cliente);
        venda.getFuncionario().setNome(funcionario);
        venda.setValorTotal(valorTotal);
        venda.setMetodoPagamento(metodoPagamento);
        venda.setItemVendaCollection(null);
        
        _ivenda.Update(venda);

    }*/

//}
