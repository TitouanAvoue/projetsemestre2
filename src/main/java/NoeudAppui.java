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
    private 
    
    public NoeudAppui(double alpha, int id){
        super(id);
        this.alpha = alpha;
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
    public String toStringNoeudAppui(){
        String res = "identifiant : "+this.getId()+"\n"+"alpha : "+this.alpha;
        return res;
    }
    
}
