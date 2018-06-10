package de.dhbw.tinf16bx.intro;

import java.util.Arrays;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		final Konfirmant sebbie = new Konfirmant();
		final Filmheldin sidhr = new Filmheldin();
		sebbie.harndrang();
		sidhr.harndrang();
		
		final List<Student> alleStudenten = Arrays.asList(
				sebbie,
				sidhr);
		alleStudenten.forEach(Student::harndrang);
		
		final Toilette wc = new Toilette();
		wc.benutztDurch(sebbie);
		wc.benutztDurch(sidhr);
		alleStudenten.forEach(wc::benutztDurch);
	}
}
