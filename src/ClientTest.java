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
		library.addClient(out);
		book = new Book(BOOK_TITLE, AUTHOR_BOOK);
		secondBook = new Book(BOOK_TITLE2, AUTHOR_BOOK2);

	}

	@Test
	public void returnBookTest() {
		library.addBook(book);
		out.borrowBook(book);
		out.returnBook(BOOK_TITLE);
		assertEquals(0, out.getBorrowedBooks().size());
	}

	@Test
	public void returnOneOfTwoBooksTest() {
		library.addBook(book);
		out.borrowBook(book);
		library.addBook(secondBook);
		out.borrowBook(secondBook);
		out.returnBook(BOOK_TITLE);
		assertEquals(false, out.getBorrowedBooks().contains(book));
		assertEquals(true, out.getBorrowedBooks().contains(secondBook));

	}

	@Test
	public void returnNotBorrowedBookTest() {
		out.returnBook(BOOK_TITLE);
		assertEquals(false, out.getBorrowedBooks().contains(book));
	}

	@Test
	public void removeBookTest() {
		out.borrowBook(book);
		out.removeBook(book);
		assertEquals(false, out.getBorrowedBooks().contains(book));
	}

	@Test
	public void negativeIsFavoriteCategoryTest() {
		assertEquals(false, out.isFavoriteCategory(CATEGORY_CRIME));
	}

	@Test
	public void positiveIsFavoriteCategoryTest() {
		out.addFavoriteCategory(CATEGORY_CRIME);
		assertEquals(true, out.isFavoriteCategory(CATEGORY_CRIME));
	}

	@Test
	public void addFavoriteCategoryTest() {
		out.addFavoriteCategory(CATEGORY_CRIME);
		assertEquals(true, out.isFavoriteCategory(CATEGORY_CRIME));
	}

	@Test
	public void borrowBookTest() {
		library.addBook(book);
		out.borrowBook(book);
		assertEquals(true, out.getBorrowedBooks().contains(book));
	}

	@Test
	public void getCountOfBorrowedBooksTest() {
		library.addBook(book);
		out.borrowBook(book);
		library.addBook(secondBook);
		out.borrowBook(secondBook);
		assertEquals(2, out.getCountOfBorrowedBooks());
	}

}
