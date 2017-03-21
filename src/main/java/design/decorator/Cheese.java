package design.decorator;

public class Cheese extends Topping{


	/**
	 * スーパークラスのコンストラクタの内部で
	 * */
	public Cheese(HumbergerMenu hm) {
		super(hm);
		addedCost = 30;
		addedText = "Cheese";
	}

	/* (非 Javadoc)
	 * @see design.decorator.Topping#getCost()
	 */
	@Override
	public int getCost() {
		return addedCost + super.getCost() ;
	}

	/* (非 Javadoc)
	 * @see design.decorator.Topping#getText()
	 */
	@Override
	public String getText() {
		return addedText + super.getText();
	}



}
