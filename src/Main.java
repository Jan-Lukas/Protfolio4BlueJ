
public class Main {
	public static void main(String[] args) {

		Book book = new Book("Buchtitel", "Buchautor1");
		book.addKeyword("New Keyword for Book1");
		Book book2 = new Book("Buchtitel2", "Buchautor2");
		book2.addKeyword("Completly new Keyword for book2");
		Library library = new Library();
		Client client = new Client("Name", "Nordakademie");
		Client client2 = new Client("Hans Müller", "Nordakademie2");
		library.addClient(client);
		library.addClient(client2);
		library.addBook(book2);
		library.addBook(book);
		client.borrowBook(book);
		client.borrowBook(book2);
		client.borrowBook(book);
		client2.borrowBook(book2);
		library.printListOfBooks();
		library.mostBooksBorrowedBy().forEach(clientLambda-> System.out.println(clientLambda.getCountOfBorrowedBooks()+"  "+clientLambda.getName()));;

	}
}
