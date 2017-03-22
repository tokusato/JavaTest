package apache.common;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class AppacheCommonSample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		method1();
		method2();
	}

	/**
	 * apache.commonsパッケージで便利なapiを試してみる。
	 * デバッグに便利なリフレクションメソッド(オブジェクトの中身も含めてダンプする)
	 * (注意)：リフレクションを用いているため、実行速度は低下する。
	 * */
	private static void method1() {
		  List<String> xs = Arrays.asList("x", "y", "zz");
		  // 出力例: "java.util.Arrays$ArrayList@1697b67[a={x,y,zz}]"
		  System.out.println(ReflectionToStringBuilder.toString(xs));
	}

	/**
	 * null か 空文字を判定するメソッド isEmpty
	 * ⇒今までは、nullかサイズが0かを同時に判定することができなかった。
	 *
	 * */
	private static void method2() {

		//expecting element 0->false, 1->true, 2 -> true
		List<String> strList = Arrays.asList("Tom","",null);

		strList.stream().forEach(
							str -> System.out.println(StringUtils.isEmpty(str)));

	}
}
