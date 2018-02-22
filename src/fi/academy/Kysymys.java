package fi.academy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Kysymys {
    private int id;
    private String kysymysteksti;

    public Kysymys(int id) {
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
        PreparedStatement pstmt = con.prepareStatement("select * from kysymys");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            System.out.println(rs);
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
