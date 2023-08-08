
import java.sql.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GuncelleServlet", value = "/gorevGuncelle")
public class GuncelleServlet extends HttpServlet {

    private GorevVeri gorevVeri =new GorevVeri();
// Veritabanı bağlantısı yapın
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Connection conn = null;
        Statement stmt = null;

        try {

            String gorev_adi=request.getParameter("gorev_adi");
            String gorev_aciklama=request.getParameter("gorev_aciklama");
            String onemi=request.getParameter("onemi");
            String durum=request.getParameter("durum");
            Gorev gorev1=new Gorev(gorev_adi,gorev_aciklama,onemi,durum);
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/anasayfa", "username", "password");

            // Güncelleme işlemini gerçekleştirin


           durum = request.getParameter("durum");

            stmt = conn.createStatement();


            String sql = "UPDATE gorevler SET durum="+durum;
            stmt.executeUpdate(sql);

            response.sendRedirect("anasayfa.jsp");

            // Güncelleme yapıldıktan sonra başka bir sayfaya yönlendirin
        }

        catch (Exception e) {
            throw new RuntimeException();
        }

         finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }
            }

           catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
