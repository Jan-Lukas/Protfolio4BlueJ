import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Test class for Client.java
 * @author Dominik Schween, Jan-Lukas Weimann
 * @version 17.09.2018
 *
 */
public class ClientTest {

	private Client out;
	private Library library;
	private Book book;
	private Book secondBook;
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String BOOK_TITLE2 = "Harry Potter";
	private static final String CATEGORY_CRIME = "crime";
	private static final String CLIENT_ADDRESS = "Reeperbahn 69";
	private static final String CLIENT_NAME = "Walter Krüger";
	private static final String AUTHOR_BOOK = "J.R.R. Tolkien";
	private static final String AUTHOR_BOOK2 = "J.K. Rowling";
	private static final String CLIENT_NAME2 = "Max Mustermann";
	private static final String CLIENT_ADDRESS2 = "Reeperbahn 70";

	@Before
	public void intializeTests() {

		out = new Client(CLIENT_NAME, CLIENT_ADDRESS);
		library = new Library();
		book = new Book(BOOK_TITLE, AUTHOR_BOOK);
		secondBook = new Book(BOOK_TITLE2, AUTHOR_BOOK2);

	}

	@Test
	public void addOneClientTest() {

		out.addToLibrary(library);

		assertEquals(true, library.clients.contains(out));
	}

	@Test
	public void addTwoClientsTest() {
		Client out2 = new Client(CLIENT_ADDRESS2, CLIENT_ADDRESS2);
		Library library = new Library();
		out.addToLibrary(library);
		out2.addToLibrary(library);

		assertEquals(true, library.clients.contains(out));
		assertEquals(true, library.clients.contains(out2));
	}

	@Test
	public void addTheSameClientTwiceTest() {

		out.addToLibrary(library);
		out.addToLibrary(library);
		assertEquals(2, library.clients.size());
	}

	@Test
	public void returnBookTest() {
		out.addToLibrary(library);
		book.addAndBorrowBook(library, out);
		out.returnBook(BOOK_TITLE);
		assertEquals(false, out.borrowedBooks.contains(book));
	}

	@Test
	public void returnOneOfTwoBooksTest() {
		out.addToLibrary(library);
		book.addAndBorrowBook(library, out);
		secondBook.addAndBorrowBook(library, out);

		out.returnBook(BOOK_TITLE);
		assertEquals(false, out.borrowedBooks.contains(book));
		assertEquals(true, out.borrowedBooks.contains(secondBook));

	}

	@Test
	public void negativeIsFavoriteCategoryTest() {
		assertEquals(false, out.isFavoriteCategory(CATEGORY_CRIME));
	}

	@Test
	public void positiveIsFavoriteCategoryTest() {

		out.favoriteCategories.add(CATEGORY_CRIME);
		assertEquals(true, out.isFavoriteCategory(CATEGORY_CRIME));
	}

}
