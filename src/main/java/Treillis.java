
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
public class Treillis {

    private List<Noeud> ensembleNoeud;
    private List<Barre> ensembleBarre;
    private Catalogue catalogue;
    private Terrain terrain;

    public Treillis(List<Noeud> ensembleNoeud, List<Barre> ensembleBarre, Catalogue catalogue, Terrain terrain) {
        this.ensembleNoeud = ensembleNoeud;
        this.ensembleBarre = ensembleBarre;
        this.catalogue = catalogue;
        this.terrain = terrain;
    }

    /**
     * initialisation d'un Treillis vide
     */
    public Treillis() {
        /*this.ensembleNoeud = new ArrayList<Noeud>();
        this.ensembleBarre = new ArrayList<Barre>();
        this.terrain = new Terrain(0, 0, 0, 0);
        this.catalogue = new Catalogue();*/

    }

    /**
     * @return the ensembleNoeud
     */
    public List<Noeud> getEnsembleNoeud() {
        return ensembleNoeud;
    }

    /**
     * @param ensembleNoeud the ensembleNoeud to set
     */
    public void setEnsembleNoeud(List<Noeud> ensembleNoeud) {
        this.ensembleNoeud = ensembleNoeud;
    }

    /**
     * @return the ensembleBarre
     */
    public List<Barre> getEnsembleBarre() {
        return ensembleBarre;
    }

    /**
     * @param ensembleBarre the ensembleBarre to set
     */
    public void setEnsembleBarre(List<Barre> ensembleBarre) {
        this.ensembleBarre = ensembleBarre;
    }

    /**
     * @return the catalogue
     */
    public Catalogue getCatalogue() {
        return catalogue;
    }

    /**
     * @return the terrain
     */
    public Terrain getTerrain() {
        return terrain;
    }

    public String toStringTreillis() {
        String res;
        res = "Treillis appartenant au terrain : {" + this.terrain + "}\n" + this.catalogue.toStringCatalogue() + "\n Contient les noeuds : { \n";
        for (int i = 0; i < this.getEnsembleNoeud().size(); i++) {
            res = res + this.getEnsembleNoeud().get(i).toStringNoeud() + "\n";
        }
        res = res + "Constitué des barres : { \n";
        for (int i = 0; i < this.getEnsembleBarre().size(); i++) {
            res = res + this.getEnsembleBarre().get(i).toStringBarre() + "\n";

        }
        return res + "}";
    }

    public Treillis treillisTest() {
        Point p1  =new Point(5,5);
        Point p2  =new Point(6,6);
        Point p3  =new Point(7,7);
        TriangleTerrain tt1 = new TriangleTerrain(1,p1,p2,p3);
        List<TriangleTerrain> trianglesterrains = new ArrayList<TriangleTerrain>();
        trianglesterrains.add(tt1);
        Terrain terrain1 = new Terrain(10, 10, 0, 0,trianglesterrains);//Terrain sans list de triangle terrain
        NoeudSimple noeud1 = new NoeudSimple(5, 5, 1);
        NoeudSimple noeud2 = new NoeudSimple(6, 6, 2);
        List<Noeud> noeuds = new ArrayList<Noeud>();
        noeuds.add(noeud2);
        noeuds.add(noeud1);
        TypeBarre t1 = new TypeBarre(1, 2, 3, 5, 6, 6);
        TypeBarre t2 = new TypeBarre(2, 2, 3, 5, 6, 6);

        List<TypeBarre> typesbarres = new ArrayList<TypeBarre>();
        typesbarres.add(t1);
        typesbarres.add(t2);
        Catalogue catalogue = new Catalogue(typesbarres);
        Barre barre1 = new Barre(1, noeud1, noeud2, t1);
        List<Barre> barres = new ArrayList<Barre>();
        barres.add(barre1);
        Treillis res = new Treillis(noeuds, barres, catalogue, terrain1);
        return res;
    }

    public NoeudSimple demandeNoeudSimple() {
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonné : ");
        double y = Lire.d();
        NoeudSimple res = new NoeudSimple(x, y, 1);// à modifier attention identifiant
        return res;
    }

    public Noeud choisiNoeud() {
        List<Noeud> noeudTreillis = new ArrayList<>();
        System.out.println("Liste des noeuds disponibles : ");
        int nbr = 0;
        for (int i = 0; i < this.getEnsembleNoeud().size(); i++) {
            Noeud n = this.ensembleNoeud.get(i);
            if (n instanceof Noeud) {
                nbr++;
                noeudTreillis.add((Noeud) n);
                System.out.println(nbr + ")" + n.toStringNoeud());
            }
        }
        if (nbr == 0) {
            System.out.println("Aucun noeud disponible");
            return null;
        } else {
            int rep = -1;
            while (rep < 0 || rep > nbr) {
                System.out.println("votre choix (0 pour annuler) : ");
                rep = Lire.i();
            }
            if (rep == 0) {
                return null;
            } else {
                return noeudTreillis.get(rep - 1);
            }
        }

    }

    public TypeBarre choisiTypeBarre() {
        List<TypeBarre> typesBarres = new ArrayList<>();
        System.out.println("Liste des types de barre disponible : ");
        int nbr = 0;
        for (int i = 0; i < this.getCatalogue().getTypeBarre().size(); i++) {
            TypeBarre n = this.catalogue.getTypeBarre().get(i);
            if (n instanceof TypeBarre) {
                nbr++;
                typesBarres.add((TypeBarre) n);
                System.out.println(nbr + ")" + n.toStringTypeBarre());
            }
        }
        /*if (nbr == 0) {
            System.out.println("Aucun noeud disponible");
            return null;
        } else {*/
        int rep = -1;
        while (rep < 0 || rep > nbr) {
            System.out.println("votre choix (0 pour annuler) : ");
            rep = Lire.i();
        }
        if (rep == 0) {
            return null;
        } else {
            return typesBarres.get(rep - 1);
        }
    }

    public Barre creationBarre() {

        Noeud noeudDebut;
        Noeud noeudFin;
        TypeBarre tBarre;
        System.out.println("Choix du premier noeud : \n");
        noeudDebut = this.choisiNoeud();
        System.out.println("Choix du second noeud (différent du premier) : \n");
        noeudFin = this.choisiNoeud();
        System.out.println("Choix du type de barre");
        tBarre = this.choisiTypeBarre();
        Barre res = new Barre(1, noeudDebut, noeudFin, tBarre);
        return res;
    }

    public Point demandePoint() {
        Point p1;
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonné : ");
        double y = Lire.d();
        Point res = new Point(x, y);// à modifier attention identifiant
        return res;
    }

    public TriangleTerrain creationTriangleTerrainAPartirDeRien() {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        System.out.println("Il faut 3 points pour créer un triangle terrain, ces points seront reliés par des segments ");
        System.out.println("Donner le premier point : ");
        p1.demandePoint();
        System.out.println("Donner le second point : ");
        p2.demandePoint();
        System.out.println("Donner le troisième point : ");
        p3.demandePoint();
        SegmentTerrain s1 = new SegmentTerrain(p1, p2);
        SegmentTerrain s2 = new SegmentTerrain(p2, p3);
        SegmentTerrain s3 = new SegmentTerrain(p3, p1);
        TriangleTerrain res = new TriangleTerrain(1, p1, p2, p3, s1, s2, s3);
        return res;

    }

    public TriangleTerrain choixTriangleTerrain() {
        List<TriangleTerrain> trianglesterrains = new ArrayList<>();
        System.out.println("Liste des triangles terrains : ");
        int nbr = 0;
        for (int i = 0; i < this.terrain.getListTriangleTerrain().size(); i++) {
            TriangleTerrain t = this.terrain.getListTriangleTerrain().get(i);
            if (t instanceof TriangleTerrain) {
                nbr++;
                trianglesterrains.add((TriangleTerrain) t);
                System.out.println(nbr + ")" + t.toStringTriangleTerrain());
            }
        }
        if (nbr == 0) {
            System.out.println("Aucun triangle terrain disponible");
            return null;
        } else {
            int rep = -1;
            while (rep < 0 || rep > nbr) {
                System.out.println("votre choix (0 pour annuler) : ");
                rep = Lire.i();
            }
            if (rep == 0) {
                return null;
            } else {
                return trianglesterrains.get(rep - 1);
            }
        }
    }

    public static Point choixPointTriangleTerrain(TriangleTerrain tt) {
        Point res = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        p1 = tt.getPoint0();
        p2 = tt.getPoint1();
        p3 = tt.getPoint2();
        System.out.println("Liste des points disponible sur ce triangle terrain : ");
        int nbr = 0;
        Point i = new Point();
        nbr = 1;
        System.out.println(nbr + ")" + p1.toStringPoint());
        nbr = 2;
        System.out.println(nbr + ")" + p2.toStringPoint());
        nbr = 3;
        System.out.println(nbr + ")" + p3.toStringPoint());
        if (nbr == 0) {
            System.out.println("Aucun triangle terrain disponible");
            return null;
        }
        int rep = -1;
        System.out.println("votre choix (0 pour annuler) : ");
        rep = Lire.i();
        if (rep == 0) {
            return null;
        } else if(rep == 1){
            return p1;
        }
        else if(rep == 2){
            return p2;
        }
        else if(rep == 3){
            return p3;
        }
        else{
            return null;
        }
    }

    public TriangleTerrain creationTriangleTerrainTriangleDejaExistant() {
        TriangleTerrain t1 = new TriangleTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point ();
        System.out.println("Choisir le triangle terrain sur lequel vous voulez contruire le nouveau triangle terrain : ");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choisir le premier point auquel vous voulez lier le triangle terrain : ");
        p1 = choixPointTriangleTerrain(t1);
        System.out.println("Choisir le second point auquel vous voulez lier le triangle terrain (différent du premier point) : ");
        p2 = choixPointTriangleTerrain(t1);
        System.out.println("Donner le troisième point");
        p3 = this.demandePoint();
        SegmentTerrain s1 = new SegmentTerrain(p1,p2);
        SegmentTerrain s2 = new SegmentTerrain(p2,p3);
        SegmentTerrain s3 = new SegmentTerrain(p3,p1);
        TriangleTerrain res = new TriangleTerrain(1,p1,p2,p3,s1,s2,s3);
        return res;
    }
    
    public SegmentTerrain choixSegmentTerrain(TriangleTerrain tt){
        SegmentTerrain res = new SegmentTerrain();
        SegmentTerrain t1 =  new SegmentTerrain ();
        SegmentTerrain t2 =  new SegmentTerrain ();
        SegmentTerrain t3 =  new SegmentTerrain ();
        t1 = tt.getSegment0();
        t2 = tt.getSegment1();
        t3 = tt.getSegment2();
        System.out.println("Liste des segments de terrain disponible sur ce triangle terrain : ");
        int nbr = 0;
        nbr = 1;
        System.out.println(nbr + ")" + t1.toStringSegmentTerrain());
        nbr = 2;
        System.out.println(nbr + ")" + t2.toStringSegmentTerrain());
        nbr = 3;
        System.out.println(nbr + ")" + t3.toStringSegmentTerrain());
        if (nbr == 0) {
            System.out.println("Aucun segments de  terrain disponible");
            return null;
        }
        int rep = -1;
        System.out.println("votre choix (0 pour annuler) : ");
        rep = Lire.i();
        if (rep == 0) {
            return null;
        } else if(rep == 1){
            return t1;
        }
        else if(rep == 2){
            return t2;
        }
        else if(rep == 3){
            return t3;
        }
        else{
            return null;
        }
        
    }
    
    public static Point choixPointSurSegment(SegmentTerrain segmentterrain){
        Point res = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        p1 = segmentterrain.getDebut();
        p2 = segmentterrain.getFin();
        System.out.println("Liste des points disponible, choisir un point : ");
        int nbr = 0;
        nbr = 1;
        System.out.println(nbr + ")" + p1.toStringPoint());
        nbr = 2;
        System.out.println(nbr + ")" + p2.toStringPoint());
        if (nbr == 0) {
            System.out.println("Aucun points disponible");
            return null;
        }
        int rep = -1;
        System.out.println("votre choix (0 pour annuler) : ");
        rep = Lire.i();
        if (rep == 0) {
            return null;
        } else if(rep == 1){
            return p1;
        }
        else if(rep == 2){
            return p2;
        }
        else{
            return null;
        }
        
    }
    
    
    
    public NoeudAppuiSimple creationNoeudAppuiSimple(){
        TriangleTerrain t1 = new TriangleTerrain();
        SegmentTerrain s1 = new SegmentTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        double alpha;
        System.out.println("Choisir le triangle terrain pour fixer le noeud appui simple");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choix du segment de terrain : ");
        s1 = choixSegmentTerrain(t1);
        System.out.println("Choix du point de départ : ");
        p1 = choixPointSurSegment(s1);
        System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : "); 
        alpha = Lire.d();
        NoeudAppuiSimple res = new NoeudAppuiSimple(0, alpha, t1, 0);// attention choix numéro premier point segment terrain
        return res;
    }
    
    public NoeudAppuiDouble creationNoeudAppuiDouble(){
        TriangleTerrain t1 = new TriangleTerrain();
        SegmentTerrain s1 = new SegmentTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        double alpha;
        System.out.println("Choisir le triangle terrain pour fixer le noeud appui simple");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choix du segment de terrain : ");
        s1 = choixSegmentTerrain(t1);
        System.out.println("Choix du point de départ : ");
        p1 = choixPointSurSegment(s1);
        System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : "); 
        alpha = Lire.d();
        NoeudAppuiDouble res = new NoeudAppuiDouble(0, alpha, t1, 0);// attention choix numéro premier point segment terrain
        return res;
    }

    public void menuTexte() {
        int rep = -1;
        while (rep != 0) {
            System.out.println("1) Afficher la composition du treillis");
            System.out.println("2) Ajouter un noeud simple");
            System.out.println("3) Ajouter une barre");
            System.out.println("4) Ajouter un nouveau triangle terrain");
            System.out.println("5) Ajouter un nouveau triangle à partir d'unt triangle terrain existant");
            System.out.println("6) Ajouter un noeud appui simple");
            System.out.println("7) Ajouter un noeud appui double");
            rep = Lire.i();
            if (rep == 1) {
                System.out.println(this);
            }/*else if (rep == 2){
                NoeudSimple ns = 
            }*/


        }
    }

    public static void main(String[] args) {
        Treillis t1 = new Treillis();
        //t1.treillisTest().choisiNoeud();
        //t1.treillisTest().choisiTypeBarre();
        t1.treillisTest().creationNoeudAppuiDouble();
        System.out.println("hello world");
        System.out.println("hello world 2");
    }

}
