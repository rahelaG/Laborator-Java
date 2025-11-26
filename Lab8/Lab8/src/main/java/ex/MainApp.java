package ex;

import java.sql.*;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class MainApp {


    //cerinta 1

    public static void afisare_tabelaPersoane(ResultSet rs, String mesaj) {
        System.out.println("\n---"+mesaj+"---");
        try {
            rs.beforeFirst();
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="+ rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugarePersoana(ResultSet rs,String nume, int varsta) {
        try {
            rs.moveToInsertRow();
            rs.updateString("nume", nume);
            rs.updateInt("varsta",varsta);
            rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int validareVarsta(Scanner sc) throws ExceptieVarsta {
        System.out.println("Dati varsta:");
        String varsta=sc.nextLine();
        int varstaInt;
        if(varsta.matches("\\d+"))
            varstaInt=Integer.parseInt(varsta);
        else
            throw new ExceptieVarsta("Varsta trebuie sa fie un numar!");

        if(varstaInt<0 || varstaInt>100)
            throw new ExceptieVarsta("Varsta trebuie sa fie cuprinsa in intervalul [0,100]");

        return varstaInt;
    }

    //cerinta 2

    public static void afisare_Excursii(ResultSet rs, String mesaj) {
        System.out.println("\n---"+mesaj+"---");
        try {
            rs.beforeFirst();
            while (rs.next())
                System.out.println("idPersoana=" + rs.getInt(1) + " idExcursie=" + rs.getInt(2) + "destinatia="+ rs.getString(3)+ " idExcursie=" + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void adaugareExcursii(ResultSet rs,int idPers, String destinatia, int anul) {
        try {
            rs.moveToInsertRow();
            rs.updateInt("id_persoana", idPers);
            rs.updateString("destinatia",destinatia);
            rs.updateInt("anul",anul);
            rs.insertRow();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int validareAn(Scanner sc, int varsta) throws ExceptieAnExcursie {
        System.out.println("Dati anul:");
        int anul=sc.nextInt();

       int anCurent= LocalDate.now().getYear();
       int anNastere=LocalDate.now().getYear()-varsta;

       if(anul>anCurent)
           throw new ExceptieAnExcursie("Anul trebuie sa fie mai mic decat anul curent!");

       if(anul<anNastere)
           throw new ExceptieAnExcursie("Anul trebuie sa fie mai mare decat data nasterii!");

       return anul;
    }

    public static boolean validarePersoana (ResultSet rs, int id) throws SQLException {
        rs.beforeFirst();
        while (rs.next())
            if(rs.getInt("id")==id) {
                return true;
            }
     return false;
    }

    public static int getVarsta (ResultSet rs, int id) throws SQLException {
        rs.beforeFirst();
        while (rs.next())
            if(rs.getInt("id")==id) {
                return rs.getInt("varsta");
            }
        return -1;
    }

    //cerinta 3

    public static void afisarePersoaneCuExcursii(ResultSet rsPers, ResultSet rsExc) {

        try {
            rsPers.beforeFirst();
            while (rsPers.next()) {
                System.out.println("id=" + rsPers.getInt(1) + ", nume=" + rsPers.getString(2) + ",varsta=" + rsPers.getInt(3));
                System.out.println("Excursii:");
                boolean exc=false;
                rsExc.beforeFirst();
                while (rsExc.next()) {
                    if (rsExc.getInt("id_persoana") == rsPers.getInt("id")){
                        System.out.println("idPersoana=" + rsExc.getInt(1) + " idExcursie=" + rsExc.getInt(2) + " destinatia=" + rsExc.getString(3) + " idExcursie=" + rsExc.getInt(4));
                        exc=true;
                    }
                }
                if(exc==false){
                    System.out.println("Nu are excursii!");
                }
                System.out.println();
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //cerinta 4

    public static int cautareDupaNume(ResultSet rs,String nume) throws SQLException {

        rs.beforeFirst();
        while (rs.next())
            if(rs.getString("nume").equalsIgnoreCase(nume)) {
                return rs.getInt("id");
            }
        else{
                System.out.println("Acest nume nu exista in tabel!");
            }
        return -1;
    }

    public static void afisareDupaNume(ResultSet rs, int id){

        try {
            rs.beforeFirst();
            while (rs.next())
                if(rs.getInt("id_persoana")==id)
                System.out.println("idPersoana=" + rs.getInt(1) + " idExcursie=" + rs.getInt(2) + "destinatia="+ rs.getString(3)+ " idExcursie=" + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//cerinta 5

    public static int cautareDestinatie(ResultSet rs, String dest){
        try {
            rs.beforeFirst();
            while (rs.next()){
                if(rs.getString("destinatia").equalsIgnoreCase(dest))
                    return rs.getInt("id_persoana");}
            System.out.println("Nu exista aceasta destinatie!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static void afisareDupaDestinatie(ResultSet rs,int id) throws SQLException {

        try {
            rs.beforeFirst();
            while (rs.next())
                if(rs.getInt("id")==id)
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="+ rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //cerinta 7

    public static void stergere(ResultSet rs,int id){
        boolean sters=false;
        try {
            rs.beforeFirst();
            while (rs.next())
                if(rs.getInt("id_excursie")==id) {
                    rs.deleteRow();
                    sters=true;
                    break;
                }
            if(sters)
                System.out.println("\nPersoana cu id-ul "+id+" a fost stearsa cu succes!");else
                System.out.println("Nu se gaseste nici o persoana cu id-ul specificat");} catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //cerinta 8

    public static void stergerePersoane(Connection connection,int id){
        String sql="delete from persoane where id=?";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de stergere="+nr_randuri);
        }
        catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }





    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/test2";
        String sql1 = "select * from persoane";
        String sql2 = "select * from excursii";
        try {
            Connection connection = DriverManager.getConnection(url, "root", "Root2000.");
            Statement stPersoane = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            Statement stExcursii = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rsPersoane = stPersoane.executeQuery(sql1);
            ResultSet rsExcursii = stExcursii.executeQuery(sql2);

            while(true){
                System.out.println("Dati optiunea:");
                int opt=sc.nextInt();
                sc.nextLine();
                switch ((opt)){
                    case 1:
                        System.out.println("Dati nume:");
                        String nume=sc.nextLine();
                        int varsta;
                        while(true){
                            try{
                            varsta=validareVarsta(sc);
                            break;
                            } catch (ExceptieVarsta e) {
                                System.out.println("Varsta nu e valida!");;
                            }
                        }
                        adaugarePersoana(rsPersoane,nume,varsta);
                        afisare_tabelaPersoane(rsPersoane,"Afisare dupa adaugare:");
                        break;
                    case 2:
                        afisare_Excursii(rsExcursii,"Tabela excursii:");
                        System.out.println("Dat id ul persoanei:");
                        int id=sc.nextInt();
                        sc.nextLine();
                        if(!validarePersoana(rsPersoane,id)){
                            System.out.println("Aceasta persoana nu exista!");
                        }
                        else{
                            System.out.println("Dati destinatia:");
                            String destinatia=sc.nextLine();
                            int anul;
                            while(true){
                                try{
                                    anul=validareAn(sc,getVarsta(rsPersoane,id));
                                    break;
                                } catch (ExceptieAnExcursie e) {
                                    System.out.println("Reintroduceti anul!");
                                }
                            }
                            adaugareExcursii(rsExcursii,id,destinatia,anul);
                            afisare_Excursii(rsExcursii,"Dupa aduagare:");
                        }
                        break;
                    case 3:
                        afisarePersoaneCuExcursii(rsPersoane, rsExcursii);
                        break;
                    case 4:
                        System.out.println("Dati numele:");
                        String nume4=sc.nextLine();
                        int id4=cautareDupaNume(rsPersoane,nume4);
                        afisareDupaNume(rsExcursii,id4);
                        break;
                    case 5:
                        System.out.println("Dati destinatia:");
                        String destinatia=sc.nextLine();
                        int id5=cautareDestinatie(rsExcursii,destinatia);
                        afisareDupaDestinatie(rsPersoane,id5);
                        break;
                    case 7:
                        afisare_Excursii(rsExcursii,"Inainte de stergere:");
                        System.out.println("Dati id ul excursiei pe care doriti sa o stergeti:");
                        int id7=sc.nextInt();
                        stergere(rsExcursii,id7);
                        afisare_Excursii(rsExcursii,"Dupa stergere:");
                        break;
                    case 8:
                        afisare_tabelaPersoane(rsPersoane,"Inainte de stergere:");
                        afisare_Excursii(rsExcursii,"Inainte");
                        System.out.println("Dati id ul excursiei pe care doriti sa o stergeti:");
                        int id8=sc.nextInt();
                        stergerePersoane(connection,id8);
                        rsPersoane = stPersoane.executeQuery(sql1);
                        rsExcursii = stExcursii.executeQuery(sql2);
                        afisare_tabelaPersoane(rsPersoane,"Dupa stergere:");
                        afisare_Excursii(rsExcursii,"Dupa stergere:");
                        break;

                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
