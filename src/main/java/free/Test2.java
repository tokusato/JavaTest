package free;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class Test2 {

	/**
	 * @param args
	 *
	 */
	/* インスタンス変数 */
	int num = 0;

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		SortedMap<Object, String> smap = new TreeMap<Object, String>();
//		smap.put(new Object(), "first");
//		smap.put(new Object(), "second");

		SortedMap<Integer, String> imap = new TreeMap<Integer, String>();
		/*  */
		Comparator<? super Integer> comp = imap.comparator();


		NavigableMap<Integer, String> nmap = new TreeMap<>();
		nmap.put(25, "Tokumaru");
		nmap.put(15, "Suzuki");
		nmap.put(30,"Ichiro");

		System.out.println(nmap.containsKey(25));
		//ceilingEntryでは、要素をぎりぎり超えるエントリを返す。
		System.out.println(nmap.ceilingEntry(27));
		System.out.println(nmap.ceilingEntry(23));
		System.out.println(nmap.floorEntry(20));

		System.out.println("#########################");
		Set <Entry<Integer,String>> entrySet = nmap.entrySet();
		for (Entry<Integer, String> ite  : entrySet){
			System.out.println(ite.getValue());
		}

		String[] str = {"a","b"};
		List<String> list = Arrays.asList(str);
		/* コピーして作ったListのサイズは拡張できない。(追加や挿入) */
		try {
			/* 実行時のエラー */
			list.add("c");
			/* この位置に要素を格納し、すでに入っていたものは、右にシフトする */
			list.add(0,"c");
		} catch (UnsupportedOperationException uoe){
			/* Runtime実行例外を継承している。 */
		}

		ArrayList<String> l = new ArrayList<>();
		try {
			l.add(100, "abc");
		} catch (IndexOutOfBoundsException aiooe){
			/* 何もしない */
		}

		/* main関数の中のため、staticメソッドからはstaticなメンバ変数、メンバメソッドにしかアクセスすることができない */
		List<String> list2 = asListOriginal(str);

		List<Member> mlist = new ArrayList<>();
		mlist.add(new Test2().new Member(10));
		mlist.add(new Test2().new Member(30));
		mlist.add(new Test2().new Member(20));

		Collections.sort(mlist);
		Iterator<Member> ite = mlist.iterator();
		while (ite.hasNext()){
			System.out.println(ite.next().memberId);
		}

	}

	/* ダミーのメンバクラス */
	class Member implements Comparable<Member>{

		int memberId;

		public Member(int memberId){
			this.memberId = memberId;
		}

		public int compareTo(Member anotherMem){
			/* 数字が大きいほうが、先頭にくる。 */
			return anotherMem.memberId - this.memberId ;

		}

	}


	private static <T> List<T> asListOriginal(Object[] typeArray) {
		/* メソッドで型パラメタを宣言する場合には、最初に<T>と宣言する?? */
		/* リターン用のList */
		List<T> list = new ArrayList<>();

		for (int i = 0 ; i < typeArray.length ; i++){
			try {
				list.add((T)typeArray[i]);
			} catch (ClassCastException cce){
				System.out.println("ClassCastException occured");
			}
		}
		return list;
	}

}




/*
 * LinkedListのに対する操作はadd,offer,poll,remove,peek,element　⇒まっせんせん(addとofferのみキューの末尾に入れていく。
 * add = addLast⇒最初に入れたものがどんどん先頭に移っていく  remove = removeFirst)
 * pushやpopもメソッドとして用意されている。これは、このリストが表すスタックから要素をプッシュorポップ
 *
 * SortedMapはMapインターフェースを継承したサブインターフェース。newできない
 *
 * TreeMapはNavigableMapとSortedMapの二つのインターフェースを実装している。
 *
 * MapインターフェースはCollectionインターフェースと区別しなくてはならない。CollectionでMapを生成することはできない
 *
 *comperTo()を実装するのは、Comparable!!
 *compareメソッドの中で演算をし、正の整数を返すということは、比較して大きいということ??要素が後ろに回される。
 *
 *CollectionsクラスのbinarySearchメソッドはListに対してのみ有効。ランダムアクセスできるようにindexがはってあるからね。
 *インデックスを戻り値にしているため、キーには、オブジェクトを入れている。
 *検索するエレメントはjava.util.Comparableインターフェースを実装している必要がある。
 *
 *TreeSetなどはコンストラクタにComparatorインターフェースを実装したルールクラスを入れてもよい。
 *
 *Comparableを実装する場合には、その型パラメタはクラスの型とそろえる。
 *
 *順序付けが等しい場合には、compareToメソッドは0を返す。そのほかの比較をしないと、コレクションに格納した順番になる??
 *
 *配列をArrayListクラスに変換する場合には、ArraysクラスのasListメソッドを用いる。
 *
 * */
