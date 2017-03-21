package design.builder;

public class DefaultCustomer implements Customer{

	@Override
	public Musashiya createMusashiya(MusashiyaBuilder mb) {
		//デフォルトのお客さんはお好みなし
		return mb.getMusashiya();
	}

}
