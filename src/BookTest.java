import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Library library;
	private Book out;
	private Client client;
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String CLIENT_ADDRESS = "Reeperbahn 69";
	private static final String CLIENT_NAME = "Walter Krüger";
	private static final String FIRST_PAGE= "page content for the first page";
	private static final String SECOND_PAGE= "completly different content";
	private static final String NO_CONTENT_OF_PAGES="not contained in a page!";
	private static final String AUTHOR_BOOK = "J.R.R. Tolkien";
	private static final String BOOK_CATEGORY = "Roman";

	@Before
	public void intializeTests() {

		library = new Library();
		out = new Book(BOOK_TITLE,AUTHOR_BOOK);
		client = new Client(CLIENT_NAME, CLIENT_ADDRESS);

	}

	@Test
	public void setCompactDiscTrueTest() {
		out.setCompactDisc(true);
		assertEquals(true, out.isCompactDisc());
	}

	@Test
	public void setCompactDiscFalseTest() {
		out.setCompactDisc(false);
		assertEquals(false, out.isCompactDisc());
	}

	@Test
	public void DeleteBookTest() {
		library.addBook(out);
		out.deleteBook(library);
		assertEquals(0, library.books.size());
	}
	@Test
	public void DeleteBorrowedBookTest() {
		library.addBook(out);
		client.addToLibrary(library);
		client.borrowBook(out);
		out.deleteBook(library);
		assertEquals(0, library.books.size());
		assertEquals(0, client.borrowedBooks.size());
	}
	
	
	@Test
	public void hasCategoryTrueTest() {
		assertEquals(true, out.hasCategory(BOOK_CATEGORY));	
	}
	@Test
	public void hasCategoryFalseTest() {
		assertEquals(false, out.hasCategory("not a category"));
	}
	
	@Test 
	public void addPageTest(){
		out.addPage(FIRST_PAGE);
		assertEquals(1, out.pageContent.size());
	}
	
	@Test 
	public void addTwoPagesTest(){
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(2, out.pageContent.size());
	}
	@Test
	public void OnePageContainsTest(){
		out.addPage(FIRST_PAGE);
		assertEquals(true,out.contains(FIRST_PAGE));
	}
	@Test
	public void positiveSecondPageContainsTest(){
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(true,out.contains(SECOND_PAGE));
	}
	@Test
	public void noPageContainsTest(){
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(false,out.contains(NO_CONTENT_OF_PAGES));
	}
	@Test
	public void negativeOnePageContainsTest(){
		out.addPage(FIRST_PAGE);
		assertEquals(false,out.contains(NO_CONTENT_OF_PAGES));
	}
	}
