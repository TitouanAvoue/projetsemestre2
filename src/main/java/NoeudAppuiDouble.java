/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class NoeudAppuiDouble extends NoeudAppui {
    
    
    public NoeudAppuiDouble(double alpha, int id){
        super(alpha, id);
    }
    
    public String toStringNoeud(){
        String res = "alpha : "+this.getAlpha()+", identificateur : "+this.getId();
        return res;
    }
    
}
