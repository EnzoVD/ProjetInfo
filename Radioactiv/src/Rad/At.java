package Rad;

public class At {
    protected String nom;
    protected String abr;
    int A;
    int Z;
    int N;
    int type;
    int pop2;
    int pop1;
    int popIni;
    boolean affiche;
    double activite;

    protected double dVie;

    public At() {
        super();
    }

    public String getnom() {
        return nom;
    }

    public String getabr() {
        return abr;
    }

    public int getA() {
        return A;
    }

    public int getZ() {
        return Z;
    }

    public int getN() {
        return N;
    }

    public int gettype() {
        return type;
    }

    public int getpop2() {
        return pop2;
    }

    public int getpop1() {
        return pop1;
    }

    public int getpopIn1() {
        return popIni;
    }

    public boolean getaffiche() {
        return affiche;
    }

    public void setnom(String s) {
        nom = s;
    }

    public void setabr(String t) {
        abr = t;
    }

    public void setA(int a) {
        A = a;
    }

    public void setnom(int z) {
        Z = z;
    }

    public void setN(int n) {
        N = n;
    }

    public void setZ(int z) {
        Z = z;
    }

    public void settype(int p) {
        type = p;
    }

    public void setpop2(int p2) {
        pop2 = p2;
    }

    public void setpop1(int p1) {
        pop1 = p1;
    }

    public void setpopIni(int pi) {
        popIni = pi;
    }

    public void setaffiche(boolean a) {
        affiche = a;
    }

    /*   public abstract double getdVie();

    public abstract void setdVie(double d);
*/

    public double getactivite() {
        return activite;
    }

    public void activite() {
        double t = Princip.getT();
        activite = Math.abs(pop1 - pop2) / (t);
    }


    public double getdVie() {
        return 0;
    }


    public void setdVie(double d) {
        dVie = 0;
    }
}