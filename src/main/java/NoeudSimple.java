/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class NoeudSimple extends Noeud {
    
    private double abs;
    private double ord;
    
    public NoeudSimple(double abs, double ord, int id){
        super(id);
        this.abs = abs;
        this.ord = ord;
        
    }

    /**
     * @return the abs
     */
    public double getAbs() {
        return abs;
    }

    /**
     * @param abs the abs to set
     */
    public void setAbs(double abs) {
        this.abs = abs;
    }

    /**
     * @return the ord
     */
    public double getOrd() {
        return ord;
    }

    /**
     * @param ord the ord to set
     */
    public void setOrd(double ord) {
        this.ord = ord;
    }
    
    public String toStringNoeud(){
        String res = "identifiant : "+this.getId()+"\n"+"("+this.abs+","+this.ord+")";
        return res;
    }
    
}
