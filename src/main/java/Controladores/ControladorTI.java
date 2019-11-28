package Controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorTI", urlPatterns = {"/protegido/ti-page"})
public class ControladorTI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("titulo", "Você possui cargo de TI");
        request.setAttribute("msg", "VOcê terá acesso aos seguintes links:");
        request.getRequestDispatcher("resultado-protegido.jsp")
                .forward(request, response);
    }


}
