/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author titou
 */
public class TypeBarre {
    private int id;
    private double cout;
    private double lmin;
    private double lmax;
    private double tmax;
    private double cmax;
    
    
    public TypeBarre(int id, double cout, double lmin, double lmax, double tmax, double cmax){
        this.id = id;
        this.cout = cout;
        this.lmin = lmin;
        this.lmax = lmax;
        this.tmax = tmax;
        this.cmax = cmax;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the cout
     */
    public double getCout() {
        return cout;
    }

    /**
     * @return the lmin
     */
    public double getLmin() {
        return lmin;
    }

    /**
     * @return the lmax
     */
    public double getLmax() {
        return lmax;
    }

    /**
     * @return the tmax
     */
    public double getTmax() {
        return tmax;
    }

    /**
     * @return the cmax
     */
    public double getCmax() {
        return cmax;
    }
    
    public String toStringTypeBarre(){
        String res = "Type Barre {\n";
        res = res+ "cout : "+this.cout+"\n"+"lmin : "+this.lmin+"\n"+"lmax : "+this.lmax+"\n"+"tmax : "+this.tmax+"\n"+"cmax : "+this.cmax+"}";
        return res;
    }
    
    
    
}
