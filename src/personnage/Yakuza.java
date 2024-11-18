package personnage;

public class Yakuza extends Humain {
	private String nomClan;
	private int pointReputation = 0;
	
	public Yakuza (String nom, String boissonFavorite, int nbArgent, String nomClan) {
		super(nom, boissonFavorite, nbArgent);
		this.nomClan = nomClan;
	}
	
	public int getPointReputation() {
		return this.pointReputation;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler( victime.getNom()+" si tu tiens à la vie donne moi ta bourse !");
		int vol = victime.seFaireExtorquer();
		int argt = getArgent();
		argt += vol;
		parler("J’ai piqué les "+ vol +" sous de "+ victime.getNom() +", ce qui me fait " + argt
		+" sous dans ma poche. Hi ! Hi !");
		pointReputation += 1;
		
	}
	
	public int perdre() {
		int argentYakuza = getArgent();
		perdreArgent(argentYakuza);
		this.pointReputation -= 1;
		parler("J’ai perdu mon duel et mes " + argentYakuza + " sous, snif... J'ai déshonoré le clan de "
				+ this.nomClan);
		return argentYakuza;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain); 
		this.pointReputation += 1;
		parler("Ce ronin pensait vraiment battre "+ this.getNom() + " du clan de "+ this.nomClan
				+ " ? Je l'ai dépouillé de ses " + gain + " sous");
	}
}
