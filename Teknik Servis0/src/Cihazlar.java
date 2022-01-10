import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;


public class Cihazlar {

    String marka;
    String model;
    String hasar;
    int ucret;
    String sahibi;
    String sahipNo;
    String cihazTipi = "belirtilmemis";
    String tarih2;
    String cihazKod;
    String cihazKodArama;

    Scanner scan = new Scanner(System.in);

    Connection c = null;
    Statement st = null;
    private int secenek;


    public Cihazlar(int secenek) throws SQLException
    {
        this.secenek = secenek;
        if(secenek==1 && secenek == 2 && secenek==3)
        {
            baglantiAc();
        }
        else if(secenek==4)
        {
            baglantiAc();
            listele();
        }



    }

    public Cihazlar(int secenek,String cihazKod)throws SQLException
    {
        baglantiAc();
        cihazKodArama = cihazKod;
        sorgula();
    }


    public void baglantiAc()
    {
        try {
            c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/teknik_servis?user=root&password=123456");
            st =  c.createStatement();
        }
        catch (SQLException err)
        {
            System.out.println("Veri tabanı bağlantı hatası olustu.\n"+err.toString());
        }

    }

    public int cihaz_kayit()
{
    Scanner scan = new Scanner(System.in);

    System.out.print("Cihaz marka:");
    marka = scan.nextLine();

    System.out.print("Cihaz model:");
    model = scan.nextLine();

    System.out.print("Cihaz hasar:");
    hasar = scan.nextLine();


    System.out.print("Cihaz ucret:");
    ucret = scan.nextInt();

    System.out.print("Cihaz sahibi:");
    sahibi = scan.nextLine();

    System.out.print("Telefon no:");
    sahipNo = scan.nextLine();



    Date tarih = new Date();
    DateFormat sdf = new SimpleDateFormat("ddMMYYYYHHmmss");


    Calendar calendar = Calendar.getInstance();


    tarih2 = calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DATE) + " " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND);


    cihazKod = sdf.format(tarih.getTime());





    try { /// Bu kodları çalıştırmayı dene


        String query = "INSERT INTO teknik (cihaz_marka,cihaz_model,cihaz_hasar,cihaz_ucret,cihaz_sahibi,cihaz_sahibi_no,cihaz_kod,cihaz_tipi,cihaz_tarih) VALUES('"+marka+"','"+model+"','"+hasar+"','"+ucret+"','"+sahibi+"','"+sahipNo+"','"+cihazKod+"','"+cihazTipi+"','"+tarih2+"')";
        st.executeUpdate(query);

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Cihaz kodunuz: "+ cihazKod);

        System.out.println("-------------------------");
        st.close();
        c.close();
    }
    catch (SQLException err) // eğer çalışmasında hata olursa hatayı err değişkenine ata ve ekranda yazdır
    {
        System.out.println("Veri tabanı baglantisinda hata olustu."+err.toString());
    }








    return 0;

}


public int listele() throws SQLException {

    ResultSet rs = st.executeQuery("SELECT * FROM teknik");
    while (rs.next()) {
        System.out.println("Cihaz marka: "+rs.getString("cihaz_marka")+" || "+" Cihaz Model: "+rs.getString("cihaz_model")+" Cihaz hasar: "+ rs.getString("cihaz_hasar")+" || "+" Ucret: "+rs.getString("cihaz_ucret")+" || "+"Cihaz Sahibi: "+rs.getString("cihaz_sahibi")+" || "+" Cihaz Sahibi No: "+rs.getString("cihaz_sahibi_no")+" || "+ "Cihaz kodu: "+rs.getString("cihaz_kod")+" || "+"Cihaz Tipi: "+rs.getString("cihaz_tipi")+" || "+ "Cihaz Tarihi:"+rs.getString("cihaz_tarih")+"\n");

    }
    st.close();
    c.close();


    return 0;
}


public int sorgula()throws SQLException
{
    ResultSet rs = st.executeQuery("SELECT cihaz_kod FROM teknik");

    while (rs.next())
    {
        if(rs.getString("cihaz_kod").equalsIgnoreCase(cihazKodArama))
        {
            System.out.println();
            System.out.println("------------------------");
            System.out.println("Kayit bulundu.");
            System.out.println("------------------------");

            System.out.println();




            st.close();
            rs.close();
            c.close();

            baglantiAc();
            sorguAra();


            break;
        }



    }





    return 0;
}

public int sorguAra() throws SQLException
{


    ResultSet rs = st.executeQuery("SELECT * FROM teknik");
    System.out.println("Cihaz marka: "+rs.getString("cihaz_marka")+" || "+" Cihaz Model: "+rs.getString("cihaz_model")+" Cihaz hasar: "+ rs.getString("cihaz_hasar")+" || "+" Ucret: "+rs.getString("cihaz_ucret")+" || "+"Cihaz Sahibi: "+rs.getString("cihaz_sahibi")+" || "+" Cihaz Sahibi No: "+rs.getString("cihaz_sahibi_no")+" || "+ "Cihaz kodu: "+rs.getString("cihaz_kod")+" || "+"Cihaz Tipi: "+rs.getString("cihaz_tipi")+" || "+ "Cihaz Tarihi:"+rs.getString("cihaz_tarih")+"\n");





    return 0;
}

public int ozelListe(String filtre) throws SQLException
{
    try {
        c = DriverManager.getConnection("jdbc:mariadb://localhost:3325/teknik_servis?user=root&password=123456");
        st =  c.createStatement();

        String sql = "SELECT * FROM teknik";
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {


        if(rs.getString("cihaz_tipi").equalsIgnoreCase(cihazTipi))
        {
            System.out.println("Cihaz marka: "+rs.getString("cihaz_marka")+" || "+" Cihaz Model: "+rs.getString("cihaz_model")+" || "+" Cihaz hasar: "+ rs.getString("cihaz_hasar")+" || "+" Ucret: "+rs.getString("cihaz_ucret")+" || "+"Cihaz Sahibi: "+rs.getString("cihaz_sahibi")+" || "+" Cihaz Sahibi No: "+rs.getString("cihaz_sahibi_no")+" || "+ "Cihaz kodu: "+rs.getString("cihaz_kod")+" || "+"Cihaz Tipi: "+rs.getString("cihaz_tipi")+" || "+ "Cihaz Tarihi:"+rs.getString("cihaz_tarih")+"\n");

        }






        }
    } catch (Exception err) {
        err.printStackTrace();
        // System.out.println("Error: " + e.toString());
    }







    return 0;
}


}


