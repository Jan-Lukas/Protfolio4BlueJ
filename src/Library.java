import java.util.ArrayList;
import java.util.List;
/**
 * Library models a library with books and compactDiscs.
 * @version 17.09.2018
 *
 */
public class Library {

	private List<Book> books = new ArrayList();
	private List<CompactDisc> compactDiscs = new ArrayList();

	private List<Client> clients = new ArrayList();


	public void addBook(Book book) {
		books.add(book);
	}

	public void addCompactDisc(CompactDisc cd) {
		compactDiscs.add(cd);
	}

	public void deleteBook(Book book) {
		// doesn't remove all references if a book was added twice.
		books.remove(book);
		// doesn't work if a client borrowed the same book twice (the second
		// book stays in borrowedBooks).
		for (Client client : clients) {
			client.removeBook(book);
		}
	}
	public void deleteCompactDisc(CompactDisc cd){
		compactDiscs.remove(cd);
	}

	public List<String> bookBorrowedBy(String bookTitle) {
		ArrayList<String> bookBorrowedByList = new ArrayList<>();
		for (Client client : clients) {
			for (Book book : client.getBorrowedBooks()) {
				if (bookTitle.equals(book.getTitle()) && !bookBorrowedByList.contains(book.getTitle())) {
					bookBorrowedByList.add(client.getName());
				}

			}
		}
		return bookBorrowedByList;
	}

	public void printListOfLibraryContent() {
		for (Book book : books) {
			System.out.println(book.getTitle() + " # " + book.getAuthor() + " # " + book.getCategory());
			book.printKeywords();
		}
		for (CompactDisc cd : compactDiscs) {
			System.out.println(cd.getTitle() + " # " + cd.getAuthor() + " # CD");
		}
	}

	public List<Client> mostBooksBorrowedBy() {
		ArrayList<Client> clientsWithMostBooks = new ArrayList<>();
		int highestNumberOfBorrowedBooks = 0;

		for (Client client : clients) {
			if (client.getCountOfBorrowedBooks() > highestNumberOfBorrowedBooks) {
				clientsWithMostBooks.clear();
				highestNumberOfBorrowedBooks = client.getCountOfBorrowedBooks();
				clientsWithMostBooks.add(client);
			} else if (client.getCountOfBorrowedBooks() == highestNumberOfBorrowedBooks) {
				clientsWithMostBooks.add(client);
			}
		}

		return clientsWithMostBooks;
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public List<Book> getBooks() {
		return new ArrayList<>(books);
	}

	public List<CompactDisc> getCompactDiscList() {

		return new ArrayList<>(compactDiscs);
	}

	public List<Client> getClients() {
		return new ArrayList<>(clients);
	}

}