import java.sql.SQLException;
import java.util.*;
import java.sql.Statement.*;
import java.sql.Connection;

public class BeyazEsya extends Cihazlar{

    int islem = 0;
    public BeyazEsya(int secenek) throws SQLException
    {

        super(secenek);
        cihazTipi = "beyazesya";

        System.out.println("1- Beyaz Esya Kayit");
        System.out.println("2- Beyaz Esya Listesi");

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
