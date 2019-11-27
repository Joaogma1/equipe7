
package Autenticador;

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
        servletNames = { "HomeServlet" },
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
        Usuario usuario = (Usuario) sessao.getAttribute("usuario");
        if (verificarPermissaoAcesso(httpRequest, usuario)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/acessoNegado.jsp");
        }
    }
    
    private boolean verificarPermissaoAcesso(
            HttpServletRequest httpRequest, Usuario usuario) {
        String urlAcessada = httpRequest.getRequestURI();
        if (urlAcessada.endsWith("/home")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/Administrativo") 
                && usuario.verificarPapel("Administrativo")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/Retaguarda") 
                && usuario.verificarPapel("Retaguarda")) {
            return true;
        } else if (urlAcessada.endsWith("/protegido/TI") 
                && usuario.verificarPapel("TI")) {
            return true;
        }else if (urlAcessada.endsWith("/protegido/Vendas") 
                && usuario.verificarPapel("Vendas")) {
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
