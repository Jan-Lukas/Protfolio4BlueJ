import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Test class for Book.java
 * @author Dominik Schween, Jan-Lukas Weimann
 * @version 17.09.2018
 *
 */
public class BookTest {
	private static final String BOOK_TITLE = "Lord of the Rings";
	private static final String FIRST_PAGE = "page content for the first page";
	private static final String SECOND_PAGE = "completly different content";
	private static final String NO_CONTENT_OF_PAGES = "not contained in a page!";
	private static final String AUTHOR_BOOK = "J.R.R. Tolkien";
	private static final String FIRST_KEYWORD = "first Keyword";
	private static final String NO_CATEGORY="not a category";
	private Book out;

	@Before
	public void intializeTests() {

		out = new Book(BOOK_TITLE, AUTHOR_BOOK);

	}


	@Test
	public void hasCategoryTrueTest() {
		assertEquals(true, out.hasCategory(Book.DEFAULT_CATEGORY));
	}

	@Test
	public void hasCategoryFalseTest() {
		assertEquals(false, out.hasCategory(NO_CATEGORY));
	}

	@Test
	public void addPageTest() {
		out.addPage(FIRST_PAGE);
		assertEquals(1, out.getPageContent().size());
		assertEquals(true, out.contains(FIRST_PAGE));
	}

	@Test
	public void addTwoPagesTest() {
		out.addPage(FIRST_PAGE);
		out.addPage(SECOND_PAGE);
		assertEquals(2, out.getPageContent().size());
		assertEquals(true, out.contains(FIRST_PAGE));
		assertEquals(true, out.contains(SECOND_PAGE));
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
	public void addKeywordTest() {
		out.addKeyword(FIRST_KEYWORD);
		assertEquals(true, out.getListOfKeywords().contains(FIRST_KEYWORD));
	}
	
}
