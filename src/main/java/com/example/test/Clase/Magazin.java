package com.example.test.Clase;

public class Magazin {
    private static int NumarMagazine=0;
    private static Magazin[] magazins= new Magazin[10];
    private Manager[] manager= new Manager[10];
    private int ID;
    private String tip ="Haine";
    private static int cost=1000;
    private int NumarManageri=0;
    private int Revenit=0;
    public Magazin()
    {   this.ID=NumarMagazine;
        NumarMagazine++;
        Globale.redBani(cost);
    }
    public void adaugareManager()
    {
        if(Globale.Bani>= Manager.getCost()&&this.NumarManageri<10) {
            this.manager[(this.NumarManageri)]= new Manager(this.ID, Globale.newNume(), this.NumarManageri);
            this.NumarManageri++;}
    }
    public Manager getManager(int nr)
    {
        return this.manager[nr];
    }
    public static int getNumarMagazine()
    {
        return NumarMagazine;
    }
    public int getID()
    {
        return this.ID;
    }
    public int getNumarManageri()
    {
        return this.NumarManageri;
    }
    public static void cumparareMagazin()
    {   if(Globale.Bani>=Magazin.getCost()&&NumarMagazine<10)
           magazins[NumarMagazine]=new Magazin();
    }
    public static Magazin getMagazin(int n)
    {
        return Magazin.magazins[n];
    }
    public static String getTip(int n)
    {
        return Magazin.magazins[n].tip;
    }

    public static int getCost() {
        return cost;
    }

    public int getRevenit() {
        return Revenit;
    }

    public void addRevenit(int add)
    {
        Revenit++;
    }

    public Boolean isFull()
    {
        if(this.NumarManageri<10)
            return false;
        else
        {
            int i;
            for(i=0;i<10;++i)
                if(!(this.getManager(i).isFull()))
                    return false;
        }

        return true;
    }
}
