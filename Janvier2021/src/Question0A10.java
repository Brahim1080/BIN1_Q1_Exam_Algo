import java.util.Arrays;
import java.util.NoSuchElementException;

public class Question0A10 {

    private String question;
    private int[] tableReponses;
    private int nbReponses;
    private static final int MAX = 10; //nombre max de reponses a conserver dans la table

    // A NE PAS CHANGER
    // VA SERVIR POUR LES TESTS
    public Question0A10(String question, int[] tableARecopier) {
        this.question = question;
        this.tableReponses = new int[MAX];
        for (int i = 0; i < tableARecopier.length; i++) {
            tableReponses[i] = tableARecopier[i];
        }
        this.nbReponses = tableARecopier.length;
    }

    /**
     * construit une question sans reponse
     *
     * @param question l'enonce de la question
     * @throws IllegalArgumentException si la question est null ou vide
     */
    public Question0A10(String question) {
        if (question == null || question.isEmpty())
            throw new IllegalArgumentException();
        tableReponses = new int[MAX];
        nbReponses = 0;
    }


    public int getNbReponses() {
        return nbReponses;
    }


    /**
     * calcule la moyenne des reponses
     *
     * @return la moyenne
     * @throws NoSuchElementException s'il n'y a pas de reponse
     */
    public double moyenne() {//TODO ok
        if (nbReponses == 0)
            throw new NoSuchElementException();

        double moyenne = 0;
        for (int i = 0; i < nbReponses; i++) {
            moyenne += tableReponses[i];
        }

        return moyenne / nbReponses;
    }


    /**
     * verifie si les entiers sont bien tous compris entre 0 et 10
     *
     * @param table la table a verifier
     * @return true si tous les entiers sont des reponses, false sinon
     * @throws IllegalArgumentException si la table est null
     */
    public static boolean contientReponses(int[] table) {//TODO ok
        if (table == null)
            throw new IllegalArgumentException();

        // cette methode est static! C'est la table passee en parametre qui est verifiee
        for (int i = 0; i < table.length; i++) {

            if (table[i] < 0 || table[i] > 10)
                return false;
        }

        return true;
    }


    /**
     * ajoute en fin de tableReponses, les reponses contenues dans la table passee en parametre
     * Ex : tableReponses 3 5 9 7 6 tableReponsesSupp 9 8 2 --> tableReponses 3 5 9 7 6 9 8 2
     * tableReponses ne peut contenir que MAX reponses
     * Il se peut donc que toutes les reponses ne soient pas ajoutees
     * Ex : (MAX = 10) tableReponses 1 2 3 4 5 6 7 tableReponsesSupp 1 2 3 4 5 --> tableReponses 1 2 3 4 5 6 7 1 2 3
     *
     * @param tableReponsesSupp la table avec des reponses supplementaires
     * @throws IllegalArgumentException si la table passee en parametre est null ou n'est pas une table qui contient des reponses
     */
    public void ajouterReponses(int[] tableReponsesSupp) { //TODO ?
        if (tableReponsesSupp == null) {
            throw new IllegalArgumentException();
        }
        if (!contientReponses(tableReponsesSupp)) {
            throw new IllegalArgumentException();
        }
        System.out.println(Arrays.toString(tableReponses));
        System.out.println(" taille max: " + tableReponses.length);
        System.out.println(" tableReponsesSupp max: " + tableReponsesSupp.length);
        int indice = 0;

        for (int i = nbReponses ; i < tableReponses.length ; i++) {
            if (indice == tableReponsesSupp.length)
                break;
            tableReponses[i] = tableReponsesSupp[indice];
            indice++;
            System.out.println("\nEtape "+ indice +Arrays.toString(tableReponses));
            nbReponses++;

        }
        System.out.println(Arrays.toString(tableReponses));


    }

    /**
     * construit une table de frequences a partir des reponses reprises dans tableReponses
     *
     * @return la table de frequences
     */
    public int[] tableFrequences() { //TODO ok
        int[] tableDeFrequence = new int[11];

        for (int i = 0; i < nbReponses; i++) {
            tableDeFrequence[tableReponses[i]]++;
        }
        return tableDeFrequence;
    }


    /**
     * recherche la mediane des reponses
     *
     * @return la mediane
     * @throws NoSuchElementException s'il n'y a pas de reponse
     */
    public int mediane() { //TODO ?

        if (nbReponses == 0)
            throw new NoSuchElementException();
        // CONTRAINTE : UTILISEZ L'ALGORITHME DECRIT DANS L'ENONCE

        //copie de tableReponse dans une table temporaire
        int[] tableRecopie = new int[tableReponses.length + 1];

        for (int i = 0; i < nbReponses; i++) {
            tableRecopie[i] = tableReponses[i];
        }

        int nbrEtape = (nbReponses / 2) + 1;

        int min = tableRecopie[0];
        int indiceMin = 0;

        System.out.println("nbrEtape = " + nbrEtape);

        for (int i = 0; i < nbrEtape; i++) {
            min = Integer.MAX_VALUE;
            for (int j = 0; j < nbReponses; j++) {

                if (tableRecopie[j] < min ){
                    indiceMin = j;
                    min = tableRecopie[j];
                }
            }
            tableRecopie[indiceMin]= 11;


        }


        System.out.println(Arrays.toString(tableRecopie));


        return min;
    }


    // A NE PAS CHANGER
    // VA SERVIR POUR LES TESTS
    public String toString() {
        String aRenvoyer = "" + question + " ";
        for (int i = 0; i < nbReponses; i++) {
            aRenvoyer += tableReponses[i] + " ";
        }
        return aRenvoyer;
    }


}
