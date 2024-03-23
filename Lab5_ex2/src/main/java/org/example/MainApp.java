package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Clasa MainApp este clasa principală a aplicației.
 * Aici este definită metoda main și alte metode auxiliare.
 */
public class MainApp {


    /**
     * Metoda scriere este folosită pentru a scrie o listă de perechi de numere într-un fișier JSON.
     *
     * @param lista Lista de perechi de numere care trebuie scrisă în fișier
     */
    public  static void scriere(List <PerecheNumere> lista)
    {
        try {
            ObjectMapper mapper=new ObjectMapper();
            File file=new File("src/main/resources/PerecheNumere.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda citire este folosită pentru a citi o listă de perechi de numere dintr-un fișier JSON.
     *
     * @return Lista de perechi de numere citite din fișier
     */
    public static List<PerecheNumere> citire() {
        try {
            File file=new File("src/main/resources/PerecheNumere.json");
            ObjectMapper mapper=new ObjectMapper();
            List<PerecheNumere> perechenumere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>(){});
            return perechenumere;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metoda main este metoda de intrare în aplicație.
     * Aici se inițializează lista de perechi de numere, se efectuează operațiile pe acestea și se afișează rezultatele.
     *
     * @param args Argumentele liniei de comandă (nu sunt utilizate în acest proiect)
     */
    public static void main(String[] args) {

        List<PerecheNumere> perechenumerec = citire();
        System.out.println(perechenumerec);

        for (PerecheNumere pereche :perechenumerec)
        {
            System.out.println(pereche);
            pereche.areConsecutiveInFibonacci(pereche.getA(), pereche.getB());
            pereche.calculateCMMD();
            if(pereche.SumaCifrelor(pereche.getA()) == pereche.SumaCifrelor(pereche.getB()))
            {
                System.out.print("Suma cifrelor este egala!");
            }
            System.out.println();
            if(pereche.NrCifrePare(pereche.getA())==pereche.NrCifrePare(pereche.getB()))
            {
                System.out.print("Numerele au acelasi  numar de cifre pare!");


            } else
                System.out.println("Nu au acelasi numar de cifre pare!");



        }

        //perechenumerec.add(new PerecheNumere(0,1));

        //scriere(perechenumerec);







    }




}
