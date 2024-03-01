/*4. Să se realizeze un program care citește numele si CNP-ul pe care îl au n persoane.
Valoarea lui n se citește de la tastatură. Programul va afișa informațiile introduse și în plus
pentru fiecare persoana va afișa vârsta. Cât timp un CNP-ul este introdus greșit programul va
cere reintroducerea acestuia. Pentru simplitate se consideră că CNP-ul este valid dacă
îndeplinește următoarele condiții:
• Are 13 caractere
• Toate caracterele sunt cifre
• Prima cifră are una din valorile 1, 2, 5, 6
• Cifra de control a CNP-ului are o valoare validă.
Detalii legate de semnificația cifrelor din codul numeric personal şi de modul de calcul al
cifrei de control se găsesc pe link-ul:
https://www.scientia.ro/stiinta-la-minut/128-cultura-economie/459-cnp-codulnumeric-personal.html
Se va crea clasa Persoana cu variabile membre private nume (String) şi cnp (String).
Clasa va avea constructor cu parametri, gettere si settere în funcție de necesități şi metoda
getVarsta() care va calcula şi va returna vârsta persoanei extrăgând data nașterii din CNP şi
citind din sistem data curentă. Se va utiliza clasa LocalDate. Se va crea un vector în care se
vor adăuga obiectele de tip Persoana. Fiecare element din vectorul va fi afișat pe un rând în
formatul nume, CNP, varsta.*/


import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

class Persoana
{
    private String Nume;
    private  String CNP;

    private int Varsta;

    public Persoana(String Nume, String CNP) //constructorul clasei Persoana
    {
        this.CNP=CNP;
        Varsta=getVarsta();
        this.Nume=Nume;

    }

    public int getVarsta() {
        // Extragerea datelor de naștere din CNP
        String an = CNP.substring(1, 3);
        String luna = CNP.substring(3, 5);
        String ziua = CNP.substring(5, 7);

        // Convertirea datelor de naștere la numere întregi
        int anNastere = Integer.parseInt(an);
        int lunaNastere = Integer.parseInt(luna);
        int ziuaNastere = Integer.parseInt(ziua);

        // Determinarea secolului pentru data de naștere
        int secol;
        if (anNastere >= 0 && anNastere <= 21) {
            secol = 2000;
        } else {
            secol = 1900;
        }

        // Determinarea datei de naștere
        LocalDate dataNasterii = LocalDate.of(secol + anNastere, lunaNastere, ziuaNastere);

        // Determinarea datei curente
        LocalDate dataCurenta = LocalDate.now();

        // Calcularea vârstei
        int varsta = Period.between(dataNasterii, dataCurenta).getYears();

        return varsta;
    }


    public void AfisareDetaliPersoana()
    {
        System.out.println("Nume-> "+ Nume + " CNP-> " + CNP  + " Varsta->" + Varsta);

    }


    public void GetDetails()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduceti numele Persoanei: ");
        Nume = scanner.next();

        System.out.print("Introduceti CNP-UL: ");
        CNP= scanner.next();




    }





}


public class exercitiul4main {
    public static void main(String[] args) {


        int nrPersoane;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti numarul de Persoane pe care doriti sa le adaugati: ");
        nrPersoane = scanner.nextInt();




        //creem un vector de obiecte de tip Persoana
        ArrayList<Persoana> VectorPersoana = new ArrayList<>();
        String CNP;
        for(int i=0;i<nrPersoane;i++)
        {
            System.out.print( i+ "." + "Introduceti numele Persoanei: ");
            String Nume = scanner.next();
               boolean esteValid;
            do {


                System.out.print(i + "." + "Introduceti CNP-ul: ");
                CNP = scanner.next();

                esteValid = validateCNP(CNP);





            }while(!esteValid);






            VectorPersoana.add(new Persoana(Nume, CNP)); //Adaugam in vector





        }

       //adaugam manual ca sa testam programul
        /*VectorPersoana.add(new Persoana("Cucicea", "1234567891123"));
*/
        //afisam detaliile salvate in vectorul creeat
        for(Persoana pers:VectorPersoana)
        {
            pers.AfisareDetaliPersoana();


        }



    }

    private static boolean validateCNP(String CNP) {
        // Verificăm dacă CNP-ul are 13 caractere
        if (CNP.length() != 13) {
            return false;
        }

        // Verificăm dacă toate caracterele sunt cifre
        if (!CNP.matches("\\d+")) {
            return false;
        }

        // Verificăm dacă prima cifră are una din valorile 1, 2, 5, 6
        char primaCifra = CNP.charAt(0);
        if (primaCifra != '1' && primaCifra != '2' && primaCifra != '5' && primaCifra != '6') {
            return false;
        }

        // Verificăm cifra de control a CNP-ului
        int[] coeficienti = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int suma = 0;
        for (int i = 0; i < 12; i++) {
            suma += Character.getNumericValue(CNP.charAt(i)) * coeficienti[i];
        }
        int cifraControlCalculata = suma % 11;
        int cifraControlData = Character.getNumericValue(CNP.charAt(12));
        if (cifraControlCalculata != cifraControlData && cifraControlCalculata != 10) {
            return false;
        }

        return true;

    }
}
