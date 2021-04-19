
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
public abstract class NoeudAppui extends Noeud {
    
    private double alpha;
    private TriangleTerrain triangleterrain;
    private int premierptsegterr;
    
    
    public NoeudAppui(int id, double alpha, TriangleTerrain triangleterrain, int premierptsegterr){
        super(id);
        this.alpha = alpha;
        this.triangleterrain = triangleterrain;
        this.premierptsegterr = premierptsegterr;
        
    }
    
    public NoeudAppui(){
        super(0);
        TriangleTerrain tt = new TriangleTerrain();
        this.alpha = 0;
        this.triangleterrain = tt;
        this.premierptsegterr = 0;
        
    }
    

    /**
     * @return the alpha
     */
    public double getAlpha() {
        return alpha;
    }

    /**
     * @param alpha the alpha to set
     */
    public void setAlpha(double alpha) {
        this.alpha = alpha;
    }
    

    /**
     * @return the triangleterrain
     */
    public TriangleTerrain getTriangleterrain() {
        return triangleterrain;
    }

    /**
     * @return the premierptsegterr
     */
    public int getPremierptsegterr() {
        return premierptsegterr;
    }
    
      public String toStringNoeudAppui(){
        String res = "identifiant : "+this.getId()+"\n"+"alpha : "+this.alpha;
        return res;
    }
}
