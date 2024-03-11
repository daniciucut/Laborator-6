import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Parabola //clasa Parabola
{
    private int a;
    private int b;
    private int c;

    public Parabola(int a, int b, int c) //constructorul clasei Parobala
    {
        this.a=a;
        this.b=b;
        this.c=c;

    }

    public double [] CalculeazaVarful() {

        double firstCoordonate;
        double secondCoordonate;

        firstCoordonate= (double) (-b) /(2*a);
        secondCoordonate =(double) (((-(b*b)) + 4*a*c) / 4*a);

        return new double[]{firstCoordonate, secondCoordonate};

    }

    public  String toString() {


        return  " f(x) = " + a + " x^2 " +b +" x " + c;
    }


   public  double []CalculeazaMijlocul (Parabola P ) {// OBIECT DE TIP PAROBOLA LA APEL


       double firstCoordonate = (double) (-P.b) / (2 * P.a);


       double secondCoordonate = (double) (((-(P.b * P.b)) + 4 * P.a * P.c) / 4 * P.a);

      double x = (firstCoordonate + CalculeazaVarful()[0])/2;
      double y = (secondCoordonate +CalculeazaVarful()[1])/2;

      return  new double[]{x, y};


   }
    public static double[] CalculeazaMijloculVarfurilor(Parabola p1, Parabola p2) {
        // Coordonatele vârfurilor parabolelor
        double[] varfulP1 = p1.CalculeazaVarful();
        double[] varfulP2 = p2.CalculeazaVarful();

        // Calculează coordonatele mijlocului
        double mijlocX = (varfulP1[0] + varfulP2[0]) / 2;
        double mijlocY = (varfulP1[1] + varfulP2[1]) / 2;

        return new double[]{mijlocX, mijlocY};
    }

    public double lungimeSegmet(Parabola P)
    {
        //coordonatele varfurilor parabolei curente si a celei transmise

        double [] VarfulCurent = this.CalculeazaVarful();
        double [] VafulTransmis= P.CalculeazaVarful();

        //calculeaza lungimea segmentului utilizand metoda Math.hypot

        double lungime = Math.hypot(VafulTransmis[0] - VarfulCurent[0], VafulTransmis[1]-VarfulCurent[1]);


        return lungime;
    }

}




public class Main {
    public static void main(String[] args) {



        //creem un nou vector de obiecte de tip Parabola

         List<Parabola> ListaParabole = new ArrayList<Parabola>();

        try {
            File file = new File("in.txt"); // Numele fișierului din care citim
            Scanner scanner = new Scanner(file);

            // Parcurgem fiecare linie din fișier
            while (scanner.hasNextLine()) {
                // Citim numerele din linie
                int num1 = scanner.nextInt();
                int num2 = scanner.nextInt();
                int num3 = scanner.nextInt();

                // Afișăm numerele citite
                //System.out.println("Numere citite: " + num1 + ", " + num2 + ", " + num3);


                //adaugam in lista
                ListaParabole.add(new Parabola(num1, num2, num3));

                // Trecem la următoarea linie
                scanner.nextLine();
            }
            scanner.close(); //inchidem dupa terminarea citirii
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }

        for(Parabola parab:ListaParabole)
        {
            System.out.println(parab);
        }


        System.out.println();

        for(Parabola parab : ListaParabole)
        {
            double [] i=parab.CalculeazaVarful();
            System.out.println(Arrays.toString(i));
        }

        System.out.println();


        for(Parabola parab :ListaParabole)
        {
            double [] i =parab.CalculeazaMijlocul(new Parabola(1, 2, 3));
            System.out.println(Arrays.toString(i));
        }
        System.out.println();


        for (Parabola parab : ListaParabole) {
            double[] i = Parabola.CalculeazaMijloculVarfurilor(parab, new Parabola(1, 2, 3));
            System.out.println(Arrays.toString(i));
        }

        System.out.println();

        for(Parabola parab :ListaParabole)
        {
            double lungime = parab.lungimeSegmet(new Parabola( 1, 2,3 ));
            System.out.println("Lungimea segmentului este: "+ lungime);
        }


    }
}


