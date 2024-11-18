package personnage;

public class Yakuza extends Humain {
	private String nomClan;
	private int pointReputation = 0;

	public Yakuza(String nom, String boissonFavorite, int nbArgent, String nomClan) {
		super(nom, boissonFavorite, nbArgent);
		this.nomClan = nomClan;
	}

	public int getPointReputation() {
		return pointReputation;
	}

	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + " si tu tiens à la vie donne moi ta bourse !");
		int argentVolle = victime.seFaireExtorquer();
		int argent = getArgent();
		argent += argentVolle;
		parler("J’ai piqué les " + argentVolle + " sous de " + victime.getNom() + ", ce qui me fait " + argent
				+ " sous dans ma poche. Hi ! Hi !");
		pointReputation += 1;

	}

	public int perdre() {
		int argentYakuza = getArgent();
		perdreArgent(argentYakuza);
		pointReputation--;
		parler("J’ai perdu mon duel et mes " + argentYakuza + " sous, snif... J'ai déshonoré le clan de " + nomClan);
		return argentYakuza;
	}

	public void gagner(int gain) {
		gagnerArgent(gain);
		pointReputation++;
		parler("Ce ronin pensait vraiment battre " + getNom() + " du clan de " + nomClan
				+ " ? Je l'ai dépouillé de ses " + gain + " sous");
	}
}
