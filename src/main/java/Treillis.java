
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author titou
 */
public class Treillis {

    private List<Noeud> ensembleNoeud;
    private List<Barre> ensembleBarre;
    private Catalogue catalogue;
    private Terrain terrain;

    public Treillis(List<Noeud> ensembleNoeud, List<Barre> ensembleBarre, Catalogue catalogue, Terrain terrain) {
        this.ensembleNoeud = ensembleNoeud;
        this.ensembleBarre = ensembleBarre;
        this.catalogue = catalogue;
        this.terrain = terrain;
    }

    /**
     * initialisation d'un Treillis vide
     */
    public Treillis() {
        this.ensembleNoeud = new ArrayList<Noeud>();
        this.ensembleBarre = new ArrayList<Barre>();
        this.terrain = new Terrain(50, 0, 50, 0);
        this.catalogue = new Catalogue();

    }

    /**
     * @return the ensembleNoeud
     */
    public List<Noeud> getEnsembleNoeud() {
        return ensembleNoeud;
    }

    /**
     * @param ensembleNoeud the ensembleNoeud to set
     */
    public void setEnsembleNoeud(List<Noeud> ensembleNoeud) {
        this.ensembleNoeud = ensembleNoeud;
    }

    /**
     * @return the ensembleBarre
     */
    public List<Barre> getEnsembleBarre() {
        return ensembleBarre;
    }

    /**
     * @param ensembleBarre the ensembleBarre to set
     */
    public void setEnsembleBarre(List<Barre> ensembleBarre) {
        this.ensembleBarre = ensembleBarre;
    }

    /**
     * @return the catalogue
     */
    public Catalogue getCatalogue() {
        return catalogue;
    }

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    public String toStringTreillis() {
        String res;
        res = "Treillis appartenant au terrain : " + this.terrain + "\n" + "le catalogue : " + this.catalogue + "\n contient les noeuds : \n";
        for (int i = 0; i < this.getEnsembleNoeud().size(); i++) {
            res = res + this.getEnsembleNoeud().get(i).toStringNoeud() + "\n";
        }
        for (int i = 0; i < this.getEnsembleBarre().size(); i++) {
            res = res + this.getEnsembleBarre().get(i).toStringBarre() + "\n";
        }
        return res;
    }
        
       
    
    
    

    public static void main(String[] args){
        System.out.println("hello");

    }

}
