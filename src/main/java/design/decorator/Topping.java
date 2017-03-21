package design.decorator;

public class Topping implements HumbergerMenu{

	//コンストラクタ
	//元のハンバーガクラスの情報を上乗せしたい。
	//しかも元のクラスの型のまま扱いたい
	protected HumbergerMenu hm;

	protected int addedCost;
	protected String addedText;

	//元となる情報をスーパークラスの情報としてセットしておく。
	public Topping(HumbergerMenu hm){
		this.hm = hm;
	}

	@Override
	public int getCost() {
		return hm.getCost();
	}

	@Override
	public String getText() {
		return hm.getText();
	}
}
