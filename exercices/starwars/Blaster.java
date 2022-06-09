package starwars;

public class Blaster extends Weapon {
	
	private int cadence;
	
	public Blaster(String n, int p, int c) {
		super(n, p);
		this.cadence=c;
	}
	
	public int getCadence() {
		return this.cadence;
	}
	
	public String toString() {
		return "Nom : "+super.getNom()+" Puissance : "+super.getPuissance()+"Cadence : "+this.getCadence();
	}
}
