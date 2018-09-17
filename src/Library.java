import java.util.ArrayList;
import java.util.List;

public class Library {

	private List<Book> books = new ArrayList();

	private List<Client> clients = new ArrayList();



	public void addBook(Book book) {
		books.add(book);
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


	public List<String> bookBorrowedBy(String bookTitle) {
		ArrayList<String> bookBorrowedByList = new ArrayList<>();
		for (Client client : clients) {
			for (Book book : client.getBorrowedBooks()) {
				if (bookTitle.equals( book.getTitle()) && !bookBorrowedByList.contains( book.getTitle())) {
					bookBorrowedByList.add(client.getName());
				}

			}
		}
		return bookBorrowedByList;
	}

	public void printListOfBooks() {
		for (Book book : books) {
			if (!book.isCompactDisc()) {
				System.out.println(book.getTitle() + " # " + book.getAuthor() + " # " + book.getCategory());
				book.printKeywords();
			} else {
				System.out.println(book.getTitle() + " # " + book.getAuthor() + " # CD");
				book.printKeywords();
			}
		}
	}

	public List<Client> mostBooksBorrowedBy(){
		ArrayList <Client> clientsWithMostBooks= new ArrayList<>();
		int highestNumberOfBorrowedBooks = 0;
		
		for (Client client : clients){
			if (client.getCountOfBorrowedBooks() > highestNumberOfBorrowedBooks){
				clientsWithMostBooks.clear();
				highestNumberOfBorrowedBooks= client.getCountOfBorrowedBooks();
				clientsWithMostBooks.add(client);
			}
			else if (client.getCountOfBorrowedBooks() == highestNumberOfBorrowedBooks){
				clientsWithMostBooks.add(client);
			}
		}
		
		return clientsWithMostBooks;
	}

	public void addClient(Client client) {
		clients.add(client);
	}

	public List<Book> getBooks() {
		return books;
	}

	public List<Client> getClients() {
		return new ArrayList<>(clients);
	}

}