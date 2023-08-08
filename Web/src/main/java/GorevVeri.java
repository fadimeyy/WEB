import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GorevVeri
{
    public GorevVeri() {
    }

    public List<Gorev> gorevleriGetir() {
        List<Gorev> gorevler = new ArrayList<>();

        Connection baglanti=null;
        Statement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="SELECT * FROM gorevler";
            ifade=baglanti.createStatement();
            sonuc= ifade.executeQuery(sql);

            while(sonuc.next()) {

                int id=sonuc.getInt("id");
                String gorev_adi=sonuc.getString("gorev_adi");
                String gorev_aciklama=sonuc.getString("gorev_aciklama");
                String onemi=sonuc.getString("onemi");
                String durum=sonuc.getString("durum");

                Gorev gor1=new Gorev(id,gorev_adi,gorev_aciklama,onemi,durum);
                gorevler.add(gor1);

            }
           return gorevler;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
           kapat(baglanti,ifade,sonuc);
        }

    }

    private void kapat(Connection baglanti, Statement ifade, ResultSet sonuc){
        try {
            if(sonuc!=null) {
                sonuc.close();
            }
            if(ifade!=null) {
                ifade.close();
            }
            if(baglanti!=null) {
                baglanti.close();
            }
        }catch (Exception exc) {
            exc.printStackTrace();
        }

    }

    public void gorevEkle(Gorev gorev1) {

        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();
            String sql="INSERT INTO gorevler (gorev_adi,gorev_aciklama,onemi,durum) VALUES (?,?,?,?)";

            ifade=baglanti.prepareStatement(sql);
            ifade.setString(1,gorev1.getGorev_adi());
            ifade.setString(2,gorev1.getGorev_aciklama());
            ifade.setString(3,gorev1.getOnemi());
            ifade.setString(4,gorev1.getDurum());
            ifade.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    public void gorevSil(int gorevId) {

        Connection baglanti=null;
        PreparedStatement ifade=null;
        ResultSet sonuc=null;

        try {
            baglanti=VeritabaniBaglanti.veritabaniBaslat();

            String sql="DELETE FROM gorevler WHERE id=?";
            ifade=baglanti.prepareStatement(sql);
            ifade.setInt(1,gorevId);
            ifade.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
