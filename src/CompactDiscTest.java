
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * TestClass for CompactDisc.java
 * @author Dominik Schween, Jan-Lukas Weimann
 * @version 17.09.2018
 *
 */
public class CompactDiscTest {
	private CompactDisc out;
	private static final String CD_TITLE = "Lord of the Rings";
	private static final String CONTENT = "Chapter 1";
	private static final String SECOND_CONTENT = "Chapter 2";
	private static final String NOT_EXISTING_CONTENT = "not contained in content!";
	private static final String AUTHOR = "J.R.R. Tolkien";
	public static final String DEFAULT_CATEGORY = "CD";
	private static final String NO_CATEGORY = "not a category";

	@Before
	public void intializeTests() {

		out = new CompactDisc(CD_TITLE, AUTHOR);
	}

	@Test
	public void hasCategoryTrueTest() {
		assertEquals(true, out.hasCategory(DEFAULT_CATEGORY));
	}

	@Test
	public void hasCategoryFalseTest() {
		assertEquals(false, out.hasCategory(NO_CATEGORY));
	}

	@Test
	public void addContentTest() {
		out.addContent(CONTENT);
		assertEquals(true, out.getContent().contains(CONTENT));
	}

	@Test
	public void addTwoStringsToContentTest() {
		out.addContent(CONTENT);
		out.addContent(SECOND_CONTENT);
		assertEquals(true, out.getContent().contains(CONTENT));
		assertEquals(true, out.getContent().contains(SECOND_CONTENT));
	}

	@Test
	public void OnePageContainsTest() {
		out.addContent(CONTENT);
		assertEquals(true, out.contains(CONTENT));
	}

	@Test
	public void SecondPageContainsTest() {
		out.addContent(CONTENT);
		out.addContent(SECOND_CONTENT);
		assertEquals(true, out.contains(SECOND_CONTENT));
	}

	@Test
	public void noPageContainsTest() {
		out.addContent(CONTENT);
		out.addContent(SECOND_CONTENT);
		assertEquals(false, out.contains(NOT_EXISTING_CONTENT));
	}

	@Test
	public void negativeOnePageContainsTest() {
		out.addContent(CONTENT);
		assertEquals(false, out.contains(NOT_EXISTING_CONTENT));
	}

}
