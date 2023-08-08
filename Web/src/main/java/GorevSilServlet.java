import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "GorevSilServlet", value = "/gorevSil")
public class GorevSilServlet extends HttpServlet {

    private GorevVeri gorevVeri =new GorevVeri();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String gorevId=request.getParameter("gorevId");

            gorevVeri.gorevSil(Integer.parseInt(gorevId));
            response.sendRedirect(request.getContextPath()+ "/index");



        }catch (Exception ex) {
            throw new RuntimeException();
        }





    }

    public void destroy() {
    }
}