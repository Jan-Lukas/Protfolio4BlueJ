import java.util.ArrayList;

public class Book {
    public String caption;
    public String category;
    public ArrayList<String> pageContent;
    private boolean compactDisc;

    public Book (String title) {
        this.caption = title;
        this.category = "Roman";
        this.pageContent = new ArrayList<>();
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
    public void addAndBorrowBook (Library library, Client client) {
        library.addBook (this);
        if (!this.isCompactDisc()) {
            client.borrowedBooks.add (this);
        }
    }
    
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

}