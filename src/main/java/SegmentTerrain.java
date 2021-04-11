/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class SegmentTerrain {
    private Point debut;
    private Point fin;
    
    public SegmentTerrain(Point debut, Point fin){
        this.debut = debut;
        this.fin = fin;
    }

    /**
     * @return the debut
     */
    public Point getDebut() {
        return debut;
    }

    /**
     * @return the fin
     */
    public Point getFin() {
        return fin;
    }
    
    public String toStringSegmentTerrain(){
        String res = "["+this.debut+","+this.fin+"]";
        return res;
    }
    
}
