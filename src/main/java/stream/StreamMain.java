package stream;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StreamMain {

	public static final String ORACLE_LOG_PATH = "C:\\Program Files\\Oracle\\Inventory\\logs";
	public static final String LOG_INFORMATION_PATTERN="INFO";

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		analyzeLog();
	}

	private static void analyzeLog() {
		//ディレクトリ内のログファイルに対して再帰処理
		try(DirectoryStream<Path> ds =
				Files.newDirectoryStream(Paths.get(ORACLE_LOG_PATH))){
			Iterator<Path> ite = ds.iterator();
			//各ファイルに対しての操作
			Path eachPath;
			while (ite.hasNext()){
				eachPath = ite.next();
				analyzeEachLog(eachPath);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void analyzeEachLog(Path eachPath) {

		try {
			Scanner scanner = new Scanner(eachPath);
//			System.out.println(scanner.delimiter());

			//マッチしないが、原因は不明
			boolean b = scanner.hasNext(Pattern.compile(LOG_INFORMATION_PATTERN));

			String str = scanner.findInLine(LOG_INFORMATION_PATTERN);
			String nextStr= scanner.nextLine();

			System.out.println(eachPath.getFileName() + " : " + str);
			System.out.println(eachPath.getFileName() + " : " + nextStr);



		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//このfinally句の中ですべき処理は何??
			//scannerにcloseメソッドの実装なし。
		}
	}

}
