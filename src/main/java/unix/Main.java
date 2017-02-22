package unix;

import static util.CommonUtil.*;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Objects;
import java.util.logging.Logger;


public class Main {

	Logger logger = Logger.getLogger("UNIX_TEST");


	public static void main(String[] args) {
		String rootDir = FILE_UNIX_PATH1;
		//ファイルを読み込み
		new Main().readFileAndCapitalize(rootDir);

	}

	/**
	 * 特定のファイルファイルを読み込み、その内容を大文字にする。
	 * */
	private void readFileAndCapitalize(String rootDir) {

		//PathをString型で指定するときは、絶対パスを解決するようにする。
		Path pt = Paths.get(".", rootDir);
		StringBuilder sb = new StringBuilder();
		String result;
		//指定したディレクトリの直下にあるファイルを操作
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(pt)){

			Iterator<Path> ite = ds.iterator();
			while (ite.hasNext()) {
				Path path = (Path) ite.next();
				System.out.println(path.toRealPath().toString());
				sb.append( path.toRealPath().toString());

				//Objectsクラスのnull判定メソッドを利用して
				if (!Objects.isNull(sb)) logger.info(sb.toString());
				//UnixUtilクラスのメソッドを実行
				result = UnixUtil.catAndCapitalize(path.toFile());
				System.out.println(result);
			}
		}catch (IOException ioe){
			ioe.printStackTrace();
		}
	}



}
