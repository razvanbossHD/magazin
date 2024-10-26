package com.example.test.Clase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class Globale {
    public static int Bani=1110;
    public static int Nume=0;
    private static String persoana;
    private int cost;
    private static int RevenitGlobal=0;
    public static String newNume()
    {   if(Nume<2923) {
        try {
            File fisierNume = new File("src/main/java/com/example/test/Clase/Nume.txt");
            Scanner Citeste = new Scanner(fisierNume);
            int i;
            Nume++;
            for (i = 0; i < Nume; ++i)
                persoana = Citeste.nextLine();
            Nume++;
            return persoana;

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            //e.printStackTrace();
        }

        }
        return "";
    }

    public int getCost() {
        return cost;
    }
    public static void addBani(int suma)
    {
        if(suma>0)
            Bani+=suma;
    }
    public static void redBani(int suma)
    {
        if(suma>0)
            Bani-=suma;
    }

    public static int getRevenitGlobal() {
        return RevenitGlobal;
    }
    public static void addRevenitGlobal(int suma)
    {
        if(suma>0)
            RevenitGlobal+=suma;
    }
    public static void redRevenitGlobal(int suma)
    {
        if(suma>0)
            RevenitGlobal-=suma;
    }
}
