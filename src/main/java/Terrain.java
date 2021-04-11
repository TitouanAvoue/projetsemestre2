/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class Terrain {
    private double Xmin;
    private double Xmax;
    private double Ymin;
    private double Ymax;
    
    public Terrain(double Xmax, double Xmin, double Ymax, double Ymin){
        this.Xmax = Xmax;
        this.Xmin = Ymin;
        this.Ymax = Ymax;
        this.Ymin = Ymin;
        
    }
    
    public String toStringTerrain(){
        String res;
        res = "";
        res = "["+this.getXmin()+","+this.getYmin()+"]"+" "+"["+this.getXmax()+","+this.getYmax()+"]";
        return res;
    }

    /**
     * @return the Xmin
     */
    public double getXmin() {
        return Xmin;
    }

    /**
     * @return the Xmax
     */
    public double getXmax() {
        return Xmax;
    }

    /**
     * @return the Ymin
     */
    public double getYmin() {
        return Ymin;
    }

    /**
     * @return the Ymax
     */
    public double getYmax() {
        return Ymax;
    }
    
    
}
