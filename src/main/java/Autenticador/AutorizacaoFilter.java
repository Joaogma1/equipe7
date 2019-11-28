
package Autenticador;

import Dominios.TipoUsuario;
import Dominios.Usuario;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "AutorizacaoFilter", 
        servletNames = { "ControladorHome" },
        urlPatterns = { "/protegido/*" })
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        // Verificar se usuario esta na sessao
        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("usuario") == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        
        // Verificar se usuario tem permissao de acesso na pagina
        TipoUsuario tipousuario = (TipoUsuario) sessao.getAttribute("tipousuario");
        if (verificarPermissaoAcesso(httpRequest, tipousuario)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/acessoNegado.jsp");
        }
    }
    
    private boolean verificarPermissaoAcesso(
        HttpServletRequest httpRequest, TipoUsuario tipousuario) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/home")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/Administrativo") 
                && tipousuario.verificarPapel("Administrativo")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/Retaguarda") 
                && tipousuario.verificarPapel("Retaguarda")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/TI") 
                && tipousuario.verificarPapel("TI")) {
            return true;
        }else if (urlAcessada.endsWith("/protegido/Vendas") 
                && tipousuario.verificarPapel("Vendas")) {
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {        
    }

    @Override
    public void init(FilterConfig filterConfig) {        

    }

}
