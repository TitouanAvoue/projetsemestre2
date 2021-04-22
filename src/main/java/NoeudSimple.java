
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
public class NoeudSimple extends Noeud {
    
     private double abs;
    private double ord;
    
    public NoeudSimple(double abs, double ord, int id){
        super(id);
        this.abs = abs;
        this.ord = ord;
        
    }
    public NoeudSimple(){
        super(0);
        this.abs = 0;
        this.ord = 0;
        
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
        res =  "identifiant : "+this.getId()+" , "+"("+this.abs+","+this.ord+")";
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
