/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class Barre {

    private int id;
    private Noeud debut;
    private Noeud fin;
    private TypeBarre typeBarre;

    public Barre(int id, Noeud debut, Noeud fin, TypeBarre typeBarre) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.typeBarre = typeBarre;
    }

    public Barre(int id, Noeud debut, Noeud fin) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
    }

    public Barre() {
        this.id = 0;
        this.debut = new NoeudSimple();
        this.fin = new NoeudSimple();
        this.typeBarre = new TypeBarre();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the debut
     */
    public Noeud getDebut() {
        return debut;
    }

    /**
     * @return the fin
     */
    public Noeud getFin() {
        return fin;
    }

    public String toStringBarre() {
        String res = "identifiant : " + this.id + " , noeud debut : " + this.debut.toStringNoeud() + " ,  noeud fin : " + this.fin.toStringNoeud() + " " + this.typeBarre.toStringTypeBarre();
        return res;
    }

    public Point coordonneNoeudAppui(NoeudAppui na) {
        double alpha = na.getAlpha();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        p1 = coordonnePremierPointSegmentTerrain(na);
        p2 = coordonneSecondPointSegmentTerrain(na);
        double abs = (alpha * p1.getPx() + (1 - alpha) * p2.getPx());
        double ord = (alpha * p1.getPy() + (1 - alpha) * p2.getPy());
        Point res = new Point(abs, ord);
        return res;
    }

    public Point coordonnePremierPointSegmentTerrain(NoeudAppui noeudappui) {
        TriangleTerrain tt = new TriangleTerrain();
        tt = noeudappui.getTriangleterrain();
        int num = noeudappui.getPremierptsegterr();
        int num0 = tt.getPoint0().getNum();
        int num1 = tt.getPoint1().getNum();
        int num2 = tt.getPoint2().getNum();
        Point p0 = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        p0 = tt.getPoint0();
        p1 = tt.getPoint1();
        p2 = tt.getPoint2();

        if (num == num0) {
            return p0;
        } else if (num == num1) {
            return p1;
        } else if (num == num2) {
            return p2;
        } else {
            return null;
        }

    }

    public Point coordonneSecondPointSegmentTerrain(NoeudAppui na) {
        Point p = new Point();
        p = coordonnePremierPointSegmentTerrain(na);

        int numpt1 = p.getNum();

        int numpt2 = ((numpt1 + 1) % 3);

        TriangleTerrain tt = new TriangleTerrain();
        tt = na.getTriangleterrain();
        int num0 = tt.getPoint0().getNum();
        int num1 = tt.getPoint1().getNum();
        int num2 = tt.getPoint2().getNum();
        Point p0 = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        p0 = tt.getPoint0();
        p1 = tt.getPoint1();
        p2 = tt.getPoint2();

        if (num0 == numpt2 || num0 != numpt1) {
            return p0;
        } else if (num1 == numpt2 || num1 != numpt1) {
            return p1;
        } else if (num2 == numpt2 || num2 != numpt1) {
            return p2;
        } else {
            return null;
        }
    }

    public double longueurBarre(Barre b) {
        double x1 = 0;
        double x2 = 0;
        double y1 = 0;
        double y2 = 0;

        if (b.debut instanceof NoeudSimple) {
            NoeudSimple n = new NoeudSimple();
            n = (NoeudSimple) b.debut;
            x1 = n.getPx();
            y1 = n.getPy();
        }
        if (b.fin instanceof NoeudSimple) {
            NoeudSimple n = new NoeudSimple();
            n = (NoeudSimple) b.debut;
            x2 = n.getPx();
            y2 = n.getPy();
        }
        if (b.debut instanceof NoeudAppui) {
            Point p = new Point(0, 0);
            p = coordonneNoeudAppui((NoeudAppui) b.debut);
            x1 = p.getPx();
            y1 = p.getPy();
        }
        if (b.fin instanceof NoeudAppui) {
            Point p = new Point(0, 0);
            p = coordonneNoeudAppui((NoeudAppui) b.fin);
            x2 = p.getPx();
            y2 = p.getPy();
        }

        double res;
        res = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return res;
    }



    public static void main(String[] args) {
    

    }
    
}
