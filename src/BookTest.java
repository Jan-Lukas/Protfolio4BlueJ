import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
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
	public void setCompactDiscTrueTest() {
		
	}

}
