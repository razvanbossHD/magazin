package com.example.test.Clase;

import javafx.scene.control.Button;

public class FirMarire extends Thread{
    private Button buton;
    private Boolean hover=true;

    public FirMarire( Button buton,Boolean hover)
    {
        this.buton=buton;
        this.hover=hover;
        this.setDaemon(true);
    }


    public synchronized void run()
    {
        while(hover)
        {
            System.out.println("b");
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void setButon(Button buton) {
        System.out.println("c");
        this.buton = buton;
    }
    public Boolean MouseIsInside(){

        return hover;
    }

    public void setHover(Boolean hover) {
        this.hover = hover;
    }
}
