package de.dhbw.tinf16bx.intro;

public class Toilette {
	
	public Toilette() {
		super();
	}
	
	public void benutztDurch(Student student) {
		System.out.println("TS2: Putzfrau bitte!");
	}
	
	public void benutztDurch(Konfirmant konfirmant) {
		System.out.println("TK2: OverflowError");
	}
	
	public void benutztDurch(Filmheldin filmheldin) {
		System.out.println("TF2: Cooles Plot-Device!");
	}
}
