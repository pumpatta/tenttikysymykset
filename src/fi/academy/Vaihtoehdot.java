package fi.academy;

public class Vaihtoehdot {
    private int id;
    private int kysymysId;
    private String vaihtoehtoteksti;
    private String oikeaVastaus;

    public Vaihtoehdot(int id, int kysymysId, String vaihtoehtoteksti, String oikeaVastaus) {
        this.id = id;
        this.kysymysId = kysymysId;
        this.vaihtoehtoteksti = vaihtoehtoteksti;
        this.oikeaVastaus = oikeaVastaus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKysymysId() {
        return kysymysId;
    }

    public void setKysymysId(int kysymysId) {
        this.kysymysId = kysymysId;
    }

    public String getVaihtoehtoteksti() {
        return vaihtoehtoteksti;
    }

    public void setVaihtoehtoteksti(String vaihtoehtoteksti) {
        this.vaihtoehtoteksti = vaihtoehtoteksti;
    }

    public String getOikeaVastaus() {
        return oikeaVastaus;
    }

    public void setOikeaVastaus(String oikeaVastaus) {
        this.oikeaVastaus = oikeaVastaus;
    }

    @Override
    public String toString() {
        return "Vaihtoehdot{" +
                "id=" + id +
                ", kysymysId=" + kysymysId +
                ", vaihtoehtoteksti='" + vaihtoehtoteksti + '\'' +
                ", oikeaVastaus='" + oikeaVastaus + '\'' +
                '}';
    }
}
