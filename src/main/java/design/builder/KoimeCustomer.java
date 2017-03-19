package design.builder;

public class KoimeCustomer implements Customer {

	@Override
	public Musashiya createMusashiya(MusashiyaBuilder mb) {
		mb.setTaste(Taste.KOI);
		return mb.getMusashiya();
	}

}
