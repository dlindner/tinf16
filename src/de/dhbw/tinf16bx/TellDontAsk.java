package de.dhbw.tinf16bx;

import java.util.List;
import java.util.Random;

import de.dhbw.tinf16bx.functional.book.creation.CreateLibrary;
import de.dhbw.tinf16bx.functional.book.model.Book;

public class TellDontAsk {

	private static final Random random = new Random(132L);
	private static final int amountOfBooks = 100;

	public static void main(String[] args) {
		final List<Book> allBooks = CreateLibrary.withBooks(amountOfBooks, random);
		
		for (Book book : allBooks) {
			book.ifPages(
				pages -> pages > 500,
				b -> System.out.println(b.title() + " ist ein Wälzer"),
				b -> {}/*System.out.println(b.title() + " ist schnell gelesen")*/
			);
		}
	}

}
