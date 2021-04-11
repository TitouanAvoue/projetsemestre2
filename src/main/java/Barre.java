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
    
    public Barre(int id, Noeud debut, Noeud fin, TypeBarre typeBarre){
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
    
    public String toStringBarre(){
        String res = "identifiant : "+this.id+", noeud debut "+this.debut+" ,noeud fin "+this.fin+" de type : "+this.typeBarre;
        return res;
    }
}
