/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */

public class Point {
    private double px;
    private double py;
    private int num;

    public Point(double px, double py, int num) {
        this.px = px;
        this.py = py;
        this.num = num;
    }

    public Point(double px, double py) {
        this.px = px;
        this.py = py;
    }
public Point(){
    
}

    public double getPx() {
        return px;
    }

    /**
     * @param px the px to set
     */
    public void setPx(double px) {
        this.px = px;
    }

    /**
     * @return the py
     */
    public double getPy() {
        return py;
    }

    /**
     * @param py the py to set
     */
    public void setPy(double py) {
        this.py = py;
    }

    public String toStringPoint() {
        String res;
        res = "(" + px + "," + py + ")"+" num : "+num;
        return res;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
  public Point demandePoint() {
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonné : ");
        double y = Lire.d();
        System.out.println("Numéro du point (0 ou 1 ou 2)");
        int num = Lire.i();
        Point res = new Point(x, y, num);// à modifier attention identifiant
        return res;
    }
  public Point demandePointTriangleTerrainDejaExistant() {
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonné : ");
        double y = Lire.d();
        Point res = new Point(x, y, 0);// à modifier attention identifiant
        return res;
    }
    
}
