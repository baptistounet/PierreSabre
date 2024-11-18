package personnage;

public class Humain {
	private String nom;
	private String boissonFav;
	private int nbArgent;
	protected int nbConnaissance = 0;
	private Humain[] connaissance = new Humain[30];

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
			parler("J ai " + nbArgent + " sous en poche. Je vais pouvoir m offrir " + bien + " à " + prix + " sous.");
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
		nbArgent += gain;
		return nbArgent;
	}

	public int perdreArgent(int perte) {
		if ((nbArgent - perte) > 0) {
			nbArgent -= perte;
			return nbArgent;
		}
		return 0;
	}

	public void direBonjour() {
		parler("Bonjour ! je m'appelle " + nom + " et j aime boire du " + boissonFav);
	}

	public void repondre(Humain homme1) {
		direBonjour();
		if (nbConnaissance < 30) {
			memoriser(homme1);
		}
	}

	public void memoriser(Humain homme1) {
		connaissance[nbConnaissance] = homme1;
		nbConnaissance++;
	}

	public void faireConnaissanceAvec(Humain autreHumain) {
		direBonjour();
		autreHumain.repondre(this);
		if (nbConnaissance < 30) {
			memoriser(autreHumain);
		}
	}

	public void listerConnaissance() {
		StringBuilder bld = new StringBuilder();
		bld.append("Je connais beaucoup de monde dont :");
		for (int i = 0; i < nbConnaissance-1; i++) {
			bld.append(connaissance[i].getNom() + ", ");
		}
		bld.append(connaissance[nbConnaissance-1].getNom());
		parler(bld.toString());
	}
	
	public static void main(String[] argv) {
		Humain paul = new Humain("Paul", "Cognac", 300);
		paul.direBonjour();
	}

}