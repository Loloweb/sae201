package sujet2;

public class Adresse {
	
	private int num;
	private String rue;
	private String ville;
	private String code_postal;

	public Adresse(int n, String r, String v, String cheesepizza) {
		this.num=n;
		this.rue=r;
		this.ville=v;
		this.code_postal=cheesepizza;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public String getRue() {
		return this.rue;
	}
	
	public String getVille() {
		return this.ville;
	}
	
	public String getCodePostal() {
		return this.code_postal;
	}
	
	public void afficher() {
		System.out.println(getNum()+" "+getRue()+ ", "+getCodePostal()+" "+getVille());
	}
}
