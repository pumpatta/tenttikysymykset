package fi.academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kysymys {
    private int id;
    private String kysymysteksti;

    public Kysymys() {
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

    /*
    try {
    Connection con = Yhteys.avaaYhteys();
    } catch (SQLException e) {
        e.printStackTrace();

    }*/
    public void tulostaKysymys(int id) throws SQLException, ClassNotFoundException {
        Connection con = Yhteys.avaaYhteys();

        String sql = "SELECT * from kysymys where id=?";
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, id);
        ResultSet rs = lause.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(2));
        }
        tulostaVaihtoehdot(id);
    }

    public void tulostaVaihtoehdot(int id) throws SQLException, ClassNotFoundException {
        Connection con = Yhteys.avaaYhteys();

        String sql = "SELECT * from kysymysvaihtoehdot where kysymysid=?";
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, id);
        ResultSet rs = lause.executeQuery();
        int i = 1;
        String totuus = "";
        while(rs.next()) {
            System.out.println(i + ") " + rs.getString(3));
            if (rs.getString(4).equals("T")) {
                totuus = rs.getString(3);
            }
            i++;
        }
        System.out.println("totuus on: " + totuus);
    }

    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", kysymysteksti='" + kysymysteksti + '\'' +
                '}';
    }
}
