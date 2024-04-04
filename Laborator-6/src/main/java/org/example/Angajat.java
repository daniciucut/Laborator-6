package org.example;

import java.time.LocalDate;

public class Angajat {

    public Angajat() { //constructor fara parametri
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    protected String Nume;

    public String getPostul() {
        return Postul;
    }

    public void setPostul(String postul) {
        Postul = postul;
    }

    protected String Postul;

    public LocalDate getData_angajarii() {
        return data_angajarii;
    }

    public void setData_angajarii(LocalDate data_angajarii) {
        this.data_angajarii = data_angajarii;
    }

    protected LocalDate data_angajarii;

    public float getSalariu() {
        return Salariu;
    }

    public void setSalariu(float salariu) {
        Salariu = salariu;
    }

    protected float Salariu;

        public  Angajat(String Nume, String Postul, LocalDate data_angajari, float salariu)
        {
            this.data_angajarii=data_angajari;
            this.Nume=Nume;
            this.Postul=Postul;
            this.Salariu = salariu;

        }


    @Override
    public String toString() {
        return "Angajat{" +
                "Nume='" + Nume + '\'' +
                ", Postul='" + Postul + '\'' +
                ", data_angajarii=" + data_angajarii +
                ", Salariu=" + Salariu +
                '}';
    }
}
