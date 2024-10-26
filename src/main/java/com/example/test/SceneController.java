package com.example.test;

import com.example.test.Clase.Globale;
import com.example.test.Clase.Lucrator;
import com.example.test.Clase.Magazin;
import com.example.test.Clase.Manager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SceneController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void switchToMagazine(Button[] butoane){
        int i;
        for(i=0;i<10;++i)
        {   butoane[i].setText("Magazin "+(i+1));
            if(i< Magazin.getNumarMagazine())
                butoane[i].setStyle("-fx-background-color: #4299f0; ");
            else if(i==Magazin.getNumarMagazine()&& Globale.Bani>=Magazin.getCost())
                butoane[i].setStyle("-fx-background-color: #38fa69; ");
            else
                butoane[i].setStyle("-fx-background-color: #b3b3b3; ");
        }
    }
    public static void switchToManageri(Button[] butoane, int magazin){
        int i;
        for(i=0;i<10;++i)
        {butoane[i].setText("manager "+(i+1));
            if(i< Magazin.getMagazin(magazin).getNumarManageri())
                butoane[i].setStyle("-fx-background-color: #4299f0; ");
            else if(i==Magazin.getMagazin(magazin).getNumarManageri()&& Globale.Bani>=Manager.getCost())
                butoane[i].setStyle("-fx-background-color: #38fa69; ");
            else
                butoane[i].setStyle("-fx-background-color: #b3b3b3; ");
        }

    }

    public static void switchToLucratori(Button[] butoane, int magazin, int manager){
        int i;
        for(i=0;i<10;++i)
        {   butoane[i].setText("lucrator "+(i+1));
            if(i< Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori())
                butoane[i].setStyle("-fx-background-color: #4299f0; ");
            else if(Globale.Bani>= Lucrator.getCost()&&(Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()==i))
                butoane[i].setStyle("-fx-background-color: #38fa69; ");
            else
                butoane[i].setStyle("-fx-background-color: #b3b3b3; ");
        }
    }


}
