import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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

		assertEquals(out, library.clients.get(0));
	}

	// The name "out" doesn't make sense, because this method should be in
	// library
	@Test
	public void addTwoClientsTest() {
		Client out2 = new Client("Mark", "Hagebuttenstraße 85");
		Library library = new Library();
		out.addToLibrary(library);
		out2.addToLibrary(library);

		assertEquals(out, library.clients.get(0));
		assertEquals(out2, library.clients.get(1));
	}

	// addToLibrary shouldn't add the same client twice
	@Test
	public void addTheSameClientTwiceTest() {

		out.addToLibrary(library);
		out.addToLibrary(library);

		// If addToLibrary is supposed to add every Client only once
		// assertEquals(1, library.clients.size());

		// If addToLibrary is supposed to add every Client as often as
		// addToLibrary is called
		assertEquals(2, library.clients.size());
	}

	@Test
	public void returnBookTest() {
		out.addToLibrary(library);
		library.addBook(book);
		out.borrowBook(book);
		out.returnBook(BOOK_TITLE);
		assertEquals(0, out.borrowedBooks.size());
	}

	@Test
	public void returnOneOfTwoBooksTest() {
		out.addToLibrary(library);
		library.addBook(book);
		out.borrowBook(book);
		library.addBook(secondBook);
		out.borrowBook(secondBook);
		out.returnBook(BOOK_TITLE);
		assertEquals(BOOK_TITLE2, out.borrowedBooks.get(0).bookTitle);

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

	// library add Client hinzufügen
	@Test
	public void borrowBookTest() {
		library.addBook(book);
		out.borrowBook(book);
		assertEquals(true, out.borrowedBooks.get(0).equals(book));
	}

	@Test
	public void borrowCompactDiskTest() {
		book.setCompactDisc(true);
//		library.addBook(book);
		out.borrowBook(book);
		assertEquals(true, out.borrowedBooks.isEmpty());

	}

}
