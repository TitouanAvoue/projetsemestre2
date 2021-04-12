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
    public double getPx() {
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
    public double getPy() {
        return ord;
    }

    /**
     * @param ord the ord to set
     */
    public void setOrd(double ord) {
        this.ord = ord;
    }
    
    public String toStringNoeud(){
        String res = "";
        res =  "identifiant : "+this.getId()+"\n"+"("+this.abs+","+this.ord+")";
        return res;
    }
    public void testaff(){
        System.out.println(this.toStringNoeud());
    }
    
   
    
    public static void main(String[] args) {
         NoeudSimple noeud1 = new NoeudSimple(5, 5, 1);
         noeud1.testaff();
    }
    
}
