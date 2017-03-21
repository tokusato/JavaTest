package design.decorator;

/**
 * ハンバーガーショップのメニューを定義するインタフェース
 *
 * */
public interface HumbergerMenu {

	/**
	 * メニューの価格を取得するメソッド
	 *
	 * @param nothing
	 * @return int(total decorated price)
	 * @since v1.0
	 * @author toku
	 * */
	public int getCost();

	/**
	 * メニューの説明を取得するメソッド
	 *
	 * @param nothing
	 * @return String(total decorated explanation)
	 * @since v1.0
	 * @author toku
	 * */
	public String getText();


}
