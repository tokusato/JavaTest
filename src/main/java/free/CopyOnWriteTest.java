package free;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;


public class CopyOnWriteTest {

	/**
	 * @param args
	 */

	/* この時点では型をワイルドカードによって任意性を持たせている */
	//⇒listに要素が追加できなくなるため、却下
	static CopyOnWriteArrayList<Integer> cowArrayList =
			new CopyOnWriteArrayList<>();

	public static void main(String[] args) throws InterruptedException {
		// TODO 自動生成されたメソッド・スタブ
		List<Integer> list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);

		/* start()メソッドはThreadクラスにのみ存在するため、Runnableの匿名クラスを指定したスレッド処理を実行することはできない。 */
		new Thread(){
			/* リストの要素を覗くスレッド */
			public void run() {
					/* Listが2番目の要素を追加するまでの間に1秒待つ */
					try {
						Thread.sleep(1000);
						for (Integer i :cowArrayList){
							System.out.println("from Lokking Thread  : " + i);
						}
					} catch (InterruptedException e) { }
			}
		}.start();



		//cowArrayListに追加する
		cowArrayList.addAll(list1);
		Thread.sleep(2000);
		cowArrayList.addAll(list2);

		for (Integer i : cowArrayList){
			System.out.println(i);
		}
//		cowArrayList.


		List<? extends CopyOnWriteTest> list = new ArrayList<>();
//		list.add(new CopyOnWriteTest());
//		list.add(new AAA());

		/* 拡張性の高いクラスを作成 */
		Gen<Integer> intObj = new Gen<Integer>(100);
		intObj.setT(300);
		System.out.println((intObj.getT()));

		int ii = 0;
		int jj = 1 + ++ii;
		String str = null;
		System.out.println(str);

		/* HashSetのテスト */
		Set<String> set = new HashSet<>();
		set.add("tomato");
		set.add("banaan");
		set.add("orange");
		set.add("potato");
		set.add("tomato");// String型の場合、文字列が同じだったらハッシュ値も同じ。
		set.add("");

		Iterator<String> ite = set.iterator();

		String strtmp = null;
		while (ite.hasNext()){
			strtmp = ite.next();
			System.out.print(strtmp + "   ");
			System.out.println(strtmp.hashCode() +
					"  " + Integer.toHexString(strtmp.hashCode()));
		}


		int iii = 8;
		iii = iii >>> 1; //1bit左にシフトする。1000 ⇒ 100
		System.out.println(iii);

		int jjj = 9;
		jjj = jjj >>> 1;
		System.out.println(jjj);//切り捨て除算だから4を返す。

		byte bbb = (byte)3;//00000011⇒11111100⇒負の数を表している0000011(-3??)
		bbb = (byte)~bbb ;
		System.out.println(bbb);//-4
		System.out.println(bbb ^ (byte)127);

		Path p = Paths.get("C:", "Users");
		System.out.println(p.toFile().canRead());


		String strnull = null;
		System.out.println(strnull + "aaa");

		String strout = strnull + "aaa";
		System.out.println(strout); //どっちもコンパイルは通る。文字列結合の前には、StringクラスのvalueOfメソッドが呼び出されていて、nullならnullの文字列を返すようになっている。




	}

}

class AAA extends CopyOnWriteTest{}

class Gen <T>{

	T value;
	Gen(T value){
		this.value = value;
	}

	public void setT(T value){
		this.value = value ;
	}

	public T getT() {
		return value;
	}

}