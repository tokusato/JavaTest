package file;

import static java.util.logging.Level.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
public class PathMain {

	public static void main(String[] args) {

		// executing path check by another single thread
		Runnable r = () -> { pathCheck();};
		new Thread(r).start();

//		pathCheck();
	}

	private static void pathCheck() {

		//ログの設定 -> 別途ログのパッケージを作成し、利用方法を学習する。
		final Logger LOG = Logger.getGlobal();
		FileHandler fileHandler = null;
		try {
			fileHandler = new FileHandler(".\\log\\pathLog.txt", false);
			fileHandler.setFormatter(new SimpleFormatter());
			LOG.addHandler(fileHandler);
			LOG.log(INFO, "IN THE METHOD");


			/* Pathの検証 */
			Path p = Paths.get(".");
			//絶対パスの取得(デフォルトでは、パッケージの階層が取得される。)
			System.out.println(p.toAbsolutePath());
			//デフォルトでは、Pathを生成したときの.(カレントディレクトリ)が含まれている
			// -> true
			System.out.println(p.endsWith("."));
			// -> false
			System.out.println(p.endsWith("JavaTest"));
			// -> true
			System.out.println(p.toAbsolutePath().normalize().endsWith("JavaTest"));

			// -> D:\git\mytrainrepo\JavaTest
			Path pa = p.toAbsolutePath().normalize();
			// -> D:\
			System.out.println(pa.getRoot());
			// -> JavaTest (NOT FILE!!)
			System.out.println(pa.getFileName());
			// -> D:\git\mytrainrepo
			System.out.println(pa.getParent());
			// ->3
			System.out.println(pa.getNameCount());

			System.out.println("###### loop ######");
			// loop section1
			for (int i = 0 ; i < pa.getNameCount() ; i++)
				System.out.println(pa.getName(i));
			// loop section2
			Iterator<Path> ite = pa.iterator();
			while (ite.hasNext()) System.out.println(ite.next());
			System.out.println("###### loop ######");


			//**********************************
			System.out.println("#############");
			System.out.println(Files.getAttribute(Paths.get("C:\\Users\\n\\Desktop\\rootログイン192.168.1.2.ttl"), "creationTime"));
			System.out.println(Files.getLastModifiedTime(Paths.get("C:\\Users\\n\\Desktop\\rootログイン192.168.1.2.ttl")));
			System.out.println("#############");
			//***********************************


			/* FileSystemの検証 */
			FileSystem fs = p.getFileSystem();

			System.out.println("###### supportedFileAttributeViews ######");
			for (String supported : fs.supportedFileAttributeViews())
				System.out.println(supported);

			// -> \
			System.out.println(fs.getSeparator());

			System.out.println("###### supportedFileStore ######");
			for (FileStore fStore : fs.getFileStores()){
				System.out.println("タイプ : " + fStore.type());
				System.out.println("名前 : " + fStore.name());
				System.out.println(String.valueOf(fStore.getTotalSpace()/1024/1024) + "MB" );
			}

			//リフレクションを利用してstaticなFilesクラスに関するメソッドを実行してみる。
			String str = Files.class.getName();
			Class<?> clazz = Class.forName(str);
			// -> FAIL
//			clazz.newInstance();

//			clazz.getMethod("newDirectoryStream", pa, "*.java");
			Method method =clazz.getMethod("size",Path.class);
			//static メソッドのため、第一引数はnull
			Object ret = method.invoke(null, pa);
			System.out.println("result : " + ret);

		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


//		for (Path p1 : p.forEach(action);)

	}




}
