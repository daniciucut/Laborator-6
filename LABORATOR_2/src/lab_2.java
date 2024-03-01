

/*1. Fișierul judete_in.txt, conține lista neordonată a județelor din țară. Să se încarce
datele din fișier într-un tablou de String-uri și să se ordoneze acest tablou cu ajutorul metodei
sort() din clasa Arrays. Să se returneze pe ce poziție se află în vectorul ordonat un județ
introdus de la tastatură. Se va utiliza metoda de căutare binară din clasa Arrays.*/


import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class lab_2

{


    public static void afisare(String[] Judet)
    {
        for(int i=0;i< Judet.length;i++)
            System.out.println(Judet[i]);

    }
    public static int  cautare(String [] judet)
    {
        String Judet;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti judetul de cautat: ");

        Judet= scanner.next();
        scanner.close();

        int l=0;
        int r= judet.length-1;

        while(l<=r)
        {
            int midle=(l+r)/2;
            int res= Judet.compareTo(judet[midle]);
            if(res==0)
            {
                return midle;
            }

            if(res >0)
            {
              l=midle+1;

            }
            if (res<0)
            {
                l=midle-1;

            }
        }

        return -1;

    }



    public static void main(String[] args) throws FileNotFoundException {





         String[] Judete = new  String[41]; // tabloul in care vom retine judetele
         int i=0;
        String nume_fisier_intrare="C:\\Users\\cucic\\Desktop\\PJ\\LAB-2-2024\\judete_in.txt";


        //deechidem fisierul pentru citire folosinf buffeReader
        BufferedReader reader;

        try {

            reader = new BufferedReader(new FileReader(nume_fisier_intrare));

            String Line; //linia pe care o vom citi

            //citim fiecare linie a fisierului pana ajungem la capat

            while((Line=reader.readLine())!=null)
            {
                System.out.println(Line); //afisam fiecare linie citita

                Judete[i]=Line;
                //System.out.println(Judete[i]);
                i++;


            }
            afisare(Judete);
            Arrays.sort(Judete);
            System.out.println("\n");
            afisare(Judete);






            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

     int binnarySearch=cautare(Judete);
        if (binnarySearch == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at "
                    + "index " + binnarySearch);


    }
}

