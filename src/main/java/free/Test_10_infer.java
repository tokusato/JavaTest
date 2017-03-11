package free;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.ss.formula.functions.T;


public class Test_10_infer<E> {

	/* 型推測 */
	E e = null;
	public Test_10_infer(E e) {
		this.e = e;
	}

	/* インナークラス(privateのアクセス修飾子を許可している) */
	private static class Inner {

		/* コンストラクタスコープの型推測 */
		/* エンクロージングクラスのEとは別物だお */
		<E extends InputStreamReader> Inner(E e) {

		}

	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		InputStream is = System.in;
		/* インナークラスのオブジェクトを生成したい */
//		Inner inner = Test_10_infer<>(new /Object()) . new Inner(new InputStreamReader(is));
	}

	public static T method (List<T> list){
		list.add(null);
//		list.add(3);
//		list.add("String");
		return null;
	}

	class Temp<T> {

	}

}
