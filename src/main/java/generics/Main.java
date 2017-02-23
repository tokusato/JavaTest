package generics;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		MyGenerics<String> mg = new MyGenerics<String>("Hello");
		mg.add("Str");
		mg.add("Str");

		MyGenerics<String> mg2 = new MyGenerics<String>("Hello");


		System.out.println(mg.compareTo(mg2));
	}

}
