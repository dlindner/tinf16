package de.dhbw.tinf16bx.railway;

import java.util.Optional;

public class Main {
	
	public static void main(String[] args) {
		//Optional<String> katzeInDerBox = Optional.of("Miau");
		Optional<String> katzeInDerBox = Optional.empty();

		katzeInDerBox.ifPresent(System.out::println);
		
		System.out.println(katzeInDerBox.orElse("nicht anwesend!"));
//		katzeInDerBox
//			.map(mapper)
//			.ifPresent(t -> System.out.println("Nicht anwesend!"));
	}

}
