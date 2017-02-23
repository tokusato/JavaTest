package generics;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * スーパークラスで独自Collectionを表現する場合、
 * カプセル化の制約を破ることになるため、次回はコンポジットの機能を利用して独自Collectionの実装をする。
 * */
public class MyGenerics <E> extends ArrayList<E> implements Comparable<List<E>>, Iterable<E>{
	//型パラメタTを利用したジェネリクス
	E typeVal;

	private int totalAddNum;


	public MyGenerics(E typeVal){
		//スーパークラスのArrayListクラスのコンストラクタ
		super();
		this.typeVal = typeVal;
	}


	/**
	 * @author toku
	 * @param E e(ユーザが本クラスのインスタンス生成時に指定した型のインスタンス)
	 * @return boolean
	 * スーパークラスArrayListのaddメソッドをオーバーライドしたメソッド
	 *
	 * */
	@Override
    public boolean add(E e) {
		try {
			super.add(e);
			System.out.println(++totalAddNum);
			return Boolean.TRUE;
		} catch (RuntimeException re){
			re.printStackTrace();
			return Boolean.FALSE;
		}
    }


	/**
	 * @author toku
	 * リストに格納された要素数で順序付けを行う
	 * リストに格納された要素数が同じ場合は、本オブジェクトのハッシュコードで順序付けを行う
	 *
	 * */

	@Override
	public int compareTo(List<E> o) {
		int result = 0;
		return (this.size() > o.size()) ? 100 : -100;
	}


//	/* (非 Javadoc)
//	 * @see java.lang.Object#hashCode()
//	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = super.hashCode();
//		result = prime * result + totalAddNum;
//		result = prime * result + ((typeVal == null) ? 0 : typeVal.hashCode());
//		return result;
//	}
//
//
//	/* (非 Javadoc)
//	 * @see java.lang.Object#equals(java.lang.Object)
//	 */
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (!super.equals(obj)) {
//			return false;
//		}
//		if (!(obj instanceof MyGenerics)) {
//			return false;
//		}
//		MyGenerics other = (MyGenerics) obj;
//		if (totalAddNum != other.totalAddNum) {
//			return false;
//		}
//		if (typeVal == null) {
//			if (other.typeVal != null) {
//				return false;
//			}
//		} else if (!typeVal.equals(other.typeVal)) {
//			return false;
//		}
//		return true;
//	}

	/**
	 * @author toku
	 * オブジェクトが同一である判断基準を、ハッシュ値でなく、
	 * リストの要素数に変更する。
	 * ハッシュ型のCollectionに本オブジェクトを格納する際には、
	 * 性能に注意を払うこと。(全てのオブジェクトの要素数が同一の場合、要素の取得は、線形検索になる。)
	 * */
	@Override
	public int hashCode() {
		return this.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		boolean compareResult = Boolean.FALSE;
		try {
			return (this.size() == ((MyGenerics<E>)obj).size()) ? true:false;
		} catch (ClassCastException cce){
			cce.printStackTrace();
			return false;
		}
	}


}
