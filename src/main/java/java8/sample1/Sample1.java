package java8.sample1;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.TreeMap;

public class Sample1 {

	public static void main(String[] args) {
		method1();
		method2();
		method3();
	}

	/**
	 * 文字列の結合を簡単に行うAPI
	 *
	 * @author toku
	 * @param nothing
	 * @return nothing
	 */
	private static void method1() {

		System.out.println("### method1 ###");

		List<String> list = Arrays.asList("aa", "bb", "cc");
		String sep = ",";

		// conventional way(java7)
		StringBuilder sb = new StringBuilder();
		// 基本的に","から付け足していくが、結合文字列が0バイトのときには、","付加は不要
		for (String str : list) {
			if (sb.length() > 0) {
				sb.append(sep);
			}
			sb.append(str);
		}
		System.out.println(sb.toString());

		// new way1
		System.out.println(String.join(sep, list));

		// new way2
		StringJoiner sj = new StringJoiner(sep);
		int counter = 0;
		for (String str : list) {
			sj.add(str);
			// needless to increment counter in separate line
			if (++counter == list.size())
				System.out.println(sj);
		}
	}

	/**
	 * XMLファイルの読み込みを簡単に済ませる。I
	 *
	 * @author toku
	 * @param nothing
	 * @return nothing
	 */
	private static void method2() {

		System.out.println("### method2 ###");

		String xmlPath = ".\\src\\main\\java\\java8\\sample1\\sample.xml";

		// for debuging to know the designation of xml file path
		// File f = new File(xmlPath);
		// System.out.println(f.getAbsolutePath());

		// this is java7
		try {
			List<String> xmlLines = Files.readAllLines(Paths.get(xmlPath), Charset.forName("UTF-8"));
			System.out.println(xmlLines.size());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// java8
		// readAllLines and replace

		List<String> strList = new ArrayList<>();
		try (BufferedReader br = Files.newBufferedReader(Paths.get(xmlPath), Charset.forName("UTF-8"))) {

			br.lines().forEach(l -> {
				strList.add(l.replaceAll("<", "(").replaceAll(">", ")"));
			});
		} catch (IOException ex) {
			// 省略
		}

	}

	/**
	 * 新しくなったMapのAPIを使ってみる。
	 *
	 * @author toku
	 * @param nothing
	 * @return nothing
	 */
	private static void method3() {

		System.out.println("### method3 ###");

		// 1. GETTING DEFAULT VALUE SECTION

		TreeMap<Integer, String> tMap = new TreeMap<>();
		tMap.put(1, "Mary");tMap.put(2, "Tom");

		String defaultValue = "Anonymous";


		// checking to get the default value, if key isn't registered in map

		//this will return Mary
		System.out.println(tMap.getOrDefault(1, defaultValue));
		//this will return Anonymous
		System.out.println(tMap.getOrDefault(3, defaultValue));


		//2. REPLACING EXISTING VALUE

		// replace forciblly. if you want to replace by matching both key and value
		// you have to use another overided method replace
		tMap.replace(1, "Christ");
		System.out.println(tMap.getOrDefault(1, defaultValue));


		//3. OPERATION WITH MATCHED KEY

		// search keys (use initializer)
		int [] intArray = new int[]{2,3,6};

		for (int i : intArray){
			//computeIfPresent can get biFunction as arguments
			tMap.computeIfPresent(i,(k,v) ->  "★★★" + v + "★★★");
		}
		// to see Tom is decorated
		tMap.values().stream().forEach(str -> System.out.println(str));


	}
}
