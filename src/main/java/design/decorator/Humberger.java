package design.decorator;

/**
 * ハンバーガーショップの基礎メニュー<br>
 * デコレートされるクラス
 *
 * */
public class Humberger implements HumbergerMenu {

	protected int cost = 150;
	protected String text = "Humberger";


	/**
	 * ハンバーガーの基礎の値段
	 * */
	@Override
	public int getCost() {
		return cost;
	}

	/**
	 * ハンバーガーの基礎の値段
	 * */
	@Override
	public String getText() {
		return text;
	}

}
