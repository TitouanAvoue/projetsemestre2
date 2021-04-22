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
    
    public SegmentTerrain(){
        Point p1 = new Point(0,0);
        Point p2 =new Point(0,0);
        this.debut = p1;
        this.fin = p2;
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
        String res = "["+this.debut.toStringPoint()+","+this.fin.toStringPoint()+"]";
        return res;
    }
    
    public double longueurSegment(){
        double x1 = this.debut.getPx();
        double x2 = this.fin.getPx();
        double y1 = this.debut.getPx();
        double y2 = this.fin.getPx();
        double res = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
        return res;
    }
}
