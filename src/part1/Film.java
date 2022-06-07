package part1;

public class Film {
	
	private String titre;
	private int duree;
	private String nationalite;
	private String resume;
	
	public Film(String t, int d, String n, String r) {
		this.titre=t;
		this.duree=d;
		this.nationalite=n;
		this.resume=r;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	public int getDuree() {
		return this.duree;
	}
	
	public String getNationalite() {
		return this.nationalite;
	}
	
	public String getResume() {
		return this.resume;
	}
	
	public boolean equals(Film f) {
		return (this.titre.compareTo(f.titre)==0 && this.duree!=f.duree && this.nationalite.compareTo(f.nationalite)==0 && this.resume.compareTo(f.resume)==0);
	}
	
	public void affiche() {
		System.out.println(getTitre());
		System.out.println("Film "+getNationalite()+" de "+getDuree()+" min");
		System.out.println("Resume : "+getResume());
	}

}
