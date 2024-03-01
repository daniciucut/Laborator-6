
/*2. Fișierul cantec_in.txt conține versurile unui cântec la alegere. Să se scrie un
program care creează fișierul cantec_out.txt, care conține versurile cântecului original dar în
plus în dreptul fiecărui rând sunt afișate numărul de cuvinte de pe rând şi numărul de vocale
de pe fiecare rând. În dreptul rândurilor care se încheie cu o grupare de litere aleasă se va
pune o steluță (*). Rândurile pentru care un număr generat aleator este mai mic decât 0.1 vor
fi scrise cu majuscule (se vor genera aleator numere între 0 şi 1).
Se va defini o clasă Vers, care are o variabilă membră privată un șir de caractere
reprezentând versul și se va dezvolta câte un operator pentru fiecare cerință de mai sus (o
                                                                                                  metodă care returnează numărul de cuvinte, o metodă care returnează numărul de vocale, etc).
Se va crea un vector de obiecte de tip Vers care va conține informația preluată din fișierul de
intrare.*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import static java.awt.SystemColor.text;

class Vers // clasa Vers  cu metodele adaugate
{

    private String vers; // sirul de caractere ce reprezinta versul

    public Vers(String vers)
    {
        this.vers = vers;

    }

    public  int nrCuvinte() //metoda care returneaza nr de cuvinte pentru fiecare vers nou
    {
        return vers.split("\\s+").length;
    }

    //metoda care returneaza nr de vocale
    public  int nrVocale()
    {
        int count=0;
        for(char c: vers.toCharArray())
        {
            if("aeiouAEIOU.".indexOf(c)!=-1)
            {
                count++;
            }
        }
        return count;
    }

 public String modificareVers(double random)
{
    if(random<0.1)
    {
        return vers.toUpperCase();
    }
    return  vers;

}
    public String toString() {
        return vers;
    }

}


public class exercitiul_2 {
    public static void main(String[] args)
    {
        try {


            BufferedReader reader = new BufferedReader( new FileReader("C:\\Users\\cucic\\Desktop\\PJ\\LAB-2-2024\\src\\cantec_in.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\cucic\\Desktop\\PJ\\LAB-2-2024\\src\\cantec_out.txt"));

            Random random = new Random();

            String Line; //Linia pe care o vom citii

             ArrayList<Vers>  versuri = new ArrayList<>(); //vector de obicte de tipul clasei Vers




            while((Line=reader.readLine())!=null) {
                versuri.add(new Vers(Line));

            }


                for(Vers vers :versuri)
                {
                    double rand = random.nextDouble();
                    String VersModificatRandom =vers.modificareVers(rand);

                    int numarCuvinte = vers.nrCuvinte();
                    int numarVocale = vers.nrVocale();

                    if(VersModificatRandom.endsWith("ing"))
                    {
                        VersModificatRandom +=" *";
                    }
                    writer.write(VersModificatRandom + " <-> " + numarCuvinte +" <-> " + numarVocale );
                    writer.newLine();

                }
                reader.close();
                writer.close();






        } catch (IOException e) {
            System.err.println("Eroare la citire/deschidere fisierelor: " +e.getMessage());

        }

    }
}



