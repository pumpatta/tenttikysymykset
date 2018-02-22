package fi.academy;

public class Kysymys {
    int id;
    String kysymysteksti;

    public Kysymys(int id, String kysymysteksti) {
        this.id = id;
        this.kysymysteksti = kysymysteksti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKysymysteksti() {
        return kysymysteksti;
    }

    public void setKysymysteksti(String kysymysteksti) {
        this.kysymysteksti = kysymysteksti;
    }

    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", kysymysteksti='" + kysymysteksti + '\'' +
                '}';
    }
}
