import org.example.PerecheNumere;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPerecheNumere {


    //TESTE Pentru Metoda Fibonacii
    @Test
    void test1_fibonacci() {
        // Cream o pereche de numere consecutive în șirul Fibonacci
        PerecheNumere perecheNumere = new PerecheNumere(89, 144);

        // Verificăm dacă numerele sunt consecutive în șirul Fibonacci
        assertTrue(perecheNumere.areConsecutiveInFibonacci(89, 144));
    }
    @Test
    void tes2_fibonacii()
    {
        // Perechea de numere care nu sunt consecutive în șirul Fibonacci
        PerecheNumere perecheNeconsecutiva = new PerecheNumere(55, 90);
        assertFalse(perecheNeconsecutiva.areConsecutiveInFibonacci(55, 90));

    }
   @Test
    void tes3_fibonacii()
    {
        // Perechea de numere cu un număr negativ
        PerecheNumere perecheCuNegativ = new PerecheNumere(-21, 13);
        assertFalse(perecheCuNegativ.areConsecutiveInFibonacci(-21, 13));
    }

    //Teste pentru CMMDC

    @Test

    void test1_CMMDC()
    {
        // Perechea de numere cu un număr negativ
        PerecheNumere perecheCuNegativ = new PerecheNumere(-20, 30);
        assertEquals(10, perecheCuNegativ.calculateCMMD());


    }

    @Test
    void tes2_CMMDC()
    {
        // Perechea de numere cu ambele numere negative
        PerecheNumere perecheCuNegativAmbele = new PerecheNumere(-45, -75);
        assertEquals(15, perecheCuNegativAmbele.calculateCMMD());

    }

    @Test
    void test3_CMMDC()
    {
        // Perechea de numere pozitive
        PerecheNumere perechePozitiva = new PerecheNumere(24, 36);
        assertEquals(12, perechePozitiva.calculateCMMD());

    }

    @Test
    void test4_CMMMDC()
    {
        // Perechea de numere cu primul număr zero
        PerecheNumere perechePrimulZero = new PerecheNumere(0, 55);
        assertEquals(55, perechePrimulZero.calculateCMMD());
    }

    @Test
    void test5_CMMDC()
    {
        // Perechea de numere cu ambele numere zero
        PerecheNumere perecheAmbeleZero = new PerecheNumere(0, 0);
        assertEquals(0, perecheAmbeleZero.calculateCMMD());
    }

@Test
    void tes1SumaEgala()
{
    // Testăm când sumele cifrelor sunt egale
    PerecheNumere perecheNumere = new PerecheNumere(123, 321);
    assertTrue(perecheNumere.SunmaEsteEgala(123, 321));



}
@Test
    void test2_SumaEgala()
{
    // Testăm când sumele cifrelor sunt diferite
    PerecheNumere perecheNumere = new PerecheNumere(123, 456);
    assertFalse(perecheNumere.SunmaEsteEgala(123, 456));
}
@Test
    void test3_SumaEgala()
{
    // Perechea de numere cu un număr negativ
    PerecheNumere perecheCuNegativ = new PerecheNumere(-123, 123);
    assertFalse(perecheCuNegativ.SunmaEsteEgala(-123, 123));
}

//testarea nr de cifre Pare

    @Test
    void test1_Pare()
    {
        // Testăm când ambele numere au același număr de cifre pare
        assertTrue(new PerecheNumere().NrCifreEgalePare(2468, 8642));
    }
    @Test
    void test2_Pare()
    {
        // Testăm când ambele numere au un număr diferit de cifre pare
        assertFalse(new PerecheNumere().NrCifreEgalePare(2468, 13579));
    }

    @Test
    void test3_Pare()
    {
        // Testăm când unul dintre numere este negativ
        assertFalse(new PerecheNumere().NrCifreEgalePare(-2468, 8642));
    }


}
