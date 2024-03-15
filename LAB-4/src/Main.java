import java.awt.font.TextHitInfo;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clasa EchipamenteElectronice reprezintă o clasă de bază pentru toate echipamentele electronice.
 * Aceasta conține informații generale despre un echipament electronic, cum ar fi numele, numărul de inventar,
 * prețul, zona magazinului și starea.
 */
class EchipamenteElectronice
{
    protected String Denumire;

    protected int NrInventar;

    protected double Pret;

    protected String ZonaMagazin;

  protected Stare stare;

  protected TipDispozitiv tipDispozotiv;

    public int getNrInventar() {
        return NrInventar;
    }

    public void setStare(Stare stare) {
        this.stare=stare;
    }

    public Stare getStare() {
        return  stare;
    }

    public enum Stare   //enumerare pentru obiecte
    {
        ACHIZITIONAT,
        EXPUS,
        VANDUT


    }
    enum TipDispozitiv //enumerare pentru tipul de obiect
    {
        IMPRIMANTA,
        COPIATOR,
        SISTEMDECALCUL
    }


    public EchipamenteElectronice(String Denumire, int NrInventar, double Pret, String ZonaMagazin,EchipamenteElectronice.Stare stare, EchipamenteElectronice.TipDispozitiv tipDispozotiv)


    {

            this.Denumire=Denumire;
            this.NrInventar=NrInventar;
            this.Pret=Pret;
            this.ZonaMagazin=ZonaMagazin;
            this.stare=stare;

            this.tipDispozotiv=tipDispozotiv;


    }
    public  EchipamenteElectronice()
    {

    }
    public String toString() {
        return "Nume Produs: " + Denumire + ", NrInventar: " + NrInventar + ", Pret: " + Pret + ", ZonaMagazin: " + ZonaMagazin + ", Stare: " + stare + ", TipDispozotiv: " + tipDispozotiv;
    }



}


/**
 * Clasa Imprimante extinde clasa EchipamenteElectronice și adaugă informații specifice despre imprimante.
 * Aceasta conține detalii precum numărul de pagini scrise pe minut, rezoluția și modul de tipărire.
 */
class Imprimante extends EchipamenteElectronice implements Serializable
{
    private  int NrPaginiScrisePeMinut;
    private String Rezolutie;
    private String NrPgPerCartus;

    protected ModTiparire modTiparire;

    public void setmodTiparire(ModTiparire modTiparire) {
        this.modTiparire=modTiparire;
    }

    enum ModTiparire
    {
        COLOR,
        ALBNEGRU


    }


    public Imprimante(String Denumire, int NrInventar, double Pret, String ZonaMagazin,  EchipamenteElectronice.Stare stare, EchipamenteElectronice.TipDispozitiv tipDispozitiv, int NrPaginiScrisePeMinut, String Rezolutie, String NrPgPerCartus, Imprimante.ModTiparire modTiparire) {
        super(Denumire, NrInventar, Pret, ZonaMagazin, stare, tipDispozitiv);
        this.NrPaginiScrisePeMinut=NrPaginiScrisePeMinut;
        this.NrPgPerCartus=NrPgPerCartus;
        this.Rezolutie=Rezolutie;
        this.modTiparire=modTiparire;

    }
    public  Imprimante()
    {

    }
    public  String toString() {


        return  "Nume Produs: " + Denumire +  ","  + " NrInventar: " + NrInventar  + "," + " Pret: " + Pret + " ZonaMagazin: " + ZonaMagazin + "," + " Stare:" + stare + ", " +  " TipDispozotiv:" + tipDispozotiv + "," + " NrPaginiScrisePeMinut: " + NrPaginiScrisePeMinut + "," +" Rezolutie " + Rezolutie + ","+ " NrPgPerCartus: " + NrPgPerCartus + "," + " ModTiparire: " + modTiparire;

    }
}
/**
 * Clasa Copiator extinde clasa EchipamenteElectronice și adaugă informații specifice despre copiatoare.
 * Aceasta conține detalii precum numărul de pagini și formatul de copiere.
 */
class Copiator extends EchipamenteElectronice implements Serializable
{
    private int NumaruldePagini;
    protected  FormatdeCopiere formatdeCopiere;

    public Copiator(String Denumire, int NrInventar, double Pret, String ZonaMagazin, EchipamenteElectronice.Stare stare, EchipamenteElectronice.TipDispozitiv tipDispozitiv,  int NumaruldePagini,  Copiator.FormatdeCopiere formatdeCopiere)
    {
        super(Denumire, NrInventar, Pret, ZonaMagazin, stare, tipDispozitiv);
        this.NumaruldePagini=NumaruldePagini;
        this.formatdeCopiere= formatdeCopiere;

    }
    public Copiator()
    {

    }

    public void setFormatCopiere(FormatdeCopiere formatdeCopiere) {
        this.formatdeCopiere=formatdeCopiere;
    }

    enum FormatdeCopiere
    {
        A3,
        A4
    }
    public  String toString() {


        return  "Nume Produs: " + Denumire +  ","  + " NrInventar: " + NrInventar  + "," + " Pret: " + Pret + " ZonaMagazin: " + ZonaMagazin + "," + " Stare:" + stare + ", " +  " TipDispozotiv:" + tipDispozotiv + "," + " NumaruldePagini: " + NumaruldePagini + "," + " Format de Copiere: " + formatdeCopiere;

    }

}
/**
 * Clasa SistemedeCalcul extinde clasa EchipamenteElectronice și adaugă informații specifice despre sistemele de calcul.
 * Aceasta conține detalii precum tipul de monitor, viteza procesorului și sistemul de operare.
 */
class SistemedeCalcul extends EchipamenteElectronice implements Serializable {
    private String TipMonitor;
    private double VitezaProcesor;

    private int CapacitateHDD;
    protected  SistemdeOperare sistemdeOperare;

    public SistemedeCalcul(String Denumire, int NrInventar, double Pret,String ZonaMagazin, EchipamenteElectronice.Stare stare, EchipamenteElectronice.TipDispozitiv tipDispozitiv, String TipMonitor, double VitezaProcesor, int CapacitateHDD,SistemedeCalcul.SistemdeOperare sistemdeOperare) {
        super(Denumire, NrInventar, Pret, ZonaMagazin, stare, tipDispozitiv);
        this.TipMonitor=TipMonitor;
        this.VitezaProcesor=VitezaProcesor;
        this.CapacitateHDD= CapacitateHDD;
        this.sistemdeOperare=sistemdeOperare;

    }
    public  SistemedeCalcul()
    {

    }

    public void setSistemOS(SistemdeOperare sistemdeOperare) {
        this.sistemdeOperare=sistemdeOperare;
    }

    enum SistemdeOperare
    {
        WINDOWS,
        LINUX

    }
    public  String toString() {


        return  "Nume Produs: " + Denumire +  ","  + " NrInventar: " + NrInventar  + "," + " Pret: " + Pret + " ZonaMagazin: " + ZonaMagazin + "," + " Stare:" + stare + ", " +  " TipDispozotiv:" + tipDispozotiv+ ","+ " TipMonitor " + TipMonitor + "," + " VitezaProcesor: " + VitezaProcesor + "," +" CapacitateHDD:" + CapacitateHDD + "," + " Sistem de Operare:" + sistemdeOperare;

    }


}
/*Să se creeze O SINGURĂ COLECȚIE DE OBIECTE DE TIP LIST în care să fie
preluate datele din fişierul de intrare electronice.txt. Se va dezvolta un meniu care va oferi
următoarele facilităţi:*/

/*electronice.txt*/
/*HP Deskjet 1000;1234;170;A;achizitionat;imprimanta;12;600 x 600 dpi;1000;Color
HP Officejet 7000 Wide;1235;1200;B;vandut;imprimanta;33;4800x1200 dpi;2000;color
Konica Minolta bizhub C200;1236;17000;B;expus;copiator;2000;A3
Konica Minolta bizhub 163;1237;500;C;vandut;copiator;1500;A4
HUSK Office tech Celeron Dual Core E3400;1238;950;A;expus;sistem de calcul;belinea;2.4;500;windows
HUSK Office tech Celeron Dual Core G530;1239;1000;B;vandut;sistem de calcul;dell;2.6;700;linux*/
/**
 * Clasa Main este clasa principală care conține metoda main() pentru pornirea aplicației.
 * Aici sunt realizate citirea datelor din fișier, gestionarea meniului și interacțiunea cu utilizatorul.
 */
public class Main {

    /**
     * Metoda main() este punctul de intrare în aplicație.
     * Aici sunt create listele de echipamente electronice, se realizează citirea datelor din fișier
     * și se afișează meniul pentru utilizator.
     * @param args Argumente de linie de comandă (nu sunt utilizate în acest caz)
     */
    public static void main(String[] args) {

        List<EchipamenteElectronice> ListaEchipamente = new ArrayList<>();

        File file = new File("C:\\Users\\cucic\\Desktop\\PJ\\LAB-4\\electronice.txt");

        try (Scanner scanner1 = new Scanner(file)) {
            while (scanner1.hasNextLine()) {
                String LinieCitita = scanner1.nextLine();
                String[] Informati = LinieCitita.split(";");

                EchipamenteElectronice.Stare stare = EchipamenteElectronice.Stare.valueOf(Informati[4].toUpperCase());
                EchipamenteElectronice.TipDispozitiv tipDispozitiv = EchipamenteElectronice.TipDispozitiv.valueOf(Informati[5].toUpperCase());

                switch (tipDispozitiv) {
                    case IMPRIMANTA:
                        Imprimante.ModTiparire modTiparire = Imprimante.ModTiparire.valueOf(Informati[9].toUpperCase());
                        Imprimante imprimanta = new Imprimante(Informati[0], Integer.parseInt(Informati[1]), Double.parseDouble(Informati[2]),

                                Informati[3], stare, tipDispozitiv, Integer.parseInt(Informati[6]), Informati[7], Informati[8], modTiparire);

                        ListaEchipamente.add(imprimanta);
                        break;
                    case COPIATOR:
                        Copiator.FormatdeCopiere formatdeCopiere = Copiator.FormatdeCopiere.valueOf(Informati[7].toUpperCase());
                        Copiator copiator = new Copiator(Informati[0], Integer.parseInt(Informati[1]), Double.parseDouble(Informati[2]),
                                Informati[3], stare, tipDispozitiv, Integer.parseInt(Informati[6]), formatdeCopiere);
                        ListaEchipamente.add(copiator);
                        break;
                    case SISTEMDECALCUL:
                        SistemedeCalcul.SistemdeOperare sistemdeOperare = SistemedeCalcul.SistemdeOperare.valueOf(Informati[9].toUpperCase());
                        SistemedeCalcul sistemCalcul = new SistemedeCalcul(Informati[0], Integer.parseInt(Informati[1]), Double.parseDouble(Informati[2]),
                                Informati[3], stare, tipDispozitiv, Informati[6], Double.parseDouble(Informati[7]), Integer.parseInt(Informati[8]), sistemdeOperare);
                        ListaEchipamente.add(sistemCalcul);
                        break;
                    default:
                        System.out.println("Tip de echipament necunoscut: " + Informati[5]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fișierul nu a fost găsit: " + e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        int optiunea;

        do {
            System.out.print("1.Afisare echipamente\n");
            System.out.print("2.Afisare imprimante\n");
            System.out.print("3.Afisare copiatoare\n");
            System.out.print("4.Afisare sisteme de calcul.\n");
            System.out.print("5.Modificarea stării în care se află un echipament\n");
            System.out.print("6.Setarea unui anumit mod de scriere pentru o imprimantă.\n");
            System.out.print("7.Setarea unui format de copiere pentru copiatoare \n");
            System.out.print("8.Instalarea unui anumit sistem de operare pe un sistem de calcul.\n");
            System.out.print("9.Afişarea echipamentelor vândute.\n");
            System.out.print("10.Să se realizeze două metode statice pentru serializarea / deserializarea colecției de obiecte în fișierul echip.bin\n");

            System.out.println();

            System.out.print("Introduceti optiunea:");
            optiunea = scanner.nextInt();

            System.out.println();

            switch (optiunea) {
                case 1:
                    for (EchipamenteElectronice echip : ListaEchipamente) {
                        System.out.println(echip);
                    }
                    break;
                case 2:
                    // implementare pentru afișarea imprimantelor
                     for( EchipamenteElectronice echip :ListaEchipamente)
                     {
                         if(echip instanceof Imprimante)
                         {
                             System.out.println(echip);
                         }
                     }
                    break;
                case 3:
                    // implementare pentru afișarea copiatoarelor
                    for(EchipamenteElectronice echip :ListaEchipamente)
                    {
                        if(echip instanceof Copiator) {
                            System.out.println(echip);
                        }
                    }
                    break;
                case 4:
                    // implementare pentru afișarea sistemelor de calcul
                    for (EchipamenteElectronice echip :ListaEchipamente)
                    {
                        if(echip instanceof  SistemedeCalcul)
                        {
                            System.out.println(echip);
                        }
                    }
                    break;
                case 5:
                    // implementare pentru modificarea stării unui echipament
                    ModificareStareEchipament(ListaEchipamente);
                    break;
                case 6:

                    // implementare pentru setarea modului de scriere pentru o imprimantă
                        ModificareStareEchipamentIMPRIMANTA(ListaEchipamente);
                    break;

                case 7:
                    // implementare pentru setarea formatului de copiere pentru copiatoare
                    ModificareStareEchipamentCopiator(ListaEchipamente);
                    break;
                case 8:
                    // implementare pentru instalarea unui sistem de operare pe un sistem de calcul
                    ModificareStareEchipamentSistemDeCalcul(ListaEchipamente);
                    break;
                case 9:
                    // implementare pentru afișarea echipamentelor vândute
                    AfisareVandute(ListaEchipamente);
                    break;
                case 10:
                    // Implementare pentru serializarea / deserializarea colecției de obiecte
                    System.out.println("Serializare sau deserializare? (s/d): ");
                    String optiuneSD = scanner.next();
                    switch (optiuneSD) {
                        case "s":
                            // Serializare
                            serializare(ListaEchipamente, "echip.bin");
                            break;
                        case "d":
                            // Deserializare
                            ListaEchipamente = deserializare("echip.bin");
                            break;
                        default:
                            System.out.println("Opțiune incorectă!");
                    }
                    break;
            }
        } while (optiunea != 0);
        scanner.close();
    }


    /**
     * Metoda ModificareStareEchipament permite utilizatorului să modifice starea unui echipament
     * în funcție de numărul său de inventar.
     * @param echipamenteElectroniceList Lista de echipamente electronice în care se caută echipamentul.
     */
    public  static  void ModificareStareEchipament(List<EchipamenteElectronice> echipamenteElectroniceList)
    {
         Scanner scanner2 = new Scanner(System.in);
         System.out.print("Introduceti NrInventar al echipamentului: ");
         int nrInventar;
         nrInventar = scanner2.nextInt();

         System.out.print("Introduceti noua stare(achizitionat/expus/vandut):");
         String stare;
         stare = scanner2.next();


         for (EchipamenteElectronice echip : echipamenteElectroniceList) {
             if (echip.getNrInventar() == nrInventar) {
                 echip.setStare(EchipamenteElectronice.Stare.valueOf(stare.toUpperCase()));
             }


         }
        System.out.println("Starea a fost actualizata cu succes!");
         System.out.println();
    }
    /**
     * Metoda ModificareStareEchipamentIMPRIMANTA permite utilizatorului să seteze modul de tipărire
     * pentru o imprimantă specifică, identificată prin numărul său de inventar.
     * @param electroniceList Lista de echipamente electronice în care se caută imprimanta.
     */
    public  static  void ModificareStareEchipamentIMPRIMANTA(List<EchipamenteElectronice> electroniceList)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti NrInventar al echipamentului: ");
        int nrInv = scanner.nextInt();

        System.out.print("Introduceți noul mod de tipărire (color/albnegru): ");
        String modTiparire = scanner.next();

        for (EchipamenteElectronice echip :electroniceList)
        {
            if( echip instanceof Imprimante && echip.getNrInventar()==nrInv)
            {
                ((Imprimante)echip).setmodTiparire(Imprimante.ModTiparire.valueOf(modTiparire.toUpperCase()));
                System.out.println("Modul de Tiparire a fost actualizat!");

            }
            else
                System.out.println("Imprimanta cu numărul de inventar " + nrInv + " nu a fost găsită.");
        }




    }
    /**
     * Metoda ModificareStareEchipamentCopiator permite utilizatorului să seteze formatul de copiere
     * pentru un copiator specific, identificat prin numărul său de inventar.
     * @param electroniceList Lista de echipamente electronice în care se caută copiatorul.
     */
    public  static  void ModificareStareEchipamentCopiator(List<EchipamenteElectronice> electroniceList)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti NrInventar al echipamentului: ");
        int nrInv = scanner.nextInt();

        System.out.print("Introduceți noul mod de copiere (A3/A4): ");
        String modCopiere = scanner.next();
        for (EchipamenteElectronice echip :electroniceList)
        {
            if( echip instanceof Copiator && echip.getNrInventar()==nrInv)
            {
                ((Copiator)echip).setFormatCopiere(Copiator.FormatdeCopiere.valueOf(modCopiere.toUpperCase()));
                System.out.println("Formatul de copiere  a fost actualizat!");

            }
            else
                System.out.println("Copiatorul  cu numărul de inventar " + nrInv + " nu a fost găsit.");
        }


    }
    /**
     * Metoda ModificareStareEchipamentSistemDeCalcul permite utilizatorului să instaleze un sistem
     * de operare pe un sistem de calcul specific, identificat prin numărul său de inventar.
     * @param electroniceList Lista de echipamente electronice în care se caută sistemul de calcul.
     */
    public  static  void ModificareStareEchipamentSistemDeCalcul(List<EchipamenteElectronice> electroniceList)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti NrInventar al echipamentului: ");
        int nrInv = scanner.nextInt();

        System.out.print("Introduceți noul sistem de Operare (windows/linux): ");
        String SistemOS = scanner.next();
        for (EchipamenteElectronice echip :electroniceList)
        {
            if( echip instanceof SistemedeCalcul && echip.getNrInventar()==nrInv)
            {
                ((SistemedeCalcul)echip).setSistemOS(SistemedeCalcul.SistemdeOperare.valueOf(SistemOS.toUpperCase()));
                System.out.println("Sistemul de Operare(OS)  a fost actualizat!");

            }
            else
                System.out.println("Sistemul de calcul   cu numărul de inventar " + nrInv + " nu a fost găsit.");
        }


    }
    /**
     * Metoda AfisareVandute afișează toate echipamentele electronice care au fost vândute.
     * @param electroniceList Lista de echipamente electronice care va fi verificată pentru echipamentele vândute.
     */
    public  static  void AfisareVandute(List<EchipamenteElectronice> electroniceList)
    {

        for (EchipamenteElectronice echip :electroniceList)
        {
            if(echip.getStare() == EchipamenteElectronice.Stare.VANDUT)
            {
                System.out.println(echip);
            }
        }
    }



    /**
     * Metoda serializare serializează lista de echipamente electronice într-un fișier specificat.
     * @param electroniceList Lista de echipamente electronice care urmează să fie serializate.
     * @param numeFisier Numele fișierului în care se va face serializarea.
     */
    // Metoda pentru serializarea colecției de obiecte în fișier
    public static void serializare(List<EchipamenteElectronice> electroniceList, String numeFisier) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(numeFisier))) {
            out.writeObject(electroniceList);
            System.out.println("Serializare finalizată.");
        } catch (IOException e) {
            System.out.println("Eroare la serializare: " + e.getMessage());
        }
    }
    /**
     * Metoda deserializare deserializază lista de echipamente electronice dintr-un fișier specificat.
     * @param numeFisier Numele fișierului din care se va face deserializarea.
     * @return Lista de echipamente electronice deserializată.
     */
    // Metoda pentru deserializarea colecției de obiecte din fișier
    public static List<EchipamenteElectronice> deserializare(String numeFisier) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(numeFisier))) {
            List<EchipamenteElectronice> electroniceList = (List<EchipamenteElectronice>) in.readObject();
            System.out.println("Deserializare finalizată.");
            return electroniceList;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Eroare la deserializare: " + e.getMessage());
            return null;
        }
    }

}

