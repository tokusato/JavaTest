package free;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;


public class BundleGet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/* 米国用のリソースバンドルの取得 */
		Locale loc_us = new Locale("en", "US");
		Locale loc_jp = Locale.getDefault();

		ResourceBundle rbus = ResourceBundle.getBundle("com.se.MyResources", loc_us);
		ResourceBundle rbjp = ResourceBundle.getBundle("com.se.MyResources", loc_jp);

		System.out.println(rbus.getObject("goodMorning"));
		System.out.println(rbjp.getObject("goodMorning"));
		System.out.println(rbus.getObject("goodAfternoon"));
		System.out.println(rbjp.getObject("goodAfternoon"));

		System.out.println("########################");

		HashSet<Locale> set = new HashSet<>();
		/* Comparableインターフェースを実装済み  */
		set.add(loc_us);
		set.add(loc_jp);


	}


	class LocaleComp implements Comparator<Locale>{

		@Override
		public int compare(Locale o1, Locale o2) {
			int a = o1.getCountry().length() > o2.getCountry().length() ? 1 : -1;
			return a;
		}
	}





}
