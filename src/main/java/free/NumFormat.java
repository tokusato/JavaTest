package free;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;


public class NumFormat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println("日本の数値" + nf.format(5000));
		Locale usLocale = new Locale("en" , "US");
		NumberFormat usnf = NumberFormat.getCurrencyInstance(usLocale);
		System.out.println("アメリカの通貨の単位" + usnf.format(5000));

		DecimalFormat df = new DecimalFormat("###,###,###");
		String str = df.format(123456789);
		System.out.println(str);



	}

}
