/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Dominios.TipoUsuario;
import Interfaces.InterfaceTipoUsuario;
import Repositorios.RepositorioTipoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            String acao = request.getParameter("acao");
            if (acao.equalsIgnoreCase("listar")) {
                ArrayList<TipoUsuario> tu = (ArrayList) _iTipoUser.GetAll();
                ArrayList<TipoUsuario> teste = tu;
                request.setAttribute("lista", teste);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/tiposUsuarios.jsp");
                dispatcher.forward(request, response);
            } else if (acao.equalsIgnoreCase("deletar")) {
                doDelete(request, response);
            } else if (acao.equalsIgnoreCase("editar")) {
                doPut(request, response);
            }else{
                 ArrayList<TipoUsuario> tu = (ArrayList) _iTipoUser.GetAll();
                ArrayList<TipoUsuario> teste = tu;
                request.setAttribute("lista", teste);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/tiposUsuarios.jsp");
                dispatcher.forward(request, response);
            }

        } catch (Exception e) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TipoUsuario tipoUser = new TipoUsuario();

        tipoUser.setNome(request.getParameter("nome"));

        request.setAttribute("nome", tipoUser.getNome());

        _iTipoUser.Add(tipoUser);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/tipousuario");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoUsuario tipoUser = new TipoUsuario();

        String id = request.getParameter("id");

        tipoUser.setId(new Integer(id));

        _iTipoUser.Remove(tipoUser.getId());

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/tipousuario");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TipoUsuario tipoUser = new TipoUsuario();

        String id = request.getParameter("id");
        String nome = request.getParameter("nome");

        request.setAttribute("id", id);
        request.setAttribute("nome", nome);

        tipoUser.setId(new Integer(id));
        tipoUser.setNome(nome);

        _iTipoUser.Update(tipoUser);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/tipousuario");
        dispatcher.forward(request, response);
    }

}
