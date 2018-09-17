import java.util.ArrayList;
import java.util.List;

public class Book {
	public static final String DEFAULT_CATEGORY = "Roman";
	private String title;
	private String category;
	private List<String> pageContent = new ArrayList<>();
	private List<String> listOfKeywords = new ArrayList<>();

	private String author;
	
	// we assume that author is mandatory
	public Book(String title, String author) {
		this.title = title;
		this.category = DEFAULT_CATEGORY;
		this.author = author;
	}


	public boolean hasCategory(String category) {
		return this.category.equals(category);
	}

	public void addPage(String textOfPage) {
		pageContent.add(textOfPage);
	}

	public boolean contains(String text) {
		boolean found = false;
		int page = 0;
		while (!found && page < pageContent.size()) {
			found = pageContent.contains(text);
			page++;
		}
		return found;
	}

	public void addKeyword(String keyword) {
		this.listOfKeywords.add(keyword);
	}
	public void printKeywords() {
		if (listOfKeywords != null) {
			System.out.println("Keywords:");
			listOfKeywords.forEach(keyword -> System.out.println("\t-"+keyword));
			System.out.println();
		}
	}


	public List<String> getPageContent() {
		return new ArrayList<>(pageContent);
	}

	public List<String> getListOfKeywords() {
		return new ArrayList<>(listOfKeywords);
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String bookTitle) {
		this.title = bookTitle;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

}