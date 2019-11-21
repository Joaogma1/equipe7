/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dominios.Cliente;
import Interfaces.InterfaceCliente;
import Repositorios.RepositorioCliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
@WebServlet(name = "ControladorCliente", urlPatterns = {"/cliente"})
public class ControladorCliente extends HttpServlet {

    private InterfaceCliente _icliente;

    public ControladorCliente() {
        this._icliente = new RepositorioCliente();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        if (sessao.getAttribute("unidade") == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/acessoNegado.jsp");
            dispatcher.forward(request, response);
        } else {
        List<Cliente> c = _icliente.GetAll(new Integer(sessao.getAttribute("unidade").toString()));
        request.setAttribute("lista", c);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/clientes.jsp");
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
        if (new Integer(request.getParameter("id")) != 0) {
            doPut(request, response);
        } else {
            Cliente cliente = new Cliente();

            cliente.setCnpj(request.getParameter("cnpj"));
            cliente.setEmail(request.getParameter("email"));
            cliente.setTelefone(request.getParameter("telefone"));
            cliente.setLogradouro(request.getParameter("logradouro"));
            cliente.setEstado(request.getParameter("estado"));

            _icliente.Add(cliente,0);
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente cliente = new Cliente();
        cliente.setId(new Integer(request.getParameter("id")));
        cliente.setCnpj(request.getParameter("cnpj"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefone(request.getParameter("telefone"));
        cliente.setLogradouro(request.getParameter("logradouro"));
        cliente.setEstado(request.getParameter("estado"));
        _icliente.Update(cliente);

    }
}
