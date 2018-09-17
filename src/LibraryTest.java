import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
/**
 * Test class for Library.java
 * @author Dominik Schween, Jan-Lukas Weimann
 * @version 17.09.2018
 *
 */
public class LibraryTest {
	private Library out;
	private Book book;
	private Book secondBook;
	private Client client;
	private Client client2;
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String BOOK_TITLE2 = "Harry Potter";
	private static final String AUTHOR_BOOK = "J.R.R. Tolkien";
	private static final String AUTHOR_BOOK2 = "J.K. Rowling";
	private static final String CLIENT_ADDRESS = "Reeperbahn 69";
	private static final String CLIENT_NAME = "Walter Krüger";
	private static final String CLIENT_ADDRESS2 = "Reeperbahn 70";
	private static final String CLIENT_NAME2 = "Otto Hermann";

	@Before
	public void intializeTests() {

		out = new Library();
		book = new Book(BOOK_TITLE, AUTHOR_BOOK);
		secondBook = new Book(BOOK_TITLE2, AUTHOR_BOOK2);
		client = new Client(CLIENT_NAME, CLIENT_ADDRESS);
		client2 = new Client(CLIENT_NAME2, CLIENT_ADDRESS2);

	}

	@Test
	public void addFirstBookTest() {
		out.addBook(book);
		assertEquals(true, out.books.contains(book));
	}

	@Test
	public void addTwoBooksTest() {
		out.addBook(book);
		out.addBook(secondBook);
		
		assertEquals(true, out.books.contains(book));
		assertEquals(true, out.books.contains(secondBook));
	}

	@Test
	public void bookBorrowedByTwoClientsTest() {
		client.addToLibrary(out);
		client2.addToLibrary(out);
		book.addAndBorrowBook(out, client);
		book.addAndBorrowBook(out, client2);
		
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));
	}
	
	@Test
	public void bookBorrowedByOneClientTest() {
		client.addToLibrary(out);
		client2.addToLibrary(out);
		book.addAndBorrowBook(out, client);
		
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));
		
	}
	@Test
	public void bookBorrowedByNoneTest() {
		client.addToLibrary(out);
		book.addAndBorrowBook(out, client);
		
		assertEquals(0, out.bookBorrowedBy(BOOK_TITLE2).size());
		
	}

	// Because of the missing opportunity to test System.out.println properly
	// accross different plattforms, we don't test the function
	// printListOfBooks.

}
