package fi.academy;
import java.sql.SQLException;
import java.util.Scanner;

public class Kyselijä {
    public static void main(String[] args) {
        Scanner kyselija = new Scanner(System.in);
       // System.out.println("Anna kysymysID (1-2");
       // int kysymys =  kyselija.nextInt();

        Kysymys kysely = new Kysymys(1);
        try {
            kysely.tulostaKysymys(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
