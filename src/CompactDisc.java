import java.util.ArrayList;
import java.util.List;

public class CompactDisc {
	
	//Tests hinzufügen
	private String title;
	private String category;
	private List<String> content = new ArrayList<>();

	private String author;
	public static final String DEFAULT_CATEGORY = "CD";

	// we assume that author is mandatory
	public CompactDisc(String title, String author) {
		this.title = title;
		this.category = DEFAULT_CATEGORY;
		this.author = author;
	}

	public boolean hasCategory(String category) {
		return this.category.equals(category);
	}

	public void addContent(String textOfPage) {
		content.add(textOfPage);
	}

	public boolean contains(String text) {
		boolean found = false;
		int page = 0;
		while (!found && page < content.size()) {
			found = content.contains(text);
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

	public List<String> getContentList() {
		return new ArrayList<>(content);
	}
}