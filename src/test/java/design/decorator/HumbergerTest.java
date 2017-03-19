/**
 *
 */
package design.decorator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author tokus
 *
 */
public class HumbergerTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link design.decorator.Humberger#getCost()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCost() {
		HumbergerMenu hm = new Humberger();
		assertEquals(hm.getCost(), 150);
	}

	/**
	 * {@link design.decorator.Humberger#getText()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetText() {
		HumbergerMenu hm = new Humberger();
		assertEquals(hm.getText(), "Humberger");
		assertNotNull(hm.getText());
	}

}
