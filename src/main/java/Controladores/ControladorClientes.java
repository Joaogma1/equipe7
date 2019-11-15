package Controladores;

import Dominios.Cliente;
import Interfaces.InterfaceCliente;
import Repositorios.RepositorioCliente;
import com.mysql.cj.xdevapi.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorClientes", urlPatterns = {"/clientes"})
public class ControladorClientes extends HttpServlet {

    private InterfaceCliente _icliente;

    public ControladorClientes() {
        this._icliente = new RepositorioCliente();
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

                List<Cliente> u = _icliente.GetAll();
                request.setAttribute("lista", u);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente.jsp");
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
                Cliente cliente = new Cliente();

                cliente.setCnpj(request.getParameter("cnpj"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setTelefone(request.getParameter("telefone"));
                cliente.setLogradouro(request.getParameter("logradouro"));
                cliente.setEstado(request.getParameter("estado"));

                _icliente.Add(cliente);
            }

        } catch (NumberFormatException e) {
        } catch (ServletException e) {
        } catch (IOException e) {
        }

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cliente user = new Cliente();

        String id = request.getParameter("id");

        user.setId(new Integer(id));

        _icliente.Remove(user.getId());

        request.removeAttribute("id");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/usuario?acao=listar");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente cliente = new Cliente();
        cliente.setId(new Integer(request.getParameter("cnpj")));
        cliente.setCnpj(request.getParameter("cnpj"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setLogradouro(request.getParameter("logradouro"));
        cliente.setEstado(request.getParameter("estado"));
        _icliente.Update(cliente);
        
    }

}
