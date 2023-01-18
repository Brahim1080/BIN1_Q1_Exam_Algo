
public class Classe {
	private static final int TAILLE = 50;
	private Eleve [] classe;
	private int nombreDEleves; // Taille logique
	
	/**
	 * Construit un objet de type classe en allouant 
	 * un tableau contenant TAILLE élèves.
	 */
	public Classe(){
		// TODO A compléter
		int [] classe = new int[TAILLE];
	}
	
	/**
	 * Ajoute un élève de la façon décrite dans l'énoncé
	 * 
	 * @param eleve
	 * @return false s'il n'y a plus de place dans le tableau, true sinon
	 */
	public boolean ajoutEleve(Eleve eleve){

		if (nombreDEleves== classe.length)
			return false;

		classe[nombreDEleves] = eleve;

		return true;
	}
	
	/**
	 * Renvoie un tableau d'élèves dont l'année de naissance est l'année
	 * la moins représentée dans la classe.
	 * En cas d'égalité entre deux année, on renvoie les élève appartenant à
	 * l'année la plus ancienne.
	 * L'année choisie doit au moins avoir un élève la représentant dans la classe
	 * 
	 * On supposera que tous les élèves sont nés au 20ème ou 21ème siècle
	 * (il n'y a donc que 200 valeurs différentes possibles).
	 * @return les élèves dont l'année de naissance est l'année
	 * la moins représentée dans la classe.
	 * S'il n'y a pas d'élève dans la classe, on renverra un tableau 
	 * de taille 0.
	 */
	Eleve [] elevesDELAnneeLaMoinsPresente(){
		// TODO A compléter
				
		return null;
	}

	@Override
	public String toString() {
		String texte = "Classe";

		for (int i = 0; i < nombreDEleves; i++) {
			texte += "\n"+ classe[i];
		}

		return texte ;
	}
	
	
}
