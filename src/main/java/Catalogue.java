
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
    private List<TypeBarre> contient;
    
    public Catalogue(){
        this.contient = new ArrayList<TypeBarre>();
    }
    
    
    
    public String toStringCatalogue(){
        String res = "Catalogue {\n";
        for(int i = 0; i < this.getContient().size(); i++){
            res = res + this.getContient().get(i).toStringTypeBarre();
        }
        return res +"}";
    }

    /**
     * @return the contient
     */
    public List<TypeBarre> getContient() {
        return contient;
    }
}
