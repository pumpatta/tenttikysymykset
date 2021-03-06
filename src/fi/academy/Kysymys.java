package fi.academy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public int arvoKysymykset() throws SQLException, ClassNotFoundException {
        Connection con = Yhteys.avaaYhteys();
//        String sql = "select count(id) as total from kysymys";
////        PreparedStatement lause = con.prepareStatement(sql);
////        ResultSet rs = lause.executeQuery();
////        rs.getInt("total");
////        System.out.println("rs tulostus" + rs);

        int total = 0;
        Statement lause = con.createStatement();
        ResultSet rs = lause.executeQuery("SELECT count(id) as total from kysymys");
        while (rs.next()) {
            total = rs.getInt("total");
        }
        return total;
    }

    public void tulostaKysymys(int id) throws SQLException, ClassNotFoundException {
        Connection con = Yhteys.avaaYhteys();

        String sql = "SELECT * from kysymys where id=?";
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, id);
        ResultSet rs = lause.executeQuery();
        while (rs.next()) {
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
        while (rs.next()) {
            System.out.println(i + ") " + rs.getString(3));
            i++;
        }
    }

    public boolean tarkistus(int kysymysid, int vastausid) throws SQLException, ClassNotFoundException {
        Connection con = Yhteys.avaaYhteys();

        String sql = "SELECT * from kysymysvaihtoehdot where kysymysid=?";
        PreparedStatement lause = con.prepareStatement(sql);
        lause.setInt(1, kysymysid);
        ResultSet rs = lause.executeQuery();
        int totuus = 0;
        while (rs.next()) {
            if (rs.getString(4).equals("T")) {
                totuus = rs.getInt(1);
            }
        }
        if (totuus == vastausid) {
            System.out.println("Vastasit oikein!");
            return true;

        } else {
            System.out.println("Vastasit väärin.");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Kysymys{" +
                "id=" + id +
                ", kysymysteksti='" + kysymysteksti + '\'' +
                '}';
    }
}
