import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GorevEkleServlet", value = "/gorevEkle")
public class GorevEkleServlet extends HttpServlet {

    private GorevVeri gorevVeri =new GorevVeri();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            String gorev_adi=request.getParameter("gorev_adi");
            String gorev_aciklama=request.getParameter("gorev_aciklama");
            String onemi=request.getParameter("onemi");
            String durum=request.getParameter("durum");

            Gorev gorev1=new Gorev(gorev_adi,gorev_aciklama,onemi,durum);

            gorevVeri.gorevEkle(gorev1);

            response.sendRedirect(request.getContextPath()+ "/index");



        }catch (Exception ex) {
            throw new RuntimeException();
        }





    }

    public void destroy() {
    }
}