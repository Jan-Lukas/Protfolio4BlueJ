import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

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
public void addCompactDiscTest(){
	// a seperate compactDisk class would be usefull. 
	Book compactDisc = book;
	compactDisc.setCompactDisc(true);
	out.addBook(compactDisc);
	assertEquals(true, out.books.get(0).equals(compactDisc));
	
	
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

	@Test
	public void bookBorrowedByTwoClientsTest() {
		client.addToLibrary(out);
		client2.addToLibrary(out);

		out.addBook(book);
		client.borrowBook(book);
		client2.borrowBook(book);
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));

	}

	@Test
	public void bookBorrowedByOneClientTest() {
		client.addToLibrary(out);
		client2.addToLibrary(out);
		out.addBook(book);
		client.borrowBook(book);
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));

	}

	@Test
	public void bookBorrowedByNoNoneTest() {
		client.addToLibrary(out);
		out.addBook(book);
		client.borrowBook(book);

		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE2).contains(CLIENT_NAME));

	}

	// Because of the missing opportunity to test System.out.println properly
	// accross different plattforms, we don't test the function
	// printListOfBooks.

}
