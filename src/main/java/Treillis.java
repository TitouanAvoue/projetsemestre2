
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
        res = "Treillis appartenant au terrain : {" + this.terrain.toStringTerrain() + "}\n" + this.catalogue.toStringCatalogue() + "\n Contient les noeuds : { \n";
        for (int i = 0; i < this.getEnsembleNoeud().size(); i++) {
            res = res + this.getEnsembleNoeud().get(i).toStringNoeud() + "\n";
        }
        res = res + "Constitu?? des barres : { \n";
        for (int i = 0; i < this.getEnsembleBarre().size(); i++) {
            res = res + this.getEnsembleBarre().get(i).toStringBarre() + "\n";

        }
        return res + "}";
    }

    public Treillis treillisTest() {
        Point p1 = new Point(1, 1, 0);
        Point p2 = new Point(4, 4, 1);
        Point p3 = new Point(4, 1, 2);
        TriangleTerrain tt1 = new TriangleTerrain(1, p1, p2, p3);
        List<TriangleTerrain> trianglesterrains = new ArrayList<TriangleTerrain>();
        trianglesterrains.add(tt1);
        Terrain terrain1 = new Terrain(10, 0, 10, 0, trianglesterrains);//Terrain sans list de triangle terrain
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
        while (x < this.terrain.getXmin() || x > this.terrain.getXmax()) {
            System.out.println("Donner une nouvelle abcisse pour ??tre dans la zone constructible : ");
            x = Lire.d();
        }
        System.out.println("ordonn?? : ");
        double y = Lire.d();
        while (y < this.terrain.getXmin() || y > this.terrain.getXmax()) {
            System.out.println("Donner une nouvelle ordonn??e pour ??tre dans la zone constructible : ");
            y = Lire.d();
        }
        Point p = new Point(x,y);
        
        if(estDansTriangleTerrain(p) == true){
            System.out.println("Construction du noeud simple impossible car dans triangle terrain ");
            return null;
            
        }else{
            NoeudSimple res = new NoeudSimple(x,y,1);
            return res;
        }
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
        System.out.println("Choix du second noeud (diff??rent du premier) : \n");
        noeudFin = this.choisiNoeud();
        System.out.println("Choix du type de barre");
        tBarre = this.choisiTypeBarre();
        Barre res = new Barre(1, noeudDebut, noeudFin, tBarre);
        double l = longueurBarre(res);
        while (l < tBarre.getLmin() || l > tBarre.getLmax() || l == -1) {
            System.out.println("La longueur de la barre ne correspond pas ?? la longueur de ce type de barre, choisir a nouveau taper (-1 pour quitter) ");
            if (Lire.i() == -1) {
                return null;
            } else {
                System.out.println("Choix du premier noeud : \n");
                noeudDebut = this.choisiNoeud();
                System.out.println("Choix du second noeud (diff??rent du premier) : \n");
                noeudFin = this.choisiNoeud();
                System.out.println("Choix du type de barre");
                tBarre = this.choisiTypeBarre();
              
            }

        }
        return res;
    }

    

    public Point demandePoint() {
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonn?? : ");
        double y = Lire.d();
        System.out.println("Num??ro du point (0 ou 1 ou 2)");
        int num = Lire.i();
        Point res = new Point(x, y, num);
        return res;
    }

    public Point demandePointTriangleTerrainDejaExistant() {
        System.out.println("abcisse : ");
        double x = Lire.d();
        System.out.println("ordonn?? : ");
        double y = Lire.d();
        Point res = new Point(x, y, 0);// ?? modifier attention identifiant
        return res;
    }

    public TriangleTerrain creationTriangleTerrainAPartirDeRien() {
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        System.out.println("Il faut 3 points pour cr??er un triangle terrain, ces points seront reli??s par des segments ");
        System.out.println("Donner le premier point : ");
        p1 = p1.demandePoint();
        int num1 = p1.getNum();
        //System.out.println(num1);
        while (num1 < 0 || num1 > 2) {
            System.out.println("Donner un num correct");
            num1 = Lire.i();
        }
        p1.setNum(num1);
        System.out.println("Donner le second point (num diff??rent du premier) : ");
        p2 = p2.demandePoint();
        int num2 = p2.getNum();
        System.out.println(num2);
        while (num2 == p1.getNum()) {//num2 < 0 || num2 > 2
            System.out.println("Donner un num correct (diff??rent du premier et compris entre 0 et 2) :");
            num2 = Lire.i();
        }
        p2.setNum(num2);
        System.out.println("Donner le troisi??me point : ");
        p3 = p3.demandePointTriangleTerrainDejaExistant();
        int num3 = p3.getNum();
        if (p1.getNum() == 0) {
            if (p2.getNum() == 1) {
                num3 = 2;
            }
            if (p2.getNum() == 2) {
                num3 = 1;
            }
        }
        if (p1.getNum() == 1) {
            if (p2.getNum() == 0) {
                num3 = 2;
            }
            if (p2.getNum() == 2) {
                num3 = 0;
            }
        }
        if (p1.getNum() == 2) {
            if (p2.getNum() == 1) {
                num3 = 0;
            }
            if (p2.getNum() == 0) {
                num3 = 1;
            }
        }
        if (p2.getNum() == 0) {
            if (p1.getNum() == 1) {
                num3 = 2;
            }
            if (p1.getNum() == 2) {
                num3 = 1;
            }
        }
        if (p2.getNum() == 1) {
            if (p1.getNum() == 0) {
                num3 = 2;
            }
            if (p1.getNum() == 2) {
                num3 = 0;
            }
        }
        if (p2.getNum() == 2) {
            if (p1.getNum() == 1) {
                num3 = 0;
            }
            if (p1.getNum() == 0) {
                num3 = 1;
            }
        }
        p3.setNum(num3);
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
        } else if (rep == 1) {
            return p1;
        } else if (rep == 2) {
            return p2;
        } else if (rep == 3) {
            return p3;
        } else {
            return null;
        }
    }

    public TriangleTerrain creationTriangleTerrainTriangleDejaExistant() {
        TriangleTerrain t1 = new TriangleTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        System.out.println("Choisir le triangle terrain sur lequel vous voulez contruire le nouveau triangle terrain : ");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choisir le premier point auquel vous voulez lier le triangle terrain : ");
        p1 = choixPointTriangleTerrain(t1);
        System.out.println("Num??ro du point (compris entre 0 et 2) : ");
        int num1 = Lire.i();
        while (num1 < 0 || num1 > 2) {
            System.out.println("Donner un num??ro compris entre 0 et 2 :");
            num1 = Lire.i();
        }
        p1.setNum(num1);
        System.out.println("Choisir le second point auquel vous voulez lier le triangle terrain (diff??rent du premier point) : ");
        p2 = choixPointTriangleTerrain(t1);
        System.out.println("Num??ro du point ( entre 0 et 2, et diff??rent du premier num) : ");
        int num2 = Lire.i();
        while (num2 < 0 || num2 > 2 || num2 == num1) {
            System.out.println("Donner un num??ro compris entre 0 et 2 ( diff??rent du premier num??ro) :");
            num2 = Lire.i();
        }
        p2.setNum(num2);
        System.out.println("Donner le troisi??me point : ");
        p3 = this.demandePointTriangleTerrainDejaExistant();
        int num3 = p3.getNum();
        if (p1.getNum() == 0) {
            if (p2.getNum() == 1) {
                num3 = 2;
            }
            if (p2.getNum() == 2) {
                num3 = 1;
            }
        }
        if (p1.getNum() == 1) {
            if (p2.getNum() == 0) {
                num3 = 2;
            }
            if (p2.getNum() == 2) {
                num3 = 0;
            }
        }
        if (p1.getNum() == 2) {
            if (p2.getNum() == 1) {
                num3 = 0;
            }
            if (p2.getNum() == 0) {
                num3 = 1;
            }
        }
        if (p2.getNum() == 0) {
            if (p1.getNum() == 1) {
                num3 = 2;
            }
            if (p1.getNum() == 2) {
                num3 = 1;
            }
        }
        if (p2.getNum() == 1) {
            if (p1.getNum() == 0) {
                num3 = 2;
            }
            if (p1.getNum() == 2) {
                num3 = 0;
            }
        }
        if (p2.getNum() == 2) {
            if (p1.getNum() == 1) {
                num3 = 0;
            }
            if (p1.getNum() == 0) {
                num3 = 1;
            }
        }
        p3.setNum(num3);
        SegmentTerrain s1 = new SegmentTerrain(p1, p2);
        SegmentTerrain s2 = new SegmentTerrain(p2, p3);
        SegmentTerrain s3 = new SegmentTerrain(p3, p1);
        TriangleTerrain res = new TriangleTerrain(1, p1, p2, p3, s1, s2, s3);
        return res;
    }

    public SegmentTerrain choixSegmentTerrain(TriangleTerrain tt) {
        SegmentTerrain res = new SegmentTerrain();
        SegmentTerrain t1 = new SegmentTerrain();
        SegmentTerrain t2 = new SegmentTerrain();
        SegmentTerrain t3 = new SegmentTerrain();
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
        } else if (rep == 1) {
            return t1;
        } else if (rep == 2) {
            return t2;
        } else if (rep == 3) {
            return t3;
        } else {
            return null;
        }

    }

    public static Point choixPointSurSegment(SegmentTerrain segmentterrain) {
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
        } else if (rep == 1) {
            return p1;
        } else if (rep == 2) {
            return p2;
        } else {
            return null;
        }

    }

    /*public Point coordonneNoeudAppui(Point debut){
        
    }*/
    public NoeudAppuiSimple creationNoeudAppuiSimple() {
        TriangleTerrain t1 = new TriangleTerrain();
        SegmentTerrain s1 = new SegmentTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        double alpha;
        System.out.println("Choisir le triangle terrain pour fixer le noeud appui simple");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choix du segment de terrain : ");
        s1 = choixSegmentTerrain(t1);
        System.out.println("Choix du point de d??part : ");
        p1 = choixPointSurSegment(s1);
        System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : ");
        alpha = Lire.d();
        while (alpha < 0 || alpha > 1) {
            System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : ");
            alpha = Lire.d();
        }
        NoeudAppuiSimple res = new NoeudAppuiSimple(0, alpha, t1, p1.getNum());// attention choix num??ro premier point segment terrain
        Point p = new Point(0, 0);

        p = coordonneNoeudAppui(res);
        if (p.getPx() < this.terrain.getXmin() || p.getPx() > this.terrain.getXmax()) {
            System.out.println("Cr??ation noeud appui impossible (hors zone construction) ");
            return null;
        } else if (p.getPy() < this.terrain.getXmin() || p.getPy() > this.terrain.getXmax()) {
            System.out.println("Cr??ation noeud appui impossible (hors zone construction) ");
            return null;
        } else {
            return res;
        }
    }

    public NoeudAppuiDouble creationNoeudAppuiDouble() {
        TriangleTerrain t1 = new TriangleTerrain();
        SegmentTerrain s1 = new SegmentTerrain();
        Point p1 = new Point();
        Point p2 = new Point();
        double alpha;
        System.out.println("Choisir le triangle terrain pour fixer le noeud appui simple");
        t1 = this.choixTriangleTerrain();
        System.out.println("Choix du segment de terrain : ");
        s1 = choixSegmentTerrain(t1);
        System.out.println("Choix du point de d??part : ");
        p1 = choixPointSurSegment(s1);
        System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : ");
        alpha = Lire.d();
        while (alpha < 0 || alpha > 1) {
            System.out.println("Donner la position du noeud sur le segment terrain (double: 0<= alpha <= 1) : ");
            alpha = Lire.d();
        }
        NoeudAppuiDouble res = new NoeudAppuiDouble(0, alpha, t1, 0);// attention choix num??ro premier point segment terrain
        Point p = new Point(0, 0);
        p = coordonneNoeudAppui(res);
        double x;
        double y;
        if (p.getPx() < this.terrain.getXmin() || p.getPx() > this.terrain.getXmax()) {
            System.out.println("Cr??ation noeud appui impossible (hors zone construction) ");
            return null;
        } else if (p.getPy() < this.terrain.getXmin() || p.getPy() > this.terrain.getXmax()) {
            System.out.println("Cr??ation noeud appui impossible (hors zone construction) ");
            return null;
        } else {
            return res;
        }
    }

    public void menuTexte() {
        int rep = -1;
        while (rep != 0) {
            System.out.println("1) Afficher la composition du treillis");
            System.out.println("2) Ajouter un noeud simple");
            System.out.println("3) Ajouter une barre");
            System.out.println("4) Ajouter un nouveau triangle terrain");
            System.out.println("5) Ajouter un nouveau triangle ?? partir d'unt triangle terrain existant");
            System.out.println("6) Ajouter un noeud appui simple");
            System.out.println("7) Ajouter un noeud appui double");
            System.out.println("8) V??rifier si un point est dans un triangle");
            System.out.println("0) Quitter");
            System.out.println("Votre choix : ");
            rep = Lire.i();
            if (rep == 1) {
                System.out.println(this.toStringTreillis());
            } else if (rep == 2) {
                NoeudSimple ns = new NoeudSimple();
                ns = this.demandeNoeudSimple();
                this.ensembleNoeud.add(ns);
            } else if (rep == 3) {
                Barre b = new Barre();
                b = this.creationBarre();
                this.ensembleBarre.add(b);
            } else if (rep == 4) {
                TriangleTerrain tt = new TriangleTerrain();
                tt = this.creationTriangleTerrainAPartirDeRien();
                this.terrain.getListTriangleTerrain().add(tt);
            } else if (rep == 5) {
                TriangleTerrain tt = new TriangleTerrain();
                tt = this.creationTriangleTerrainTriangleDejaExistant();
                this.terrain.getListTriangleTerrain().add(tt);
            } else if (rep == 6) {
                NoeudAppuiSimple nas = new NoeudAppuiSimple();
                nas = this.creationNoeudAppuiSimple();
                this.ensembleNoeud.add(nas);
            } else if (rep == 7) {
                NoeudAppuiDouble nad = new NoeudAppuiDouble();
                nad = this.creationNoeudAppuiDouble();
                this.ensembleNoeud.add(nad);
            }

        }
    }

    public static Point coordonnePremierPointSegmentTerrain(NoeudAppui noeudappui) {
        TriangleTerrain tt = new TriangleTerrain();
        tt = noeudappui.getTriangleterrain();
        int num = noeudappui.getPremierptsegterr();
        int num0 = tt.getPoint0().getNum();
        int num1 = tt.getPoint1().getNum();
        int num2 = tt.getPoint2().getNum();
        Point p0 = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        p0 = tt.getPoint0();
        p1 = tt.getPoint1();
        p2 = tt.getPoint2();

        if (num == num0) {
            return p0;
        } else if (num == num1) {
            return p1;
        } else if (num == num2) {
            return p2;
        } else {
            return null;
        }

    }

    public static Point coordonneSecondPointSegmentTerrain(NoeudAppui na) {
        Point p = new Point();
        p = coordonnePremierPointSegmentTerrain(na);

        int numpt1 = p.getNum();

        int numpt2 = ((numpt1 + 1) % 3);

        TriangleTerrain tt = new TriangleTerrain();
        tt = na.getTriangleterrain();
        int num0 = tt.getPoint0().getNum();
        int num1 = tt.getPoint1().getNum();
        int num2 = tt.getPoint2().getNum();
        Point p0 = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        p0 = tt.getPoint0();
        p1 = tt.getPoint1();
        p2 = tt.getPoint2();

        if (num0 == numpt2 || num0 != numpt1) {
            return p0;
        } else if (num1 == numpt2 || num1 != numpt1) {
            return p1;
        } else if (num2 == numpt2 || num2 != numpt1) {
            return p2;
        } else {
            return null;
        }
    }

    public static Point coordonneNoeudAppui(NoeudAppui na) {
        double alpha = na.getAlpha();
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        p1 = coordonnePremierPointSegmentTerrain(na);
        p2 = coordonneSecondPointSegmentTerrain(na);
        double abs = (alpha * p1.getPx() + (1 - alpha) * p2.getPx());
        double ord = (alpha * p1.getPy() + (1 - alpha) * p2.getPy());
        Point res = new Point(abs, ord);
        return res;
    }

    public static double longueurBarre(Barre b) {
        double x1 = 0;
        double x2 = 0;
        double y1 = 0;
        double y2 = 0;

        if (b.getDebut() instanceof NoeudSimple) {
            NoeudSimple n = new NoeudSimple();
            n = ((NoeudSimple) b.getDebut());
            x1 = n.getPx();
            y1 = n.getPy();
        }
        if (b.getFin() instanceof NoeudSimple) {
            NoeudSimple n = new NoeudSimple();
            n = ((NoeudSimple) b.getFin());
            x2 = n.getPx();
            y2 = n.getPy();
        }
        if (b.getDebut() instanceof NoeudAppui) {
            Point p = new Point(0, 0);
            p = coordonneNoeudAppui((NoeudAppui) b.getDebut());
            x1 = p.getPx();
            y1 = p.getPy();
        }
        if (b.getFin() instanceof NoeudAppui) {
            Point p = new Point(0, 0);
            p = coordonneNoeudAppui((NoeudAppui) b.getFin());
            x2 = p.getPx();
            y2 = p.getPy();
        }

        double res;
        res = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return res;
    }
    
    public static Point calculVecteur(Point p1, Point p2){
        double abs;
        double ord;
        abs = p2.getPx() - p1.getPx();
        ord = p2.getPy() - p1.getPy();
        Point res = new Point(abs,ord);
        return res;
    }
    
    public static double produitScalaire(Point p1,Point p2){
        double res = p1.getPx()*p2.getPx() + p1.getPy()*p2.getPy();
        return res;
    }
    
    public static Point recupPoint0(TriangleTerrain tt){
        
        Point res = new Point();
        if(tt.getPoint0().getNum() == 0){
            res = tt.getPoint0();
        }if(tt.getPoint1().getNum() == 0){
            res = tt.getPoint1();
        }if(tt.getPoint2().getNum() == 0){
            res = tt.getPoint2();
        }
        
        return res;
        
    }
    
    public static Point recupPoint1(TriangleTerrain tt){
        
        Point res = new Point();
        if(tt.getPoint0().getNum() == 1){
            res = tt.getPoint0();
        }if(tt.getPoint1().getNum() == 1){
            res = tt.getPoint1();
        }if(tt.getPoint2().getNum() == 1){
            res = tt.getPoint2();
        }
        
        return res;
        
    }
    
    public static Point recupPoint2(TriangleTerrain tt){
        Point res = new Point();
        if(tt.getPoint0().getNum() == 2){
            res = tt.getPoint0();
        }if(tt.getPoint1().getNum() == 2){
            res = tt.getPoint1();
        }if(tt.getPoint2().getNum() == 2){
            res = tt.getPoint2();
        }
        
        return res;
        
    }
    
    public static double normeVecteur(Point vecteur){
        double res = Math.sqrt(vecteur.getPx()*vecteur.getPx() + vecteur.getPy()*vecteur.getPy());
        return res;
    }
    
    
    public static double angleAlpha(double produitscalaire, double normevect1, double normevect2){
        double res;
        res = Math.acos(produitscalaire/(normevect1*normevect2));
        return res;
    }
    
    
    public boolean estDansTriangleTerrain(Point p){
        TriangleTerrain tt = new TriangleTerrain();
        Point p0 = new Point();
        Point p1 = new Point();
        Point p2 = new Point();
        Point vecteur1 = new Point();
        Point vecteur2 = new Point();
        Point vecteur3 = new Point();
        Point vecteur4 = new Point();
        Point vecteur5 = new Point();
        Point vecteur6 = new Point();
        double alpha1;
        double alpha2;
        double alpha3;
        double alp1;        
        double produitscalaire1;
        double normevect1;
        double normevect2;
        double produitscalaire2;
        double normevect3;
        double normevect4;
        double produitscalaire3;
        double normevect5;
        double normevect6;
        int nbr = 0;//permet de savoir si ds triangle terrain
        
        for (int i = 0; i < this.terrain.getListTriangleTerrain().size(); i++) {
            tt = this.terrain.getListTriangleTerrain().get(i);
            p0 = recupPoint0(tt);
            p1 = recupPoint1(tt);
            p2 = recupPoint2(tt);
            vecteur1 = calculVecteur(p0,p1);
            vecteur2 = calculVecteur(p0,p);
            produitscalaire1 = produitScalaire(vecteur1,vecteur2);
            normevect1 = normeVecteur(vecteur1);
            normevect2 = normeVecteur(vecteur2);
            alpha1 = angleAlpha(produitscalaire1,normevect1,normevect2);
            
            vecteur3 = calculVecteur(p1,p2);
            vecteur4 = calculVecteur(p1,p);
            produitscalaire2 = produitScalaire(vecteur3,vecteur4);
            normevect3 = normeVecteur(vecteur3);
            normevect4 = normeVecteur(vecteur4);
            alpha2 = angleAlpha(produitscalaire2,normevect3,normevect4);
            
            vecteur5 = calculVecteur(p2,p0);
            vecteur6 = calculVecteur(p2,p);
            produitscalaire3 = produitScalaire(vecteur5,vecteur6);
            normevect5 = normeVecteur(vecteur5);
            normevect6 = normeVecteur(vecteur6);
            alpha3 = angleAlpha(produitscalaire3,normevect5,normevect6);
            
            
            
            int temp1 = 0;
            if ((alpha1 % 2*Math.PI) > 0 && (alpha1 % 2*Math.PI) < Math.PI  ){
                temp1 = temp1+1;
            }
            if((alpha2 % 2*Math.PI) > 0 && (alpha2 % 2*Math.PI) < Math.PI  ){
                temp1 = temp1+1;
            }
             if((alpha3 % 2*Math.PI) > 0 && (alpha3 % 2*Math.PI) < Math.PI  ){
                temp1 = temp1+1;
            }
             int temp2 = 0;
            
             if ((alpha1 % 2*Math.PI) > Math.PI && (alpha1 % 2*Math.PI) < 2*Math.PI  ){
                temp2 = temp2+1;
            }
             if ((alpha2 % 2*Math.PI) > Math.PI && (alpha2 % 2*Math.PI) < 2*Math.PI  ){
                temp2 = temp2+1;
            }
             if ((alpha2 % 2*Math.PI) > Math.PI && (alpha2 % 2*Math.PI) < 2*Math.PI  ){
                temp2 = temp2+1;
            }
             if(temp1 == 3 || temp2 == 3){
                 nbr = nbr+1;
             }
        }
        
        if(nbr >= 1){
            return true;
            
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Treillis t1 = new Treillis();
        //t1.treillisTest().choisiNoeud();
        //t1.treillisTest().choisiTypeBarre();
        t1.treillisTest().menuTexte();
        //NoeudSimple noeud1 = new NoeudSimple(5, 5, 1);
        //NoeudSimple noeud2 = new NoeudSimple(6, 6, 2);
        //Barre b = new Barre(2,noeud1,noeud2);
        //System.out.println(longueurBarre(b));
        System.out.println("ggg");

        
    }

}
