
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
public class Catalogue {
    private List<TypeBarre> typeBarre;
    
    public Catalogue(List<TypeBarre> typeBarre){
        this.typeBarre = typeBarre;
    }
    
    public Catalogue(){
        this.typeBarre = new ArrayList<TypeBarre>();
    }
    
 
    
    public String toStringCatalogue(){
        String res = "Catalogue {";
        for(int i = 0; i < this.getTypeBarre().size(); i++){
            res = res +"\n"+ this.getTypeBarre().get(i).toStringTypeBarre();
        }
        return res +"}";
    }

    /**
     * @return the typeBarre
     */
    public List<TypeBarre> getTypeBarre() {
        return typeBarre;
    }
    
}
