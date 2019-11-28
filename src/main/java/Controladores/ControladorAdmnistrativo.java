package Controladores;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorAdmnistrativo", urlPatterns = {"/protegido/administrativo-page"})
public class ControladorAdmnistrativo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("titulo", "Voc� possui cargo de Admnistrador");
        request.setAttribute("msg", "VOc� ter� acesso aos seguintes links:");
        request.getRequestDispatcher("resultado-protegido.jsp")
                .forward(request, response);
    }


}
