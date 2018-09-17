import java.util.ArrayList;
import java.util.List;

public class Client {

	private List<Book> borrowedBooks = new ArrayList<>();
	private List<String> favoriteCategories = new ArrayList<>();

	private String name;
	private String address;

	public Client(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public void returnBook(String title) {
		Book bookToReturn = null;
		for (Book book : borrowedBooks) {
			if (book.getTitle().equals(title)) {
				bookToReturn = book;
				break;
			}
		}
		borrowedBooks.remove(bookToReturn);
	}

	public void removeBook(Book book) {
			borrowedBooks.remove(book);
	}

	public boolean isFavoriteCategory(String category) {
		return favoriteCategories.contains(category);
	}


	public void borrowBook(Book book) {
			this.borrowedBooks.add(book);
	}

	public int getCountOfBorrowedBooks() {
		return borrowedBooks.size();
	}

	public List<Book> getBorrowedBooks() {
		return new ArrayList<>(borrowedBooks);
	}

	public List<String> getFavoriteCategories() {
		return new ArrayList<>(favoriteCategories);
	}

	public void addFavoriteCategory(String category) {
		if (!favoriteCategories.contains(category)) {
			favoriteCategories.add(category);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}