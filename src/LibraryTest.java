import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
	private Library out;
	private Book book;
	private Book secondBook;
	private CompactDisc cd;
	private CompactDisc cd2;
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
	public void addFirstBookTest() {
		out.addBook(book);
		assertEquals(1, out.getBooks().size());
		assertEquals(true, out.getBooks().contains(book));
	}
	@Test
	public void addSecondBookTest() {
		out.addBook(book);
		out.addBook(secondBook);
		assertEquals(2, out.getBooks().size());
	}
	@Test
	public void addFirstCompactDiscTest() {
		out.addCompactDisc(cd);
		assertEquals(1, out.getCompactDiscList().size());
		assertEquals(true, out.getCompactDiscList().contains(cd));
	}
	@Test
	public void addSecondCompactDiscTest() {
		out.addCompactDisc(cd);
		out.addCompactDisc(cd2);
		assertEquals(2, out.getCompactDiscList().size());
		assertEquals(true, out.getCompactDiscList().contains(cd));
		assertEquals(true, out.getCompactDiscList().contains(cd2));
	}
	
	@Test
	public void deleteUniqueBookTest() {
		out.addBook(book);
		out.deleteBook(book);
		assertEquals(false, out.getBooks().contains(book));
	}
	

	
	@Test
	public void deleteCompactDiscTest(){
		out.addCompactDisc(cd);
		out.deleteCompactDisc(cd);
		assertEquals(0, out.getCompactDiscList().size());
	}


	@Test
	public void bookBorrowedByOneClientTest() {
		out.addBook(book);
		client.borrowBook(book);
		assertEquals(true, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME));
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE).contains(CLIENT_NAME2));
		
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
	public void bookBorrowedByNoneTest() {
		out.addBook(book);
		client.borrowBook(book);
		assertEquals(false, out.bookBorrowedBy(BOOK_TITLE2).contains(CLIENT_NAME));

	}
	
	@Test
	public void mostBooksBorrowedByTest() {
		client.borrowBook(book);
		client.borrowBook(secondBook);
		client2.borrowBook(book);
		
		assertEquals(client, out.mostBooksBorrowedBy().get(0));
		assertEquals(1, out.mostBooksBorrowedBy().size());	
	}
	@Test
	public void mostBooksBorrowedByTwoClientsTest() {
		client.borrowBook(book);
		client.borrowBook(secondBook);
		client2.borrowBook(book);
		client2.borrowBook(secondBook);
		
		assertEquals(2, out.mostBooksBorrowedBy().size());
	}
	@Test
	public void mostBooksBorrowedByNoneTest() {
		out= new Library ();
		assertEquals(true, out.mostBooksBorrowedBy().isEmpty());
	}

	@Test 
	public void addClientTest(){
		out.addClient(client);
		assertEquals(true, out.getClients().contains(client));
	}

	@Test
	public void deleteTwiceBorrowedBookTest() {
		out.addBook(book);
		client.borrowBook(book);
		client.borrowBook(book);
		out.deleteBook(book);
		assertEquals(true, client.getBorrowedBooks().contains(book));
		assertEquals(false, out.getBooks().contains(book));
	}

	@Test
	public void DeleteBorrowedBookTest() {
		out.addBook(book);
		client.borrowBook(book);
		out.deleteBook(book);
		assertEquals(0, out.getBooks().size());
		assertEquals(0, client.getBorrowedBooks().size());
	}

	@Test
	public void addTwoClientsTest() {

		assertEquals(client, out.getClients().get(0));
		assertEquals(client2, out.getClients().get(1));
	}

	
	// Because of the missing opportunity to test System.out.println properly
	// accross different plattforms, we don't test the function
	// printListOfBooks.

}
