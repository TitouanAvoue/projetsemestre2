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
    
    
    public NoeudAppuiDouble(int id, double alpha,TriangleTerrain triangleterrain, int premierptsegterr){
        super(id,alpha,triangleterrain,premierptsegterr);
        
       
    }
    
    
    public String toStringNoeud(){
        String res = "identificateur : "+this.getId()+", alpha : "+this.getAlpha()+", triangle terrain : "+"premier point du segment de terrain : "+this.getPremierptsegterr();
        return res;
    }
    
}
