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

		out.addClient(client);
		out.addClient(client2);

	}

	@Test
	public void addCompactDiscTest() {
		// a seperate compactDisk class would be useful.
		Book compactDisc = book;
		compactDisc.setCompactDisc(true);
		out.addBook(compactDisc);
		assertEquals(true, out.getBooks().get(0).equals(compactDisc));

	}

	@Test
	public void addFirstBookTest() {
		out.addBook(book);
		assertEquals(1, out.getBooks().size());
	}

	@Test
	public void addSecondBookTest() {
		out.addBook(book);
		out.addBook(secondBook);
		assertEquals(2, out.getBooks().size());
	}

	@Test
	public void bookBorrowedByTwoClientsTest() {

		out.addBook(book);
		client.borrowBook(book);
		client2.borrowBook(book);
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));

	}

	@Test
	public void bookBorrowedByOneClientTest() {
		out.addBook(book);
		client.borrowBook(book);
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));

	}

	@Test
	public void bookBorrowedByNoneTest() {
		out.addBook(book);
		client.borrowBook(book);
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE2).contains(CLIENT_NAME));

	}

	@Test
	public void removeUniqueBookTest() {
		out.addBook(book);
		out.removeBookFromLibrary(book);
		assertEquals(false, out.getBooks().contains(book));
	}

	@Test
	public void removeTwiceExistingBookTest() {
		out.addBook(book);
		out.addBook(book);
		out.removeBookFromLibrary(book);
		assertEquals(false, out.getBooks().contains(book));
	}

	@Test
	public void deleteTwiceBorrowedBookTest() {
		out.addBook(book);
		client.borrowBook(book);
		client.borrowBook(book);
		out.deleteAllBookReferences(book);
		assertEquals(false, client.getBorrowedBooks().contains(out));
		assertEquals(false, out.getBooks().contains(out));
	}

	@Test
	public void deleteTwiceAddedBookTest() {
		out.addBook(book);
		out.addBook(book);
		out.deleteAllBookReferences(book);
		assertEquals(false, out.getBooks().contains(out));
	}

	@Test
	public void DeleteOnceBorrowedBookTest() {
		out.addBook(book);
		out.deleteAllBookReferences(book);
		assertEquals(0, out.getBooks().size());
	}

	@Test
	public void DeleteBorrowedBookTest() {
		out.addBook(book);
		client.borrowBook(book);
		out.deleteAllBookReferences(book);
		assertEquals(0, out.getBooks().size());
		assertEquals(0, client.getBorrowedBooks().size());
	}

	@Test
	public void addTwoClientsTest() {

		assertEquals(client, out.getClients().get(0));
		assertEquals(client2, out.getClients().get(1));
	}

	// addToLibrary shouldn't add the same client twice
	@Test
	public void addTheSameClientTwiceTest() {

		out.addClient(client);
		// If addToLibrary is supposed to add every Client only once
		// assertEquals(2, library.clients.size());

		// If addToLibrary is supposed to add every Client as often as
		// addToLibrary is called
		assertEquals(3, out.getClients().size());
	}
	
	@Test
	public void mostBooksBorrowedByTest(){
		client.borrowBook(book);
		client.borrowBook(secondBook);
		client2.borrowBook(book);
		
		assertEquals(client, out.mostBooksBorrowedBy().get(0));
		assertEquals(1, out.mostBooksBorrowedBy().size());
		
	}

	// Because of the missing opportunity to test System.out.println properly
	// accross different plattforms, we don't test the function
	// printListOfBooks.

}
