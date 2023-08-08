
public class Gorev {
    private int id;
    private String gorev_adi;
    private String gorev_aciklama;
    private String onemi;
    private String durum;

    public Gorev(int id, String gorev_adi, String gorev_aciklama, String onemi, String durum) {
        this.id = id;
        this.gorev_adi = gorev_adi;
        this.gorev_aciklama = gorev_aciklama;
        this.onemi = onemi;
        this.durum=durum;
    }

    public Gorev(String gorev_adi, String gorev_aciklama, String onemi,String durum) {
        this.gorev_adi = gorev_adi;
        this.gorev_aciklama = gorev_aciklama;
        this.onemi = onemi;
        this.durum=durum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGorev_adi() {
        return gorev_adi;
    }

    public void setGorev_adi(String gorev_adi) {this.gorev_adi = gorev_adi;}

    public String getGorev_aciklama() {
        return gorev_aciklama;
    }

    public void setGorev_aciklama(String gorev_aciklama) {
        this.gorev_aciklama = gorev_aciklama;
    }

    public String getOnemi() {
        return onemi;
    }

    public void setOnemi(String onemi) {
        this.onemi = onemi;
    }
    public String getDurum() {
        return durum;
    }

    public void setDurum(String durum) {
        this.durum = durum;
    }
}
