package design.builder;

public class BuilderMain {

	public volatile boolean flag;

	// 複雑なパラメタ設定をコンストラクタを介さずに行う。
	public static void main(String args[]) {

		MusashiyaBuilder mb = new MusashiyaBuilder();

		// 全部で4通りの指定パターン有?? 麺，味の指定有無。

		// 1. 普通のお客さん
		Customer c1 = new DefaultCustomer();
		Musashiya m1 = c1.createMusashiya(mb);
		System.out.println(m1.noodle.toString() + m1.taste.toString());

		// 2. 固めが好きなお客さん
		Customer c2 = new KoimeCustomer();
		Musashiya m2 = c2.createMusashiya(mb);
		System.out.println(m2.noodle.toString() + m2.taste.toString());
	}
}
