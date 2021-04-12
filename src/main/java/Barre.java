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
        String res = "identifiant : " + this.id + "\n noeud debut \n " + this.debut.toStringNoeud() + "\n noeud fin \n" + this.fin.toStringNoeud() + " \n" + this.typeBarre.toStringTypeBarre();
        return res;
    }
    
    public double longueurBarre(){
        double x1 = this.debut.getPx();
        double x2 = this.fin.getPx();
        double y1 = this.debut.getPx();
        double y2 = this.fin.getPx();
        double res = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        return res;
        
    }
    
    public void testaffichebarre(){
        System.out.println(this.toStringBarre());
    }
    public void testaffichelongueur(){
        System.out.println(this.longueurBarre());
    }

    public static void main(String[] args) {
        NoeudSimple noeud1 = new NoeudSimple(5.0, 5.0, 1);
        NoeudSimple noeud2 = new NoeudSimple(6.0, 6.0, 2);
        TypeBarre acier = new TypeBarre(2, 5,4,6,78,89);
        Barre barre1 = new Barre(1,noeud1, noeud2, acier);
        barre1.testaffichebarre();
        barre1.testaffichelongueur();

    }
}
