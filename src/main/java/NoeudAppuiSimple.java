
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
public class NoeudAppuiSimple extends NoeudAppui {
    
    public NoeudAppuiSimple(int id, double alpha,TriangleTerrain triangleterrain, int premierptsegterr){
        super(id,alpha,triangleterrain,premierptsegterr);
        
       
    }
      public NoeudAppuiSimple(){
        super();
        
       
    }
    
    
    
    public String toStringNoeud(){
        String res = "identificateur : "+this.getId()+", alpha : "+this.getAlpha()+", triangle terrain : "+"premier point du segment de terrain : "+this.getPremierptsegterr();
        return res;
    }
    
}
