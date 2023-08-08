
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "GorevlerServlet", value = "/index")
public class GorevlerServlet extends HttpServlet {

    private GorevVeri gorevVeri =new GorevVeri();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        List<Gorev> gorevler = gorevVeri.gorevleriGetir();

        request.setAttribute("gorev_listesi", gorevler);

        RequestDispatcher rs1=request.getRequestDispatcher("/anasayfa.jsp");

        try {
            rs1.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }


    }

    public void destroy() {
    }
}