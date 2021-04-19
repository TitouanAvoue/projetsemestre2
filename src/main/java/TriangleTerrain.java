

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
    private Point point0;
    private Point point1;
    private Point point2;
    private SegmentTerrain segment0;
    private SegmentTerrain segment1;
    private SegmentTerrain segment2;

    public TriangleTerrain(int id, Point point0, Point point1, Point point2, SegmentTerrain segment0, SegmentTerrain segment1, SegmentTerrain segment2) {
        this.id = id;
        this.point0 = point0;
        this.point1 = point1;
        this.point2 = point2;
        this.segment0 = segment0;
        this.segment1 = segment1;
        this.segment2 = segment2;

    }

    public TriangleTerrain(int id, Point point0, Point point1, Point point2) {
        this.id = id;
        this.point0 = point0;
        this.point1 = point1;
        this.point2 = point2;
        SegmentTerrain s1 = new SegmentTerrain(point0, point1);
        SegmentTerrain s2 = new SegmentTerrain(point1, point2);
        SegmentTerrain s3 = new SegmentTerrain(point2, point0);
        this.segment0 = s1;
        this.segment1 = s2;
        this.segment2 = s3;
    }

    public TriangleTerrain() {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        SegmentTerrain s1 = new SegmentTerrain();
        SegmentTerrain s2 = new SegmentTerrain();
        SegmentTerrain s3 = new SegmentTerrain();
        this.id = 0;
        this.point0 = p1;
        this.point1 = p2;
        this.point2 = p3;
        this.segment0 = s1;
        this.segment1 = s2;
        this.segment2 = s2;

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
    public SegmentTerrain getSegment0() {
        return segment0;
    }

    /**
     * @param segment0 the segment1 to set
     */
    public void setSegment0(SegmentTerrain segment0) {
        this.segment0 = segment0;
    }

    /**
     * @return the segment2
     */
    public SegmentTerrain getSegment1() {
        return segment1;
    }

    /**
     * @param segment1 the segment2 to set
     */
    public void setSegment1(SegmentTerrain segment1) {
        this.segment1 = segment1;
    }

    /**
     * @return the segment3
     */
    public SegmentTerrain getSegment2() {
        return segment2;
    }

    /**
     * @param segment2 the segment3 to set
     */
    public void setSegment2(SegmentTerrain segment2) {
        this.segment2 = segment2;
    }

    public String toStringTriangleTerrain() {
        String res;
        res = "TriangleTerrain " + this.id + " composé de : " + segment0.toStringSegmentTerrain() + "," + segment1.toStringSegmentTerrain() + "," + segment2.toStringSegmentTerrain();
        return res;
    }

    /**
     * @return the point0
     */
    public Point getPoint0() {
        return point0;
    }

    /**
     * @param point0 the point0 to set
     */
    public void setPoint0(Point point0) {
        this.point0 = point0;
    }

    /**
     * @return the point1
     */
    public Point getPoint1() {
        return point1;
    }

    /**
     * @param point1 the point1 to set
     */
    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    /**
     * @return the point2
     */
    public Point getPoint2() {
        return point2;
    }

    /**
     * @param point2 the point2 to set
     */
    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

}
