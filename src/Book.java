import java.util.ArrayList;

public class Book {
    public String bookTitle;
    public String category;
    public ArrayList<String> pageContent;
    private boolean compactDisc;
    private String author;
    
// we assume that author is mandatory
    public Book (String title, String author) {
        this.bookTitle = title;
        this.category = "Roman";
        this.pageContent = new ArrayList<>();
        this.author = author;
    }

    public void setCompactDisc (boolean compactDisc) {
        this.compactDisc = compactDisc;
    }

    public boolean isCompactDisc () {
        return compactDisc;
    }

    public void deleteBook (Library library) {
    	//direkter Zugriff ist scheiße
        library.books.remove (this);
        for (Client client : library.clients) {
            client.borrowedBooks.remove (this);
        }
    }
//keine Rückgabe wenn nicht ausgeliehen?

    
    
    
    public boolean hasCategory (String category) {
        return this.category.equals (category);
    }
    
    public void addPage (String textOfPage) {
        pageContent.add (textOfPage);
    }
    
    public boolean contains (String text) {
        boolean found = false;
        int page = 0;
        while (!found && page < pageContent.size()) {
            found = pageContent.contains (text);
            page++;
        }
        return found;
    }

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}