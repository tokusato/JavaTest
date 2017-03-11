package free;

import static java.nio.file.StandardWatchEventKinds.*;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;


public class Test7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File f = new File("C:\\Users\\n\\Desktop\\abc.txt");
		URI uri = f.toURI();
		System.out.println(uri.getAuthority());
		System.out.println(uri.getFragment());
		System.out.println(uri.getHost());
		System.out.println(uri.getPath());
		System.out.println(uri.getPort());//ローカルホスト上だと-1をリターンする。
		System.out.println(uri.getQuery());
		System.out.println(uri.toString());
		try {
			System.out.println(uri.toURL());
			System.out.println(uri.parseServerAuthority());
		} catch (MalformedURLException | URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println("##############");
//		FileSystem fs = FileSystems.getFileSystem(uri);
		Path p1  = Paths.get(uri);
		System.out.println(p1.endsWith("abc.txt"));	//true
		System.out.println(p1.endsWith("txt"));		//false →もっとも遠い要素そのものにマッチするかどうかのチェックを行っている。

		Path p2 = Paths.get("C:\\Users\\n\\Desktop\\abcdef.txt");

		/* Fileを扱うユーティリティクラス */
		try {
			//2回目の実行には失敗。
//			Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES);
			//存在する場合には、以下のコピーオプションを使用する。
			Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		DosFileAttributeView dosView = Files.getFileAttributeView(p2, DosFileAttributeView.class);
		BasicFileAttributeView basicView = Files.getFileAttributeView(p1,BasicFileAttributeView.class);
		System.out.println(dosView.name());//dos
		try {
			/* readAttributesはファイルの属性を読みとるため、IOExceptionを投げる可能性がある。 */
			System.out.println(dosView.readAttributes().lastModifiedTime());
			/* Fileの時刻を管理するFileTimeクラスを使ってコーディングしてみる。 */
			FileTime ft = dosView.readAttributes().creationTime();
			DateFormat df = DateFormat.getInstance();
			try {
				Date d = df.parse((df.format(new Date(ft.toMillis()))).toString());
				System.out.println("success to parse the data into Date");
			} catch (ParseException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			FileVisitResult fvr = FileVisitResult.CONTINUE;

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//BasicFileAttributeViewクラスの利用方法
		//多くのファイルシステムで一般的なファイル属性の基本セットのビューを提供するファイル属性ビューで
		//ファイル属性の基本セットは、BasicFileAttributes インタフェースで定義されている必須およびオプションのファイル属性で構成されます。

		try {
			BasicFileAttributes  bAttributes = Files.readAttributes(p2,BasicFileAttributes.class);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		/* File入力をFilesクラスから行ってみる */
		SortedMap smap = Charset.availableCharsets();
		Set<Entry<String,Charset>> entrySet = smap.entrySet();
		Iterator<Entry<String,Charset>> ite = entrySet.iterator();
		/* 有効なCharSetの一覧を出力してみる。 */
		int i = 0;
		while (ite.hasNext()){
			++i;
			/* break文はif文を抜けない。 */
			if (i > 100) break;
			/* %2$20sの意味⇒第2引数を文字列で表示する。その際、文字列は20文字分確保する。 */
			System.out.printf("key is   %2$20s value is   %1$20s  \n  ",ite.next().getValue(),ite.next().getKey());
		}

		List<String> list = null;
		try {
			/* Filesクラスを用いたFileの読み込みには、エンコード方法の指定が必要 */
			list  = Files.readAllLines(p2, Charset.forName("MS932"));

			/* UTF-8やUTF-16などの不適切なcharSetを用いるとMalformedInputExceptionがthrowされる。 */
//			list  = Files.readAllLines(p2, Charset.forName("UTF-16"));
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()){
//			System.out.println(iter.next());
			/* 変数が10文字を超える場合には10文字を超えて出力される。 */
			/* 10文字に満たない場合には10文字分のバッファをもって出力される。 */
			System.out.printf("%1$10s  10文字を超えてしまいましたね\n" , iter.next());
		}




		/* WatchServiceでパスで指定したファイルんい対する変更を監視する。 */
		try {
			/* WatchServiceのインスタンス作成の段階でIOExceptionが発生すのはなんで?? */
			WatchService ws = FileSystems.getDefault().newWatchService();
			/* staticインポートすることでenumクラスの定数をそのまま呼び出すことができる。 */

			/* WatchServiceやりたいときには、パスとしてディレクトリを設定しなくてはならない。 */
			p2.register(ws, ENTRY_CREATE);

			WatchKey key = null;
			while (true){
				try {
					key = ws.take();
				} catch (InterruptedException e) {
					//queueに入るまでスレッドが待機状態となるため。
				}
				/* ここまで処理がくるということは、イベントがキューの中に入ったということ。 */


				List<WatchEvent<?>> eventList = key.pollEvents();
//				Iterator<WatchEvent<?>> ite = eventList.iterator();
//				while (ite.hasNext()){
//					ite.next().context();
//					ite.next().kind();
//				}
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}




	}

}
