import java.sql.SQLException;
import java.util.*;
import java.sql.Statement.*;
import java.sql.Connection;

public class Telefon extends Cihazlar{


    int islem = 0;
    public Telefon(int secenek) throws SQLException
    {
        super(secenek);
        cihazTipi = "telefon";

        System.out.println("1- Kayit");
        System.out.println("2- Telefonların Listesi");

        System.out.print("Lutfen islem giriniz: ");
        islem = scan.nextInt();


        if(islem==1)
        {
            cihaz_kayit();
        }
        else if(islem==2)
        {
            ozelListe(cihazTipi);

        }


    }





}
