package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.awt.AWTEventMulticaster.add;

public class Main {


    public static void scriere(List<Angajat> lista) {

        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");
            mapper.writeValue(file,lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Angajat> citire() {

        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            File file=new File("src/main/resources/angajati.json");

            List<Angajat> persoane = mapper
                    .readValue(file, new TypeReference<List<Angajat>>(){});
            return persoane;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) {
        // Initialize the list
        List<Angajat> angajats = citire();

        /*// Adăugarea a 10 instanțe Angajat cu toate câmpurile diferite
        angajats.add(new Angajat("Maria", "Programator", LocalDate.of(2023, 1, 30), 4000));
        angajats.add(new Angajat("Ana", "Designer", LocalDate.of(2022, 5, 15), 4500));
        angajats.add(new Angajat("Ion", "Analist", LocalDate.of(2023, 9, 20), 3800));
        angajats.add(new Angajat("Alex", "Manager", LocalDate.of(2024, 3, 10), 6000));
        angajats.add(new Angajat("Elena", "Inginer", LocalDate.of(2022, 8, 25), 4200));
        angajats.add(new Angajat("Mihai", "Consultant", LocalDate.of(2023, 7, 5), 4800));
        angajats.add(new Angajat("Andreea", "Administrator", LocalDate.of(2023, 4, 18), 3700));
        angajats.add(new Angajat("Vlad", "Programator", LocalDate.of(2022, 12, 9), 4100));
        angajats.add(new Angajat("Cristina", "Analyst", LocalDate.of(2023, 11, 3), 5200));
        angajats.add(new Angajat("George", "Designer", LocalDate.of(2024, 2, 14), 4700));*/

        // Print the list
       // System.out.println(angajats);
        angajats.forEach(angajat -> System.out.println(angajat));

        // Serialize the list and write it to file
        //scriere(angajats);

         System.out.println("Angajatii cu peste 2500 salariul!");

        //Definim un Predicat pentru a verifica daca salariul unui angajat este mai mare de 2500 de lei

        Predicate<Angajat> salariuPeste2500 = angajat -> angajat.getSalariu()>2500;

        //folosim stream uri pentru a filtra angajatii care indeplinesc conditia

        /*angajats.stream()
                .filter(salariuPeste2500)
                .forEach(System.out::println);*/ //afisam


       /* 3. Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de
        conducere (postul conține unul din cuvintele sef sau director). Pentru crearea unei liste
        dintr-un stream se va utiliza operația terminală collect (Collectors.toList()). Se vor
        utiliza steram-uri şi expresii lambda. Noua listă va fi apoi afișată. Anul curent se va citi
        din sistem*/



            // lista cu angajatii care sunt sefi sau sunt director
       /* Predicate <Angajat> AngajatSef = angajat -> (angajat.getPostul().equals("sef") || angajat.getPostul().equals("director"));

        List<Angajat> AngajatCeo = angajats
                .stream()
                .filter(AngajatSef)
                .collect(Collectors.toList());



        AngajatCeo.forEach(System.out::println);
*/


        /*Predicate<Angajat> NormalAngajat = angajat -> !(angajat.getPostul().equals("sef") || angajat.getPostul().equals("director"));

        List<Angajat> AngjatSimplu = angajats
                .stream()
                .filter(NormalAngajat)
                .sorted((angajat1, angajat2) -> Double.compare(angajat2.getSalariu(), angajat1.getSalariu())) // Comparator pentru sortare descrescătoare
                .collect(Collectors.toList());

        AngjatSimplu.forEach(System.out::println);*/

        /*List<String> ListaNume = angajats
                .stream()
                .map((angajat)->angajat.getNume().toUpperCase())
                .collect(Collectors.toList());

                ListaNume.forEach(System.out::println);

*/
        /*List<Float> SalariList = angajats
                .stream()
                .filter(angajat -> angajat.getSalariu() < 3000) // Filtru pentru salariile mai mici de 3000
                .map(Angajat::getSalariu) // Extragem doar salariile angajaților
                .collect(Collectors.toList()); // Colectăm rezultatele într-o listă

        SalariList.forEach(System.out::println); // Afișăm lista de salarii*/


         /*// Determinăm minimul din stream folosind un comparator corespunzător
        Optional<Angajat> primulAngajatOptional = angajats
                .stream()
                .min(Comparator.comparing(Angajat::getData_angajarii));

        // Verificăm dacă există un prim angajat
        if (primulAngajatOptional.isPresent()) {
            // Afișăm detaliile primului angajat
            Angajat primulAngajat = primulAngajatOptional.get();
            System.out.println("Detalii primul angajat:");
            System.out.println(primulAngajat);
        } else {
            // Afișăm un mesaj dacă nu există angajați în firmă
            System.out.println("Nu există angajați în firmă.");
        }*/


       /* DoubleSummaryStatistics statistics = angajats
                .stream()
                . collect(Collectors.summarizingDouble(Angajat::getSalariu)) ;

        // Afișăm statistici despre salarii
        System.out.println("Salariu mediu: " + statistics.getAverage());
        System.out.println("Salariu minim: " + statistics.getMin());
        System.out.println("Salariu maxim: " + statistics.getMax());*/

        /*// Verificăm dacă există cel puțin un angajat cu numele "Ion"
        Optional<Angajat> ionOptional = angajats
                .stream()
                .filter(angajat -> angajat.getNume().equals("Ion"))
                .findAny();

        // Afisăm mesaje corespunzătoare în funcție de situație
        ionOptional.ifPresentOrElse(
                angajat -> System.out.println("Firma are cel puțin un Ion angajat"),
                () -> System.out.println("Firma nu are nici un Ion angajat")
        );

*/

        // Determinăm numărul de persoane care s-au angajat în vara anului precedent
        long numarPersoaneAngajate = angajats
                .stream()
                .filter(angajat -> angajat.getData_angajarii().getYear() == LocalDate.now().getYear() - 1 && // anul precedent
                        angajat.getData_angajarii().getMonthValue() >= 6 &&  // luna iunie sau ulterioară
                        angajat.getData_angajarii().getMonthValue() <= 8)   // luna august sau anterioară
                .count();

        // Afișăm numărul de persoane angajate în vara anului precedent
        System.out.println("Numărul de persoane care s-au angajat în vara anului precedent: " + numarPersoaneAngajate);


    }




}