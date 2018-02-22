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

        PreparedStatement preparedStatement = null;
        String sql = "SELECT * from kysymys where id=?";
        PreparedStatement lause = con.prepareStatement(sql);
        preparedStatement.setString(1, "id");

//        PreparedStatement pstmt = con.prepareStatement("select * from kysymys where id=?");
//        String annettuId = "1";
        ResultSet rs = lause.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getString(2));
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
