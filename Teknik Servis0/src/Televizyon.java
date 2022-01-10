import java.sql.SQLException;
import java.util.*;
import java.sql.Statement.*;
import java.sql.Connection;

public class Televizyon extends Cihazlar{

    int islem = 0;
    public Televizyon(int secenek) throws SQLException
    {

        super(secenek);
        cihazTipi = "televizyon";

        System.out.println("1- Televizyon Kayit");
        System.out.println("2- Televizyon Listesi");

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
