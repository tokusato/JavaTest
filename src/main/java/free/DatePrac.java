package free;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;



public class DatePrac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance();
		System.out.println(df.getCalendar());
		System.out.println(df.format(dt));


		int counter = 0;
		for (Locale lc : df.getAvailableLocales()){
			counter++;
			System.out.println(String.valueOf(counter) + " : "+ lc.getCountry());
			System.out.println(String.valueOf(counter) + " : "+ lc.getDisplayLanguage());
		}

		Date d = new Date();

	}

}
