package Rad;


import java.util.LinkedList;
import java.util.List;

public class Princip {
    //pas du chronom�tre
   protected static double T;
   
   public LinkedList<At> ListeElem = new LinkedList();
   
   public static double getT(){
       return T;
   }
   
   public static void setT(double t){
       T=t;
   }
    
    public static void main(){
        
    }
    
    public void Origin(){
        //doit lire les csv, cr�er pour chaque ligne un �l�ment (type d�pend du fichier csv)
        //cr�e une liste chain�e des �l�ments cr�es
        readCSV.convertCsvToJavaAt(ListeElem);
        readCSV.convertCsvToJavaAtR(ListeElem);
    }



}
