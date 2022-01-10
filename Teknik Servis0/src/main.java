import java.util.*;
import java.sql.Connection;
import java.sql.*;


public class main {


    public static void main(String[] args) throws SQLException{





        Scanner scan = new Scanner(System.in);

        String cihaz_kodu = "0";


        System.out.println("TEKNIK SERVIS");

        System.out.println();


        boolean durum = true;
        while (durum) {




            System.out.println("1- Telefon");
            System.out.println("2- Televizyon");
            System.out.println("3- Beyaz Esya");
            System.out.println("4- Cihazların listesi");
            System.out.println("5- Kod Sorgula");
            System.out.println();
            System.out.println("0- Programdan çıkış yap");

            System.out.print("Lutfen seciminizi yapın:");

            int secim = scan.nextInt();

            switch (secim) {
                case 1:
                    Telefon telefon = new Telefon(secim);

                    break;


                case 2:
                    Televizyon televizyon = new Televizyon(secim);
                    break;

                case 3:
                    BeyazEsya beyazEsya = new BeyazEsya(secim);
                    break;


                case 4:
                    Cihazlar cihaz = new Cihazlar(secim);
                    break;

                case 5:
                    System.out.print("Lutfen cihaz kodunuzu giriniz: ");
                    cihaz_kodu = scan.next();
                    Cihazlar cihaz2 = new Cihazlar(secim,cihaz_kodu);



                case 0:
                    durum = false;
                    break;


            }


        }

    }




}
