package personnage;

public class Commercant extends Humain {

	private static final String BOISSON = "the";

	public Commercant(String nom, int nbArgent) {
		super(nom, BOISSON, nbArgent);
	}

	public int seFaireExtorquer() {
		int argent = getArgent();
		perdreArgent(argent);
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return argent;
	}

	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous! Je te remercie généreux donateur!");
	}

}