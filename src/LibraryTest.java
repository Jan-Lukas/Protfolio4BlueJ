import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
	private Library out;
	private Book book;
	private Book secondBook;
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String BOOK_TITLE2 = "Harry Potter";

	@Before
	public void intializeTests() {

		out = new Library();
		book = new Book(BOOK_TITLE);
		secondBook = new Book(BOOK_TITLE2);

	}
	@Test
	public void addFirstBookTest() {
		out.addBook(book);
		assertEquals(1, out.books.size());
	}

	@Test
	public void addSecondBookTest() {
		out.addBook(book);
		out.addBook(secondBook);
		assertEquals(2, out.books.size());
	}

//Because of the missing opportunity to test System.out.println properly accross different plattforms, we won't test the function printListOfBooks.

}
