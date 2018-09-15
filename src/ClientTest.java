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

	@Before
	public void intializeTests() {

		out = new Client("Thomas", "Hagebuttenstraﬂe 84");
		library = new Library();
		book = new Book(BOOK_TITLE);
		secondBook = new Book(BOOK_TITLE2);

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
		Client out2 = new Client("Mark", "Hagebuttenstraﬂe 85");
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
		assertEquals(1, library.clients.size());

		// If addToLibrary is supposed to add every Client as often as
		// addToLibrary is called
		// assertEquals(library.clients.size(), 2);
	}

	@Test
	public void returnBookTest() {
		out.addToLibrary(library);
		book.addAndBorrowBook(library, out);
		out.returnBook(BOOK_TITLE);
		assertEquals(0, out.borrowedBooks.size());
	}

	@Test
	public void returnOneOfTwoBooksTest() {
		out.addToLibrary(library);
		book.addAndBorrowBook(library, out);
		secondBook.addAndBorrowBook(library, out);

		out.returnBook(BOOK_TITLE);
		assertEquals(BOOK_TITLE2, out.borrowedBooks.get(0).caption);

	}

	

	@Test
	public void negativeSsFavoriteCategoryTest() {
		assertEquals(false, out.isFavoriteCategory(CATEGORY_CRIME));
	}

	@Test
	public void positiveIsFavoriteCategoryTest(){
		
		out.favoriteCategories.add(CATEGORY_CRIME);
		assertEquals(true,out.isFavoriteCategory(CATEGORY_CRIME));
	}

}
