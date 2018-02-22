package fi.academy;
import java.sql.SQLException;
import java.util.Scanner;

public class Kyselijä {
    public static void main(String[] args) {
        Scanner kyselija = new Scanner(System.in);
        int pisteet = 0;
        int kaikki = 0;
        while(true) {
            System.out.println("Anna kysymysID (1-2)");
            int kysymys = kyselija.nextInt();

            if(kysymys == 0){
                break;
            }

            Kysymys kysely = new Kysymys();
            try {
                kysely.tulostaKysymys(kysymys);
                System.out.println("Anna vastaus: ");
                int vastaus = kyselija.nextInt();
                if (kysely.tarkistus(kysymys, vastaus)==true) {
                    pisteet++;
                    kaikki++;
                    System.out.println("Pisteesi ovat tällä hetkellä: " + pisteet + "/" + kaikki);

                } else {
                    kaikki++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Pisteesi olivat: " + pisteet);
    }
}
