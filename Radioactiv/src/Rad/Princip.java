package Rad;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.Timer;
/*
 * CREDITS
 * getters et setters par Kexin Zong
 * Objet At et base de donn�e des atomes par Daphn� Guibert
 * Jmathplot, courbes etc... par Alexandre Lamartine
 * Reste par Enzo Vironda
 * ReadCSV inspir� de Nagesh Chauhan @http://www.beingjavaguys.com/2013/09/read-and-parse-csv-file-in-java.html
 * Relecture, optimisation, correction par tous
 */

public class Princip {
    //pas du chronom�tre
    protected static int T;
    static Timer timer;
    protected double temps;
    protected static ArrayList<At> ListeElem =
        new ArrayList(); //passage d'une lined list � Array list car Linkedlist.get o(n) et ArrayList.get o(1) d'o� une surchage de parcours
    protected static JTable tabElem;
    protected static boolean finSim;
    protected int posElec;
    protected int posHel;
    protected int posProt;
    protected static boolean StartSim;

    public Princip() {
        //rempli la liste des atomes
        readCSV.convertCsvToJavaAt(ListeElem);
        readCSV.convertCsvToJavaAtR(ListeElem);
        InterfGraph.main();
        // TODO cr�er fonction qui remplit les conditions initiales
        Origin(); // d�marre timer

    }

    public void desint(At atome) {
        At atomeprov;
        At atomedes;
        int posAtome;
        int des = 0;
        switch (atome.gettype()) {
        case 0:
            break;
        case 1:
            { //alpha
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA() - 4) & atomeprov.getZ() == (atome.getZ() - 2)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) (atome.popIni * Math.exp(atome.getdVie() * temps))); // loi decroissance radio
                        atomedes.setpop1(atome.pop2);
                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop2(des);
                        ListeElem.set(i, atomedes);
                        At He = ListeElem.get(posHel); // trouve �l�m Helium, pop1 pop pr�c�dente, pop2 nouvelle pop
                        He.setpop1(He.getpop2());
                        He.setpop2(He.getpop2() + des);
                        ListeElem.set(posHel, He);
                    }
                }

            }
            break;
        case 2:
            { //Beta moins
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA()) & atomeprov.getZ() == (atome.getZ() + 1)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) (atome.popIni *
                                             Math.exp(atome.getdVie() * temps))); // loi decroissance radio
                        atomedes.setpop1(atome.pop2);
                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop2(des);
                        ListeElem.set(i, atomedes);
                        At El = ListeElem.get(posElec); // trouve �l�m Elec, pop1 pop pr�c�dente, pop2 nouvelle pop
                        El.setpop1(El.getpop2());
                        El.setpop2(El.getpop2() + des);
                        ListeElem.set(posElec, El);
                    }
                }

            }
            break;
        case 3:
            { //Beta plus
                for (int i = 0; i < ListeElem.size(); i++) {
                    atomeprov = ListeElem.get(i);
                    if (atomeprov.getA() == (atome.getA()) & atomeprov.getZ() == (atome.getZ() - 1)) {
                        atomedes = atomeprov;
                        atome.setpop1(atome.pop2);
                        atome.setpop2((int) (atome.popIni *
                                             Math.exp(atome.getdVie() * temps))); // loi decroissance radio
                        atomedes.setpop1(atome.pop2);
                        des = Math.abs(atome.getpop2() - atome.getpop1());
                        atomedes.setpop2(des);
                        ListeElem.set(i, atomedes);
                        At Pro = ListeElem.get(posProt); // trouve �l�m Proton, pop1 pop pr�c�dente, pop2 nouvelle pop
                        Pro.setpop1(Pro.getpop2());
                        Pro.setpop2(Pro.getpop2() + des);
                        ListeElem.set(posProt, Pro);
                    }
                }

            }
            break;
        case 4:
            {
            }
            break;

        }


    }


    

    public void boucle_principale() {
        // appPro�e � chaque instant t
        //parcoure Listelem
        // r�alise la d�gradation de chaque �l�ment
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            desint(atome);
            atome.activite();
        }
        tabElem=new JTable(new MyTableModel_1());
    }

    public static void main() {

    }

    private class TimerAction implements ActionListener {

        // ActionListener appProee tous les interval millisecondes

        public void actionPerformed(ActionEvent e) {
            boucle_principale();
            temps = temps + T;
        }

    }

    private void Origin() {
        timer = new Timer(T, new TimerAction()); //impl�menter timeraction Timer(T, new TimerAction())
        /*
             * timer.start()
             *      stop
             *      setdelay
             */
        //doit lire les csv, cr�er pour chaque ligne un �l�ment (type d�pend du fichier csv)
        //cr�e une liste chain�e des �l�ments cr�es
        temps = 0;
        timer.start();
    }
    
    private void searchPosParticule(){
        /*
         * cherche et initialise la position des particules importantes dans la d�sint�gration, la taille de l'ArrayList ne changeant pas.
         */
        At atome;
        for (int i = 0; i < ListeElem.size(); i++) {
            atome = ListeElem.get(i);
            if(atome.getA()==4 & atome.getZ()==2){posHel=i;}
            else if(atome.getA()==0 & atome.getZ()==1){posProt=i;}
            else if(atome.getA()==0 & atome.getZ()==1){posElec=i;}
        }
    }
    
    /*
     * Impl�mentation Boutons
     */

    public static void stopButton() {
        if (timer.isRunning()) {
            timer.stop();
        }
        setfinSim(true);
        setStartSim(false);
    }

    public static void pauseButton() {
        if (timer.isRunning() & getStartSim()) {
            timer.stop();
        }
        
        else if (timer.isRunning()==false & getStartSim()) {
            timer.start();
        }
        else{}

    }

    public static void playButton() {
        if (timer.isRunning()==false & getStartSim()==false & getfinSim()==false) {
            timer.start();
            setStartSim(true);
        } else {}

    }
    /*
     * Getters et setters
     */
    public static ArrayList getList() {
        return ListeElem;
    }
    
    public static void setList(ArrayList L) {
        ListeElem=L;
    }
    
    public static JTable getTabElem() {
        return tabElem;
    }
    
    public static void setTabElem(JTable t) {
        tabElem=t;
    }
    
    public static boolean getStartSim(){
        return StartSim;
    }
    
    public static void setStartSim(boolean S){
        StartSim=S;
    }
    
    public static boolean getfinSim(){
        return finSim;
    }
    
    public static void setfinSim(boolean f){
        finSim=f;
    }
    
    public static int getT() {
        return T;
    }

    public static void setT(int t) {
        T = t;
    }
}
