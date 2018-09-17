import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BookTest {
	private Book out;
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String FIRST_PAGE = "page content for the first page";
	private static final String SECOND_PAGE = "completly different content";
	private static final String NO_CONTENT_OF_PAGES = "not contained in a page!";
	private static final String AUTHOR_BOOK = "J.R.R. Tolkien";
	private static final String BOOK_CATEGORY = "Roman";
	private static final String FIRST_KEYWORD = "first Keyword";

	@Before
	public void intializeTests() {

		out = new Book(BOOK_TITLE, AUTHOR_BOOK);

	}

	@Test
	public void setCompactDiscTrueTest() {
		out.setCompactDisc(true);
		assertEquals(true, out.isCompactDisc());
	}

	@Test
	public void setCompactDiscFalseTest() {
		out.setCompactDisc(false);
		assertEquals(false, out.isCompactDisc());
	}

	@Test
	public void hasCategoryTrueTest() {
		assertEquals(true, out.hasCategory(BOOK_CATEGORY));
	}

	@Test
	public void hasCategoryFalseTest() {
		assertEquals(false, out.hasCategory("not a category"));
	}

	@Test
	public void addPageTest() {
		out.addPage(FIRST_PAGE);
		assertEquals(1, out.getPageContent().size());
	}

	@Test
	public void addTwoPagesTest() {
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(2, out.getPageContent().size());
	}

	@Test
	public void OnePageContainsTest() {
		out.addPage(FIRST_PAGE);
		assertEquals(true, out.contains(FIRST_PAGE));
	}

	@Test
	public void positiveSecondPageContainsTest() {
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(true, out.contains(SECOND_PAGE));
	}

	@Test
	public void noPageContainsTest() {
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(false, out.contains(NO_CONTENT_OF_PAGES));
	}

	@Test
	public void negativeOnePageContainsTest() {
		out.addPage(FIRST_PAGE);
		assertEquals(false, out.contains(NO_CONTENT_OF_PAGES));
	}

	@Test
	public void addKeywordTest() {
		out.addKeyword(FIRST_KEYWORD);
		assertEquals(true, out.getListOfKeywords().contains(FIRST_KEYWORD));
	}
	
	@Test 
	public void getListOfKeywordsTest() {
		out.addKeyword(FIRST_KEYWORD);		
		assertEquals(true, out.getListOfKeywords().contains(FIRST_KEYWORD));
	}
}
