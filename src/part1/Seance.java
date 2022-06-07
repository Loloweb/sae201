package part1;

import java.sql.Date;

public class Seance {
	
	private Date date;
	private String typeSeance;
	private Film monFilm;
	
	public Seance(Date d, String ts) {
		this.date=d;
		this.typeSeance=ts;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getTypeSeance() {
		return this.typeSeance;
	}
	
	public boolean equals(Seance s) {
		return (this.date.compareTo(s.date)==0 && this.typeSeance.compareTo(s.typeSeance)==0);
	}
	
	public void affecterFilm(Film f) {
		this.monFilm=f;
	}
}