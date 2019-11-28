package Controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorRetaguarda", urlPatterns = {"/protegido/retaguarda-page"})
public class ControladorRetaguarda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("titulo", "Você possui cargo de Retaguarda");
        request.setAttribute("msg", "VOcê terá acesso aos seguintes links:");
        request.getRequestDispatcher("resultado-protegido.jsp")
                .forward(request, response);
    }


}
