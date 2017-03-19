/**
 *
 */
package design.decorator;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author tokus
 *
 */
public class DecoratorMainTest {


	/**
	 * {@link design.decorator.DecoratorMain#main(java.lang.String[])} のためのテスト・メソッド。
	 */
	@Test
	public void testMain() {
		HumbergerMenu hm = new Humberger();
		assertEquals(hm.getCost(),150);
	}

}
