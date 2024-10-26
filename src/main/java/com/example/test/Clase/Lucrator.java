package com.example.test.Clase;

public class Lucrator {
    private static int NumarLucratori = 0;
    private int ID;
    private String Nume;
    private static int Cost=10;
    private int Revenit=10;
    public Lucrator(int IDManager, String Nume, int nrLucratori) {
        this.ID = IDManager*10+nrLucratori+1;
        NumarLucratori++;
        this.Nume=Nume;
        Globale.redBani(Cost);
        Magazin.getMagazin((IDManager/10)).addRevenit(Revenit);
        Magazin.getMagazin(IDManager/10).getManager(IDManager%10).addRevenit(Revenit);
        Globale.addRevenitGlobal(Revenit);
    }
    public int getID() {
        return ID;
    }

    public String getNume() {
        return Nume;
    }
    public static int getNumarLucratori() {
        return NumarLucratori;
    }

    public static int getCost() {
        return Cost;
    }

    public int getRevenit() {
        return Revenit;
    }
    /*public void adaugareManageri()
    {

        this.manager[this.NumarManageri]= new Manager();
        this.NumarManageri++;
    }*/
}
