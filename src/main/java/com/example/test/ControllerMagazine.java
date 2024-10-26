package com.example.test;

import com.example.test.Clase.*;
import javafx.event.ActionEvent;
import com.example.test.Interfete.Scene;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ControllerMagazine implements Scene, Initializable {
    private static int scena=1, magazin=0, manager=0;
    @FXML
    public Button buton1;
    @FXML
    public Button buton2;
    @FXML
    public Button buton3;
    @FXML
    public Button buton4;
    @FXML
    public Button buton5;
    @FXML
    public Button buton6;
    @FXML
    public Button buton7;
    @FXML
    public Button buton8;
    @FXML
    public Button buton9;
    @FXML
    public Button buton10;
    @FXML
    public Button butoniesire;
    @FXML
    public Button butonstartsift;
    @FXML
    public Button butonmaxim;
    @FXML
    public Label Bani;

    FirMarire firMarire=new FirMarire(buton1, false);

    @Override
    public void initialize(URL url, ResourceBundle rb){

        buton1.setOnAction((ActionEvent e)->{apasa(buton1);});
        FirMarire firMarire=new FirMarire(buton1, true);
        buton1.setStyle("-fx-background-color: #38fa69; ");
        buton2.setOnAction((ActionEvent e)->{apasa(buton2);});
        buton2.setStyle("-fx-background-color: #b3b3b3; ");
        buton3.setOnAction((ActionEvent e)->{apasa(buton3);});
        buton3.setStyle("-fx-background-color: #b3b3b3; ");
        buton4.setOnAction((ActionEvent e)->{apasa(buton4);});
        buton4.setStyle("-fx-background-color: #b3b3b3; ");
        buton5.setOnAction((ActionEvent e)->{apasa(buton5);});
        buton5.setStyle("-fx-background-color: #b3b3b3; ");
        buton6.setOnAction((ActionEvent e)->{apasa(buton6);});
        buton6.setStyle("-fx-background-color: #b3b3b3; ");
        buton7.setOnAction((ActionEvent e)->{apasa(buton7);});
        buton7.setStyle("-fx-background-color: #b3b3b3; ");
        buton8.setOnAction((ActionEvent e)->{apasa(buton8);});
        buton8.setStyle("-fx-background-color: #b3b3b3; ");
        buton9.setOnAction((ActionEvent e)->{apasa(buton9);});
        buton9.setStyle("-fx-background-color: #b3b3b3; ");
        buton10.setOnAction((ActionEvent e)->{apasa(buton10);});
        buton10.setStyle("-fx-background-color: #b3b3b3; ");
        butoniesire.setOnAction((ActionEvent e)->{apasa(butoniesire);});
        butonstartsift.setOnAction((ActionEvent e)->{apasa(butonstartsift);});
        butonmaxim.setOnAction((ActionEvent e)->{apasa(butonmaxim);});
        Bani.setText("Bani:"+ Globale.Bani);

    }
    public void enterButon(MouseEvent e)
    {   firMarire.start();
    }
    public void exitButon(MouseEvent e)
    {
        firMarire.setHover(false);
    }

    @Override
    public void fazein(ActionEvent e) {

    }

    @Override
    public void fazeout(ActionEvent e) {

    }

    @Override
    public void apasa(Button buton) {
        int i;
        Button[] butoane=new Button[12];
        butoane[0]=buton1;
        butoane[1]=buton2;
        butoane[2]=buton3;
        butoane[3]=buton4;
        butoane[4]=buton5;
        butoane[5]=buton6;
        butoane[6]=buton7;
        butoane[7]=buton8;
        butoane[8]=buton9;
        butoane[9]=buton10;
        butoane[10]=butoniesire;
        butoane[11]=butonstartsift;
        for(i=1;i<11;++i) {
            if(buton.getId().equals("mag"+i)||buton.getId().equals("buton"+i))
            {


                if(ControllerMagazine.scena==1)
                {   if(buton.getId().equals("mag"+(Magazin.getNumarMagazine()+1))||buton.getId().equals("buton"+(Magazin.getNumarMagazine()+1)))
                    {   int tmp=Magazin.getNumarMagazine();
                        Magazin.cumparareMagazin();
                        if((tmp<Magazin.getNumarMagazine())&&(Magazin.getNumarMagazine()<10))
                        {
                            buton.setStyle("-fx-background-color: #4299f0; ");
                            if(Globale.Bani>=Magazin.getCost())
                                butoane[Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))].setStyle("-fx-background-color: #38fa69; ");
                        }
                        Bani.setText("Bani:"+ Globale.Bani);
                    }
                    else if (Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))<Magazin.getNumarMagazine()+1)
                    {   ControllerMagazine.scena=2;
                        magazin=i-1;
                        SceneController.switchToManageri(butoane, magazin);
                    }

                    return;}
                else if(ControllerMagazine.scena==2)
                {
                    if(buton.getId().equals("mag"+(Magazin.getMagazin(magazin).getNumarManageri()+1))||buton.getId().equals("buton"+(Magazin.getMagazin(magazin).getNumarManageri()+1))&&Globale.Bani>=Manager.getCost())
                    {   int tmp=Magazin.getMagazin(magazin).getNumarManageri();
                        Magazin.getMagazin(magazin).adaugareManager();
                        if((tmp<Magazin.getMagazin(magazin).getNumarManageri())&&(Magazin.getMagazin(magazin).getNumarManageri()<10))
                        {
                            buton.setStyle("-fx-background-color: #4299f0; ");
                            if(Globale.Bani>= Manager.getCost())
                                butoane[Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))].setStyle("-fx-background-color: #38fa69; ");
                        }
                        Bani.setText("Bani:"+ Globale.Bani);
                    }
                    else if (Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))<Magazin.getMagazin(magazin).getNumarManageri()+1)
                {   ControllerMagazine.scena=3;

                    manager=Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))-1;
                    SceneController.switchToLucratori(butoane, magazin, manager);
                }
                    return;}
                else if(ControllerMagazine.scena==3)
                {
                    if(buton.getId().equals("mag"+((Magazin.getMagazin(magazin).getManager(manager)).getNumarLucratori()+1))||buton.getId().equals("buton"+((Magazin.getMagazin(magazin).getManager(manager)).getNumarLucratori()+1)))
                    {   int tmp=Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori();
                        Magazin.getMagazin(magazin).getManager(manager).angajareLucrator();
                        if((tmp<Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()))
                        {
                            buton.setStyle("-fx-background-color: #4299f0; ");
                            if(Globale.Bani>= Lucrator.getCost()&&(Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()<10))
                                butoane[Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))].setStyle("-fx-background-color: #38fa69; ");
                        }
                        //if(tmp<Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori())
                        //    buton.setText(Magazin.getMagazin(magazin).getManager(manager).getLucrator(i).getNume());
                        Bani.setText("Bani:"+ Globale.Bani);
                    }
                    /*else if (Integer.parseInt(buton.getId().replaceAll("[^0-9]", ""))<Magazin.getNumarMagazine()+1)
                    {   ControllerMagazine.scena=3;
                        manager=i-1;
                    }*/
                    return;
                }
            }
        }
        if(buton.getId().equals("butoniesire"))
        {
            switch (ControllerMagazine.scena){
                case 1:System.exit(0);
                    break;
                case 2:SceneController.switchToMagazine(butoane);
                    ControllerMagazine.scena=1;
                    break;
                case 3:
                    SceneController.switchToManageri(butoane, magazin);
                    ControllerMagazine.scena=2;
                    break;

            }
        }
        if(buton.getId().equals("butonstartsift"))
        {
            switch (ControllerMagazine.scena){
                case 1:Globale.Bani+=Globale.getRevenitGlobal();
                    Bani.setText("Bani:"+ Globale.Bani);
                    if(Globale.Bani>=Magazin.getCost()&&Magazin.getNumarMagazine()<10)
                        butoane[Magazin.getNumarMagazine()].setStyle("-fx-background-color: #38fa69; ");
                    break;
                case 2:Globale.Bani+=Magazin.getMagazin(magazin).getRevenit();
                    Bani.setText("Bani:"+ Globale.Bani);
                    if(Globale.Bani>=Manager.getCost()&&Magazin.getMagazin(magazin).getNumarManageri()<10)
                        butoane[Magazin.getMagazin(magazin).getNumarManageri()].setStyle("-fx-background-color: #38fa69; ");
                    break;
                case 3:Globale.Bani+=Magazin.getMagazin(magazin).getManager(manager).getRevenit();
                    Bani.setText("Bani:"+ Globale.Bani);
                    if(Globale.Bani>=Lucrator.getCost()&&Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()<10)
                        butoane[Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()].setStyle("-fx-background-color: #38fa69; ");
                    break;

            }
        }
        if(buton.getId().equals("butonmaxim"))
        {
            switch (ControllerMagazine.scena){
                case 1:
                    int h, k;
                    for(h=0;h<Magazin.getNumarMagazine();++h)
                    {   butoane[h].setStyle("-fx-background-color: #4299f0; ");
                        for(k=0;k<Magazin.getMagazin(h).getNumarManageri();++k)
                            while((!(Magazin.getMagazin(h).getManager(k).isFull()))&&(Globale.Bani>=Lucrator.getCost()))
                                Magazin.getMagazin(h).getManager(k).angajareLucrator();
                        while(Globale.Bani>=Manager.getCost()&&Magazin.getMagazin(h).getNumarManageri()<10)
                        {   Magazin.getMagazin(h).adaugareManager();
                            while(Globale.Bani>=Lucrator.getCost()&&(!(Magazin.getMagazin(h).getManager(Magazin.getMagazin(h).getNumarManageri()-1).isFull())))
                                Magazin.getMagazin(h).getManager(Magazin.getMagazin(h).getNumarManageri()-1).angajareLucrator();

                        }
                    }
                    while(Globale.Bani>=Magazin.getCost()&&Magazin.getNumarMagazine()<10)
                    {   Magazin.cumparareMagazin();
                        butoane[Magazin.getNumarMagazine()-1].setStyle("-fx-background-color: #4299f0; ");
                        for(k=0;k<Magazin.getMagazin(Magazin.getNumarMagazine()-1).getNumarManageri();++k)
                            while((!(Magazin.getMagazin(Magazin.getNumarMagazine()-1).getManager(k).isFull()))&&(Globale.Bani>=Lucrator.getCost()))
                                Magazin.getMagazin(Magazin.getNumarMagazine()-1).getManager(k).angajareLucrator();
                        while(Globale.Bani>=Manager.getCost()&&Magazin.getMagazin(Magazin.getNumarMagazine()-1).getNumarManageri()<10)
                        {   Magazin.getMagazin(Magazin.getNumarMagazine()-1).adaugareManager();
                            while(Globale.Bani>=Lucrator.getCost()&&(!(Magazin.getMagazin(Magazin.getNumarMagazine()-1).getManager(Magazin.getMagazin(Magazin.getNumarMagazine()-1).getNumarManageri()-1).isFull())))
                                Magazin.getMagazin(Magazin.getNumarMagazine()-1).getManager(Magazin.getMagazin(Magazin.getNumarMagazine()-1).getNumarManageri()-1).angajareLucrator();
                        }

                    }
                    Bani.setText("Bani:"+ Globale.Bani);
                    break;
                case 2:
                    for(k=0;k<Magazin.getMagazin(magazin).getNumarManageri();++k)
                        while((!(Magazin.getMagazin(magazin).getManager(k).isFull()))&&(Globale.Bani>=Lucrator.getCost()))
                            Magazin.getMagazin(magazin).getManager(k).angajareLucrator();
                    while(Globale.Bani>=Manager.getCost()&&Magazin.getMagazin(magazin).getNumarManageri()<10)
                    {   Magazin.getMagazin(magazin).adaugareManager();
                        while(Globale.Bani>=Lucrator.getCost()&&(!(Magazin.getMagazin(magazin).getManager(Magazin.getMagazin(magazin).getNumarManageri()-1).isFull())))
                            Magazin.getMagazin(magazin).getManager(Magazin.getMagazin(magazin).getNumarManageri()-1).angajareLucrator();
                        butoane[Magazin.getMagazin(magazin).getNumarManageri()-1].setStyle("-fx-background-color: #4299f0; ");
                    }


                    Bani.setText("Bani:"+ Globale.Bani);
                    break;
                case 3:
                    while ((((Magazin.getNumarMagazine() * 10 > Manager.getNumarManageri())&&(Globale.Bani>=Manager.getCost())) || ((Lucrator.getNumarLucratori() < Manager.getNumarManageri() * 10)&&(Globale.Bani>=Lucrator.getCost())) || (Magazin.getNumarMagazine()<10&&Globale.Bani>=Magazin.getCost())))
                    {

                        Magazin.getMagazin(magazin).getManager(manager).angajareLucrator();
                        butoane[Magazin.getMagazin(magazin).getManager(manager).getNumarLucratori()-1].setStyle("-fx-background-color: #4299f0; ");
                        Bani.setText("Bani:"+ Globale.Bani);
                    }
                    break;

            }
        }
    }

}
