package unix;

import java.io.File;
import java.util.Locale;

import org.unix4j.Unix4j;

/**
 * Unixの機能を提供するUtilクラス
 *
 * */
public class UnixUtil {


	private UnixUtil(){
		/* Utilクラスなので、コンストラクタをprivateにし、インスタンス化不可能にする。 */
	}

	/**
	 * @author toku
	 * */
	public static String catAndCapitalize(File... f){
		String st = Unix4j.cat(f).toStringResult().toUpperCase(Locale.JAPAN);
		return st;
	}


}
