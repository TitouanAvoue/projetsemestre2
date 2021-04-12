
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
public class TriangleTerrain {
    private int id;
    private SegmentTerrain segment1;
    private SegmentTerrain segment2;
    private SegmentTerrain segment3;
    
    
    public TriangleTerrain(int id,SegmentTerrain segment1, SegmentTerrain segment2, SegmentTerrain segment3){
        this.id = id;
        this.segment1 = segment1;
        this.segment2 = segment2;
        this.segment3 = segment3;
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the segment1
     */
    public SegmentTerrain getSegment1() {
        return segment1;
    }

    /**
     * @param segment1 the segment1 to set
     */
    public void setSegment1(SegmentTerrain segment1) {
        this.segment1 = segment1;
    }

    /**
     * @return the segment2
     */
    public SegmentTerrain getSegment2() {
        return segment2;
    }

    /**
     * @param segment2 the segment2 to set
     */
    public void setSegment2(SegmentTerrain segment2) {
        this.segment2 = segment2;
    }

    /**
     * @return the segment3
     */
    public SegmentTerrain getSegment3() {
        return segment3;
    }

    /**
     * @param segment3 the segment3 to set
     */
    public void setSegment3(SegmentTerrain segment3) {
        this.segment3 = segment3;
    }
    
    
}
