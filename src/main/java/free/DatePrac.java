package free;

import java.text.DateFormat;
import java.util.Date;



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
	}

}
