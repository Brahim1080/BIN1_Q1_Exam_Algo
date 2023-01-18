
/**
 * Represente une grille de Sudoku d'une taille (presque) quelconque
 *
 * @author Abid Brahim					--> A REMPLIR
 */
public class SudokuGeneral {

    private final int tailleCote;
    private final int tailleRegion;
    private final int[][] grille; // Les case non remplies sont representees par des 0

    /**
     * Constructeur utilise pour les tests.
     * prend la reference de la table passee en parametre
     * Il deduit egalement la taille des cotes du carre ainsi que la
     * taille des cotes des regions.
     * Notez que la taille des cotes correspond au nombre de symboles
     * differents que l'on utilise dans la grille
     * <p>
     * NE PAS MODIFIER, utilise pour les tests
     *
     * @param grille grille qui sera recopiee.
     *               <p>
     *               Preconditions: le tableau grille doit etre un carre et la racine carree
     *               de la taille du cote doit etre un nombre entier (ex: 9, 16, 25, 36, ...)
     *               Ce constructeur ne verifie pas ces preconditions, on suppose qu'elles sont correctes.
     */
    public SudokuGeneral(int[][] grille) {
        this.tailleCote = grille.length;
        this.tailleRegion = (int) Math.sqrt(tailleCote);
        this.grille = grille;
    }


    /**
     * Verifie que si l'on met le nombre 'nombre' a la position i, j
     * La grille de sudoku reste legale.
     * Cela doit se faire sans parcourir toute la grille!
     *
     * @param i      ligne du coup. Les lignes sont numerotees a partir de 0
     * @param j      colonne du coup. Les colonnes sont numerotees a partir de 0
     * @param nombre nombre que l'on veut placer dans la grille
     * @return true si le coup est legal (voir enonce), false sinon
     */
    public boolean isCoupLegal(int i, int j, int nombre) {

        // Verifie que la ligne ne contient pas deja le nombre
        if (isNombreDansLigne(i, nombre))
            return false;

        // Verifie que la colonne j ne contient pas deja le nombre
        if (isNombreDansColonne(j, nombre))
            return false;

        // Verifie que la region ne contient pas le nombre

        // Trouver le coin superieur gauche de la region
        int coinI = (i / tailleRegion) * tailleRegion;
        int coinJ = (j / tailleRegion) * tailleRegion; // Division entiere ex (4/3)*3 = 3

        return !isNombreDansRegion(nombre, coinI, coinJ);
    }

    /**
     * Verifie si le nombre 'nombre' est present dans la region dont le
     * coin superieur gauche se trouve a la position coinI, coinJ
     * Vous ne devez pas verifier que coinI et coinJ sont valides.
     *
     * @param nombre
     * @param coinI  numero de ligne du coin superieur gauche de la region
     * @param coinJ  numero de colonne du coin superieur gauche de la region
     * @return true si le nombre est dans la region
     */
    private boolean isNombreDansRegion(int nombre, int coinI, int coinJ) {

        for (int i = coinI; i <  coinI + tailleRegion; i++) {

            for (int j = coinJ; j < coinJ + tailleRegion; j++) {
                if (nombre == grille[i][j]) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Verifie si le nombre 'nombre' est present dans la colonne numero j
     * Vous ne devez pas verifier que j est valide
     *
     * @param j
     * @param nombre
     * @return true si le nombre est present
     */
    private boolean isNombreDansColonne(int j, int nombre) {

        for (int i = 0; i < grille.length; i++) {
            if (grille[i][j] == nombre)
                return true;

        }

        return false;
    }

    /**
     * Verifie si le nombre 'nombre' est present dans la ligne numero i
     * Vous ne devez pas verifier que i est valide
     *
     * @param i
     * @param nombre
     * @return true si le nombre est present
     */
    private boolean isNombreDansLigne(int i, int nombre) {
        for (int j = 0; j < grille.length ; j++) {
            if (grille[i][j]==nombre)
                return true;
        }
        return false;
    }

    /**
     * Renvoie le chiffre different de 0 le plus present au sein de la grille.
     * S'il n'y a que des 0 dans la grille, on renvoie un zero.
     * En cas d'ex aequo, on renvoie n'importe lequel des vainqueurs.
     *
     * @return
     */
    public int nombreLePlusPresent() {

        int[] tableComptage = new int[grille.length+1];

        //remplissage de la table de comptage
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length ; j++) {

                if (grille[i][j] != 0 ){
                    tableComptage[grille[i][j]]++;
                }

            }

        }
        int max = 0;
        for (int i = 1; i < tableComptage.length ; i++) {
            if (tableComptage[i]>tableComptage[max])
                //regarde quelle nombre est present et non combien de fois il est present { tableComptage[i]=max }
                max = i;
        }

        return max;
    }


}
