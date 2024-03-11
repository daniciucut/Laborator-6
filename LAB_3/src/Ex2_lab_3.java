
/*2. Să se scrie un program care citește din fișierul produse.csv informații referitoare la
produsele dintr-un magazin. Pe fiecare linie se află: denumirea produsului, preţul (număr real)
cantitatea (număr întreg), data expirării (LocalDate). Cele patru elemente sunt separate prin
caracterul "," (zahar, 1.5, 50, 2024-02-25). Pentru fiecare rând citit se va crea un obiect de tip
Produs care se va adăuga unei colecții de obiecte de tip List. Se va defini o clasă Produs care
va conține: variabile membre private corespunzătoare celor trei elemente care descriu un produs,
cel puţin un constructor, gettere si settere în funcție de necesități şi redefinirea metodei toString()
din clasa Object, metodă care va fi utilizată pentru afișarea produselor.
Să se realizeze un program care va dispune de un meniu și va implementa următoarele
cerințe:
a) afișarea tuturor produselor din colecția List
b) afișarea produselor expirate
c) vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.
Daca produsul ajunge la cantitate zero, se elimina din listă. În clasa Produs se va declara
o variabilă statica încasări care se va actualiza la fiecare vânzare a unui produs, luând în
considerare prețul produsului vândut şi cantitatea vândută .
d) afișarea produselor cu prețul minim (pot fi mai multe cu același preț)
e) salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură
într-un fișier de ieșire.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Produs //clasa Produs
{
    private String Nume;
    private double Pret;

    private int Cantitate;

    private LocalDate Data;


   private static  double Incasari = 0; //fiecare obiect (produs) va putea fi vandut

    public Produs(String Nume, double Pret, int Cantitate, LocalDate Data)
    {
        this.Nume=Nume;
        this.Pret=Pret;
        this.Cantitate=Cantitate;
        this.Data=Data;

    }
 @Override
    public  String toString() {


        return  "Nume Produs: " + Nume +" Pret: " + Pret + " Cantitate: " + Cantitate + " Date de Expirare: " + Data + " Incasari: " + Incasari ;

    }


    public LocalDate getDataExpirare() {
        LocalDate Date = Data;
        return Date;
    }

    public String getNume() {
        return Nume;

    }

    public void afisareProdusMinim()
    {

    }



public void vanzareProdus( int cantitateVanduta,  List P)
  {
      double PretVanzare =Pret;
     if(Cantitate>=cantitateVanduta)
     {
         Incasari+= cantitateVanduta* PretVanzare;

         Cantitate-=cantitateVanduta;

         //DACA CANTITATEA DEVINE 0 ELIMINAN PRODUSUL DIN LISTA
         if(Cantitate==0)
         {
             P.remove(this); //eliminam produsul

         }else if(Cantitate< cantitateVanduta) {
             System.out.println("Nu exista suficienta cantitate!");
         }

     }
  }

    public double getPret() {
        return Pret;
    }

    public int getCantitate() {
        return Cantitate;
    }
}
public class Ex2_lab_3 {
    public static void main(String[] args) {

          //lista noua de obiecte de tip Produse
         List<Produs> ListaProduse = new ArrayList<Produs>();



        try {

            File file = new File("C:\\Users\\cucic\\Desktop\\PJ\\LAB_3\\src\\produse.csv"); // Numele fișierului din care citim
            Scanner scanner = new Scanner(file);


            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(", ");

                // Verificăm dacă linia are toate elementele așteptate
                if (parts.length == 4) {
                    String nume = parts[0];
                    double Pret = Double.parseDouble(parts[1]);
                    int Cantitate = Integer.parseInt(parts[2]);
                    LocalDate data = LocalDate.parse(parts[3]);

                    ListaProduse.add(new Produs(nume, Pret, Cantitate, data));//adaugam in lista noastra





                } else {
                    System.out.println("Linie invalidă: " + line);
                }
            }

            scanner.close();



        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }

        String optiunea = null;
        Scanner scanner = new Scanner(System.in);

        do {


            System.out.print("a. Afisare.\n");
            System.out.print("b.Produse expirate.\n");
            System.out.print("c.Vanzare.\n");
            System.out.print("d.Minim Pret.\n");
            System.out.print("e.Salvare Fisier.\n");
            System.out.print("0.Iesire.\n");

          System.out.print("Introduceti optiunea dorita de dvs:");
          optiunea = scanner.next();

          switch (optiunea)
          {
              case "a":
              {
                 //afisare

                  for(Produs prod:ListaProduse)
                  {
                      System.out.println(prod);

                  }
              }
              break;
              case "b": {

                  // Obținem data curenta
                  LocalDate dataCurenta = LocalDate.now();
                  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                  // Iteram prin fiecare produs din lista
                  for (Produs produs : ListaProduse) {
                      LocalDate dataExpirare = produs.getDataExpirare();

                      // Verificam daca  data de expirare a produsului este înainte de data curenta
                      if (dataExpirare != null && dataExpirare.isBefore(dataCurenta)) {
                          // Produsul este expirat, deci îl putem afișa
                          System.out.println("Produs expirat: " + produs.getNume() + " - Data expirare: " + dataExpirare.format(formatter));
                      }
                  }

              }
              break;
              case "c":
              {
                 int Cantitate;
                 double Pret;
                 System.out.print("Introduceti cantitatea pe care doriti s-o vindeti:");
                 Scanner scanner1 = new Scanner(System.in);
                 Cantitate =scanner1.nextInt();


                 for (Produs produs:ListaProduse)
                 {
                     produs.vanzareProdus(Cantitate,ListaProduse);
                 }







              }
              break;
              case "d":
              {
                  // Căutăm prețul minim
                  double pretMinim = Double.MAX_VALUE; // Inițializăm cu o valoare mare
                  List<Produs> produseCuPretMinim = new ArrayList<>();

                  for (Produs produs : ListaProduse) {
                      double pretProdus = produs.getPret();

                      // Dacă găsim un preț mai mic decât prețul minim actual, actualizăm prețul minim și resetați lista de produse cu prețul minim
                      if (pretProdus < pretMinim) {
                          pretMinim = pretProdus;
                          produseCuPretMinim.clear();
                          produseCuPretMinim.add(produs);
                      } else if (pretProdus == pretMinim) {
                          // Dacă găsim un alt produs cu același preț minim, adăugăm și acest produs în lista de produse cu prețul minim
                          produseCuPretMinim.add(produs);
                      }
                  }

                  // Afișăm produsele cu prețul minim
                  if (!produseCuPretMinim.isEmpty()) {
                      System.out.println("Produsele cu prețul minim:");
                      for (Produs produs : produseCuPretMinim) {
                          System.out.println(produs);
                      }
                  } else {
                      System.out.println("Nu există produse în listă.");
                  }
              }

              break;
              case "e": {
                  // Citim valoarea pragului de la tastatură
                  Scanner scanner2 = new Scanner(System.in);
                  System.out.print("Introduceți valoarea pragului pentru cantitate: ");
                  int pragCantitate = scanner2.nextInt();

                  // Inițializăm o listă pentru produsele care îndeplinesc condiția
                  List<Produs> produseCuCantitateSubPrag = new ArrayList<>();

                  // Iterăm prin fiecare produs din listă
                  for (Produs produs : ListaProduse) {
                      if (produs.getCantitate() < pragCantitate) {
                          // Dacă cantitatea produsului este mai mică decât pragul, adăugăm produsul în lista produselor cu cantitate sub prag
                          produseCuCantitateSubPrag.add(produs);
                      }
                  }

                  // Scriem lista de produse cu cantitate sub prag într-un fișier de ieșire
                  try (FileWriter writer = new FileWriter("C:\\Users\\cucic\\Desktop\\PJ\\LAB_3\\src\\produse_sub_prag.txt")) {
                      for (Produs produs : produseCuCantitateSubPrag) {
                          writer.write(produs.toString() + "\n");
                      }
                      System.out.println("Produsele cu cantitate sub prag au fost salvate în fișierul produse_sub_prag.txt.");
                  } catch ( IOException e) {
                      System.out.println("Eroare la scrierea în fișier: " + e.getMessage());
                  }


              }
              break;


          }

        }while(!optiunea.equals("0"));
        scanner.close();



    }
}
