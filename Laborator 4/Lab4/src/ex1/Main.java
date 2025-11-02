package ex1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        List<Echipament> echipamente = null;

        try {
            echipamente = Citire.CitireEchipamente("Lab4/src/ex1/echipamente.txt");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found, " + e.getMessage());
        }


        while (true) {

            System.out.println("\n=== Meniu Echipamente ===");
            System.out.println("0 - Afisare toate echipamentele");
            System.out.println("1 - Afisare imprimante");
            System.out.println("2 - Afisare copiatoare");
            System.out.println("3 - Afisare sisteme de calcul");
            System.out.println("4 - Modificare stare echipament");
            System.out.println("5 - Modificare mod tiparire imprimanta");
            System.out.println("6 - Modificare format copiere copiator");
            System.out.println("7 - Modificare sistem de operare sistem calcul");
            System.out.println("8 - Afisare echipamente vandute");
            System.out.println("9 - Salvare si citire din fisier binar");
            System.out.println("10 - Iesire din program");
            System.out.println("===========================");
            System.out.println("Alegeti optiunea:");
            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 0:
                    for (Echipament e : echipamente) {
                        System.out.println(e);
                    }
                    break;

                case 1:
                    for (Echipament e : echipamente) {
                        if (e instanceof Imprimanta)
                            System.out.println((e));}
                        break;
                case 2:
                    for(Echipament e:echipamente){
                        if( e instanceof Copiator)
                            System.out.println(e);
                    }
                    break;
                case 3:
                    for(Echipament e:echipamente){
                        if( e instanceof SistemCalcul)
                            System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Dati nr_inv al produsului:");
                    int nr_inv=sc.nextInt();
                    sc.nextLine();
                    for(Echipament e:echipamente){
                        if(e.getNr_inv()==nr_inv){
                            System.out.println("Dati starea (achizitionat/expus/vandut):");
                            String stareNoua=sc.nextLine();
                            e.setStare(Stare.valueOf(stareNoua));
                            System.out.println("Detalii actualizate:");
                            System.out.println(e);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Dati nr_inv al produsului:");
                    int nr_inv1=sc.nextInt();
                    sc.nextLine();
                    for(Echipament e:echipamente){
                        if(e.getNr_inv()==nr_inv1 && e instanceof Imprimanta){
                            System.out.println("Dati modul de scriere (color, albnegru):");
                            String stareNoua=sc.nextLine();
                            ((Imprimanta) e).setTiparire(ModTiparire.valueOf(stareNoua));
                            System.out.println("Detalii actualizate:");
                            System.out.println(e);
                        }
                    }
                    break;
                case 6:
                    System.out.println("Dati nr_inv:");
                    int nr_inv2=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dati formatul de copiere (A3/A4):");
                    String formatNou=sc.nextLine();
                    for(Echipament e : echipamente){
                        if(e.getNr_inv()==nr_inv2 && e instanceof Copiator){
                            ((Copiator) e).setFormat(FormatCopiere.valueOf(formatNou));
                            System.out.println("Produsul actualizat:");
                            System.out.println(e);
                        }

                    }
                    break;
                case 7:
                    System.out.println("Dati nr_inv:");
                    int nr_inv3=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Dati sistemul de operare (windows/linux):");
                    String sistemNou=sc.nextLine();
                    for(Echipament e : echipamente){
                        if(e.getNr_inv()==nr_inv3 && e instanceof SistemCalcul){
                            ((SistemCalcul) e).setSistemOp(SistemOperare.valueOf(sistemNou));
                            System.out.println("Produsul actualizat:");
                            System.out.println(e);
                        }

                    }
                    break;
                case 8:
                    for (Echipament e:echipamente){
                        if(e.getStare()==Stare.vandut){
                            System.out.println(e);
                        }
                    }
                    break;
                case 9:
                    SerializareEchipamente.scrieEchipamente(echipamente, "echip.bin");

                    List<Echipament> listaNoua = SerializareEchipamente.citesteEchipamente("echip.bin");

                    for (Echipament e : listaNoua) {
                        System.out.println(e);
                    }
                    break;
                case 10:
                    System.out.println("Iesire din program");
                    System.exit(0);
                    break;



            }

        }

    }
}
