package org.example;
/**
 * Clasa PerecheNumere reprezintă o pereche de numere întregi.
 * Această clasă este utilizată pentru a reprezenta și manipula perechi de numere.
 */
public class PerecheNumere {

    private  int a;
    private  int b;
    //constructor cu parametri
    /**
     * Constructor cu parametri pentru inițializarea unei perechi de numere.
     *
     * @param a Primul număr din pereche
     * @param b Al doilea număr din pereche
     */
    public PerecheNumere(int a, int b)
    {
        this.a=a;
        this.b= b;

    }
    //constructor fara parametri

    /**
     * Constructor fără parametri pentru o pereche de numere.
     * Acesta inițializează perechea cu valorile implicite ale numerelor.
     */
   public PerecheNumere()
    {


    }
    /**
     * Returnează primul număr din pereche.
     *
     * @return Primul număr din pereche
     */
    public int getA() {
        return a;
    }
    /**
     * Returnează al doilea număr din pereche.
     *
     * @return Al doilea număr din pereche
     */
    public int getB() {
        return b;
    }
    /**
     * Setează primul număr din pereche.
     *
     * @param a Noul prim număr din pereche
     */
    public void setA(int a) {
        this.a = a;
    }
    /**
     * Setează al doilea număr din pereche.
     *
     * @param b Noul al doilea număr din pereche
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * Returnează o reprezentare sub formă de șir a perechii de numere.
     *
     * @return Reprezentarea sub formă de șir a perechii de numere
     */

    @Override
    public String toString() {
        return  a + " , " +  b;


    }

    /**
     * Verifică dacă două numere formează o pereche consecutivă în șirul Fibonacci.
     *
     * @param a Primul număr
     * @param b Al doilea număr
     * @return true dacă cele două numere sunt consecutive în șirul Fibonacci, false în caz contrar
     */
    public boolean areConsecutiveInFibonacci(int a, int b) {
        int fibPrev = 0;
        int fibCurr = 1;

        // Verificăm dacă a este mai mic decât b, altfel schimbăm valorile
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // Iterăm până când unul dintre numere depășește b
        while (fibCurr <= b) {
            // Verificăm dacă cele două numere formează o pereche
            if (fibCurr == a && fibCurr + fibPrev == b) {
                return true;
            }

            // Actualizăm numerele din șirul lui Fibonacci
            int temp = fibCurr;
            fibCurr += fibPrev;
            fibPrev = temp;
        }

        // Dacă nu am găsit perechea, returnăm false
        return false;
    }

    /**
     * Calculează cel mai mare divizor comun (CMD) al celor două numere.
     *
     * @return Cel mai mare divizor comun al celor două numere
     */
    public int calculateCMMD() {
        // Utilizăm algoritmul lui Euclid pentru a calcula cel mai mare divizor comun (CMD)
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);

        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        // Returnăm CMMD, care este stocat în num1
        return Math.abs(num1);
    }

    /**
     * Calculează cel mai mare divizor comun (CMD) al celor două numere.
     *
     * @return Cel mai mare divizor comun al celor două numere
     */
    public int SumaCifrelor(int numar)
    {

        int suma=0;

        while (numar>0)
        {
            suma=suma+numar%10;
            numar=numar/10;

        }
        return suma;
    }
    /**
     * Verifică dacă suma cifrelor a două numere este egală.
     *
     * @param nr1 Primul număr
     * @param nr2 Al doilea număr
     * @return true dacă suma cifrelor celor două numere este egală, false în caz contrar
     */
    public boolean SunmaEsteEgala(int nr1, int nr2)
    {
        return SumaCifrelor(nr1)==SumaCifrelor(nr2);

    }
    /**
     * Numără cifrele pare dintr-un număr dat.
     *
     * @param nr Numărul pentru care se numără cifrele pare
     * @return Numărul de cifre pare din numărul dat
     */

    public  int NrCifrePare(int nr)
    {
        int count=0;
        int cifra;

        while (nr>0)
        {
            cifra = nr%10;
            if(cifra%2==0)
            {
                count++;
            }
            nr = nr/10;


        }
        return count;
    }
    /**
     * Verifică dacă două numere au același număr de cifre pare.
     *
     * @param nr1 Primul număr
     * @param nr2 Al doilea număr
     * @return true dacă cele două numere au același număr de cifre pare, false în caz contrar
     */
    public  boolean NrCifreEgalePare(int nr1, int nr2)
    {
        return  NrCifrePare(nr1)==NrCifrePare(nr2);

    }


}
