import java.util.ArrayList;
import java.util.List;

public class Library {

	public ArrayList<Book> books = new ArrayList();

	public ArrayList<Client> clients = new ArrayList();

	public static void main(String[] args) {

		Book book = new Book("Buchtitel", "Buchautor1");
		Library library = new Library();
		Client client = new Client("Name", "Nordakademie");
		Client client2 = new Client("Name2", "Nordakademie2");
		client.addToLibrary(library);
		client2.addToLibrary(library);

		library.addBook(book);
		client.borrowBook(book);

		library.printListOfBooks();
		System.out.println();
		library.bookBorrowedBy("Buchtitel").forEach(name -> System.out.println(name));
		
	}

	public void addBook(Book book) {
		books.add(book);
	}
	


	public List<String> bookBorrowedBy(String bookTitle) {
		ArrayList<String> bookBorrowedByList = new ArrayList<>();
		for (Client client : clients) {
			for (Book book : client.borrowedBooks) {
				if (book.bookTitle.equals(bookTitle) && !bookBorrowedByList.contains(client.name)) {
					bookBorrowedByList.add(client.name);
				}

			}
		}
		return bookBorrowedByList;

	}

	public void printListOfBooks() {
		for (Book book : books) {
			if (!book.isCompactDisc()) {
				System.out.println(book.bookTitle + " # " + book.getAuthor() + " # " + book.category);
			} else {
				System.out.println(book.bookTitle + " # CD");
			}
		}
	}

}