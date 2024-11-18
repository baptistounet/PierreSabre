package personnage;

public class Humain {
	private String nom;
	private String boissonFav;
	private int nbArgent;
	private

	public Humain(String nom, String boissonFavorite, int nbArgent) {
		this.nom = nom;
		this.boissonFav = boissonFavorite;
		this.nbArgent = nbArgent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return nbArgent;
	}

	protected void parler(String texte) {
		System.out.println("L'HUMAIN " + nom + " : " + texte);
	}

	public void boire() {
		parler("Mmm,  un bon verre de " + boissonFav + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (nbArgent > prix) {
			parler("J ai " + nbArgent + " sous en poche. Je vais pouvoir m offrir " + bien +" à " + prix + " sous.");
			perdreArgent(prix);
			if (bien != null && bien.equals("une boisson")) {
				boire();
				}
		} else {
			parler("J n'ai plus que " + nbArgent + " sous en poche. Je ne  peux  meme pas m'offrir " + bien + " à "
					+ prix + " sous.");
		}
	}

	public int gagnerArgent(int gain) {
		return nbArgent += gain;
	}

	public int perdreArgent(int perte) {
		if ((nbArgent - perte) > 0) {
			return nbArgent -= perte;
		}
		return 0;
	}

	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + nom + " et j aime boire du " + boissonFav);
	}
	
	public void repondre(Humain homme1) {
		direBonjour();
		memoriser(homme1);
	}
	
	public void memoriser(Humain homme1) {
		
	}
	
	public void voidfaireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		repondre(this);
		memoriser(autreHumain);
	}

	public static void main(String[] argv) {
		Humain paul = new Humain("Paul", "Cognac", 300);
		paul.direBonjour();
	}

}