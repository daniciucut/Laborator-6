
/*3. Să se insereze într-o anumită poziție a unui șir de caractere, un alt șir. Datele vor fi
preluate de la tastatură sau din fișier. Să se șteargă o porțiune a unui șir de caractere care
începe dintr-o anumită poziție și are un anumit număr de caractere. Se recomandă utilizarea
clasei StringBuilder*/


import java.io.*;
import java.util.Scanner;

class Sir
{
    private String Line; //linia sirului de caractere

    public Sir(String Line) // Constructor
    {
        this.Line= Line;

    }

    public void ToString()
    {
        System.out.println(Line);
    }

    public void InserareToSpecificPosition()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti subsirul pe care doriti sa-l adaugati:");
        String Subsir = scanner.nextLine();

        int pozitia; //pozitia de la care vrem sa inseram

        System.out.println("Introduceti pozitia de la care se vrea inserarea:");
        pozitia=scanner.nextInt();

        //convertim sirul citit din fisier in StringBuilder

        StringBuilder builder = new StringBuilder(Line);

        //inseram subirul la pozitia dorita cu functia Insert

        builder.insert(pozitia, Subsir);

        //convertim din nou sirul pentru al putea afisa
        String SirFinal =builder.toString();

        Line =SirFinal;






    }
    public void DeleteSubsir()
    {
        Scanner scanner = new Scanner(System.in);


        int pozitia; //pozitia de la care vrem sa stergem

        System.out.println("Introduceti pozitia de la care se vrea stergerea:");
        pozitia=scanner.nextInt();
        int lungime;

        System.out.print("Introduceti lungimea subsirului pe care-l stergem: ");
        lungime=scanner.nextInt();



        scanner.close();


        //convertim sirul citit din fisier in StringBuilder

        StringBuilder builder = new StringBuilder(Line);

        //stergem subirul la pozitia dorita cu functia delete

        builder.delete(pozitia, pozitia + lungime);

        //convertim din nou sirul pentru al putea afisa
        String SirFinal =builder.toString();

        Line =SirFinal;
    }

}
public class exercitiul_3{
    public static void main(String[] args) {

        try {
            BufferedReader  reader = new BufferedReader( new FileReader("C:\\Users\\cucic\\Desktop\\PJ\\LAB-2-2024\\src\\in .txt"));

            String Line;

            Line= reader.readLine();
            Sir Sir= new Sir(Line);
            Sir.ToString();

            Sir.InserareToSpecificPosition(); //apelam functia

            Sir.ToString();

            Sir.DeleteSubsir();

            Sir.ToString();








            reader.close(); //inchidem

        } catch (IOException e) {
            System.err.println(" Eroare la deschidere! " + e.getMessage());
        }


    }
}
