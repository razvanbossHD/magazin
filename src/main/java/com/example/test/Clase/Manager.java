package com.example.test.Clase;

public class Manager {
    private static int NumarManageri = 0;
    private int ID;
    private String Nume;
    private int NumarLucratori=0;
    private static int Cost=100;
    private int Revenit=0;
    Lucrator[] lucrator = new Lucrator[10];

    public Manager(int ID, String Nume, int nr) {
        this.ID = (ID*10)+nr;
        this.Nume=Nume;
        NumarManageri++;
        Globale.redBani(Cost);
    }
    public void angajareLucrator()
    {   if(Globale.Bani>=Lucrator.getCost()&&this.getNumarLucratori()<10)
        {   this.lucrator[this.NumarLucratori]= new Lucrator(this.ID, Globale.newNume(), this.NumarLucratori);
            this.NumarLucratori++;}
    }
    public int getID() {
        return ID;
    }
    public Lucrator getLucrator(int ID)
    {
        return this.lucrator[ID];
    }

    public int getNumarLucratori() {
        return NumarLucratori;
    }

    public String getNume() {
        return Nume;
    }

    public static int getCost() {
        return Cost;
    }

    public int getRevenit() {
        return Revenit;
    }
    public void addRevenit(int add)
    {
        Revenit++;
    }

    public static int getNumarManageri() {
        return NumarManageri;
    }

    public Boolean isFull()
    {
        return this.getNumarLucratori() >= 10;
    }


    /*public void adaugareManageri()
    {
        this.manager[this.NumarManageri]= new Manager();
        this.NumarManageri++;
    }*/
}
