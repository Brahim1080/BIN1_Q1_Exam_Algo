
public class Classe {
	private static final int TAILLE = 50;
	private Eleve [] classe;
	private int nombreDEleves; // Taille logique
	
	/**
	 * Construit un objet de type classe en allouant 
	 * un tableau contenant TAILLE �l�ves.
	 */
	public Classe(){
		// TODO A compl�ter
		int [] classe = new int[TAILLE];
	}
	
	/**
	 * Ajoute un �l�ve de la fa�on d�crite dans l'�nonc�
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
	 * Renvoie un tableau d'�l�ves dont l'ann�e de naissance est l'ann�e
	 * la moins repr�sent�e dans la classe.
	 * En cas d'�galit� entre deux ann�e, on renvoie les �l�ve appartenant �
	 * l'ann�e la plus ancienne.
	 * L'ann�e choisie doit au moins avoir un �l�ve la repr�sentant dans la classe
	 * 
	 * On supposera que tous les �l�ves sont n�s au 20�me ou 21�me si�cle
	 * (il n'y a donc que 200 valeurs diff�rentes possibles).
	 * @return les �l�ves dont l'ann�e de naissance est l'ann�e
	 * la moins repr�sent�e dans la classe.
	 * S'il n'y a pas d'�l�ve dans la classe, on renverra un tableau 
	 * de taille 0.
	 */
	Eleve [] elevesDELAnneeLaMoinsPresente(){
		// TODO A compl�ter
				
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
