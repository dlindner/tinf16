package de.dhbw.tinf16bx.functional;

import java.util.HashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Stream;

import de.dhbw.tinf16bx.functional.book.creation.CreatePlayground;
import de.dhbw.tinf16bx.functional.book.model.Book;
import de.dhbw.tinf16bx.functional.book.model.Chapter;

public class Main {

	private static final Random random = new Random(132L);
	private static final int amountOfBooks = 100;

	public static void main(String[] args) {
		final List<Book> allBooks = CreatePlayground.withBooks(amountOfBooks, random);
		
		Set<Book> uniqueBooks = new HashSet<>();
		final Consumer<Book> thing = uniqueBooks::add;
		final BiConsumer<Set<Book>, Book> otherThing =
				Set::add;
		final BiConsumer<Chapter, Chapter> addition = 
				//Chapter::add;
				(Chapter c1, Chapter c2) -> {
					c1.add(c2);
				};
		
		sort(allBooks, thing);
		
		
		OptionalDouble words = averagePagesOfChaptersFrom(allBooks);
//				.map(Author::name)
//				.distinct()
//				.count();
				//.filter(name -> name.startsWith("R"))
				//.forEach(System.out::println);
		System.out.println(words);
		//allBooks.forEach(System.out::println);
	}
//	public static void main(String[] args) {
//		final Random random = new Random();
//		final Supplier<Integer> naechsteZahl = new Supplier<Integer>() {
//			@Override
//			public Integer get() {
//				Integer result = random.nextInt();
//				System.out.println(result);
//				return result;
//			}
//		};
//		
//		Stream<Integer> zahlen = Stream.generate(naechsteZahl).limit(0);
//		IntStream reallyZahlen = zahlen.mapToInt(Integer::intValue);
//		OptionalDouble maybe = reallyZahlen.average();
//		
//		maybe.ifPresent(
//				value -> System.out.println("Mittelwert: " + value));
//	}

	private static void sort(final List<Book> allBooks, final Consumer<Book> thing) {
		for (Book each : allBooks) {
			thing.accept(each);
		}
	}

	private static OptionalDouble averagePagesOfChaptersFrom(final List<Book> allBooks) {
		return chaptersOf(allBooks.stream())
				.mapToInt(Chapter::pages)
				.average();
	}
	
	private static Stream<Chapter> chaptersOf(Stream<Book> books) {
		return books.map(Book::content)
				    .flatMap(List::stream);
	}
}
