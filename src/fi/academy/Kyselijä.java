package fi.academy;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kyselijä {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Scanner kyselija = new Scanner(System.in);
        int pisteet = 0;
        ArrayList <Integer> kyssarit = new ArrayList<>();
        Kysymys kysely = new Kysymys();

        for (int i = 1; i <= kysely.arvoKysymykset() ; i++) {
            kyssarit.add(i);
        }
        Collections.shuffle(kyssarit);

        int j = 0;
        while(j<10) {
            int kysymys = kyssarit.get(j);
            try {
                kysely.arvoKysymykset();
                kysely.tulostaKysymys(kysymys);
                System.out.println("Anna vastaus: ");
                int vastaus = kyselija.nextInt();
                if (kysely.tarkistus(kysymys, vastaus)==true) {
                    pisteet++;
                    System.out.println("Pisteesi ovat tällä hetkellä: " + pisteet + "/10");

                } else {
                    System.out.println("Pisteesi ovat tällä hetkellä: " + pisteet + "/10");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        j++;
        }
        System.out.println("Kysely on nyt ohitse! Hyvin tehty! Kokonaispisteesi on: " + pisteet);
    }
}
