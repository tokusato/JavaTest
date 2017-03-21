package google.guava;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.common.base.CaseFormat;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;

public class GuavaSample {

	//本クラスのロガー
	static Logger logger  = Logger.getLogger("GUAV TEST");

	public static void main(String[] args) {

		//Check the behavior of Optional
		//It throws NullPointer when it "get()" the value
		exec1();

		//Conversion from camelCase(e.g. strStr) to snakeCase(e.g. str_str)
		exec2();

		//Join the Collection String in one line
		//this may be easily realized by lambda equotation
		exec3();
	}

	private static void exec1() {

		//メソッド名を取得するログ
		logger.log(Level.INFO, new Throwable().getStackTrace()[0].getMethodName());
		Optional<Integer> opt1 = Optional.of(new Integer(10));
		System.out.println(opt1.get());

		try {
		Optional<Integer> opt2 = Optional.of(null);
		System.out.println(opt2.get());
		} catch (NullPointerException ne){
			System.out.println(ne.getClass().toGenericString() + " :  Occured");
		}
	}

	private static void exec2() {
		//ちょっとログをカスタマイズしてみる。
		//以下2つは、少なくともコンソールには出力されない。
//		logger.log(Level.ALL, new Throwable().getStackTrace()[0].getMethodName());
//		logger.log(Level.FINEST, new Throwable().getStackTrace()[0].getFileName());
		logger.log(Level.INFO, new Throwable().getStackTrace()[0].getMethodName());

		String camel = "userId";
		String snake = CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE,camel);

		assert snake.equals("user_id") : "Camel => Snake Conversion Failed";
		System.out.println("aaa");
	}

	private static void exec3() {
		logger.log(Level.INFO, new Throwable().getStackTrace()[0].getMethodName());

		List<String> strList = Arrays.asList("Tom","Mary","John");

		//セパレータの逆。連結子みたいなのを定義している。
		String joined1 = Joiner.on(" , ").join(strList);

	}


}
