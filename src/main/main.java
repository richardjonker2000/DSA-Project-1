/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import railroad.*;

/**
 * @author Richard Jonker (a40527)
 * @author Paolo Cagol (a40956)
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        RR railroad = new RR();
       railroad.addTrain("TR1");
       railroad.addTrain("TR2");
       railroad.addTrain("TR3");
       railroad.addTrain("TR3");//train already exisits

       railroad.addstation("PRT", "Porto");
       railroad.addstation("LBN", "Lisbon");
       railroad.addstation("ALB", "Albufeira");
       railroad.addstation("BRG", "Braganca");
       railroad.addstation("BRG", "Braga");//Station already exisits
       
       
       railroad.addConnectiontoStation("PRT", "LBN");
       railroad.addConnectiontoStation("LBN", "ALB");
       railroad.addConnectiontoStation("PRT", "BRG");       
       railroad.addConnectiontoStation("PRT", "ALB2");//ALB2 does not exisit
       
       
       railroad.crossTrainByStation("TR1", "PRT", 1, true);
        railroad.crossTrainByStation("TR1", "LBN", 2, false);
       railroad.crossTrainByStation("TR1", "ALB", 3, true);
       railroad.crossTrainByStation("TR1", "LBN", 4, false);
       railroad.crossTrainByStation("TR1", "PRT", 9, false);       
       railroad.crossTrainByStation("TR1", "BRG", 2, true);
       
       railroad.crossTrainByStation("TR2", "PRT", 7, true);
       railroad.crossTrainByStation("TR2", "ALB", 6, true);//missing connection
       
       railroad.crossTrainByStation("TR4", "PRT", 8, true);//train does not exixist
       
        System.out.println(railroad.crossesStationToString("PRT"));
        System.out.println(railroad.crossesStationToString("LBN"));
        System.out.println(railroad.crossesStationToString("ALB"));
        System.out.println(railroad.crossesStationToString("BRG"));
        System.out.println(railroad.stopTrainToString("TR1"));
        System.out.println(railroad.stopTrainToString("TR2"));
       

    }
    
}
