package free;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Iterator;


public class Test10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		Path p = Paths.get("C:\\Users\\webアプリ開発\\Desktop\\abc.txt");

		DosFileAttributeView dfav =
				Files.getFileAttributeView(
					p,
					DosFileAttributeView.class,
					LinkOption.NOFOLLOW_LINKS);//

		try {
			dfav.setReadOnly(true);
			DosFileAttributes dfats  =dfav.readAttributes();

			System.out.println(dfats.fileKey());
			//FileAttributesはFileAttrbutesviewよりも汎用的なファイル属性

			Files.copy(p,new FileOutputStream(
				new File("C:\\Users\\webアプリ開発\\Desktop\\def.txt")));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
//		System.out.println(dfav.setReadOnly(true));


		FileSystem fs = FileSystems.getDefault();
		//パスマッチャー glob構文を用いて実現
		PathMatcher pm = fs.getPathMatcher("glob:***.java");

		//指定したディレクトリ階層のパスにのみマッチkをかける
		try (DirectoryStream<Path> ds =
				Files.newDirectoryStream(
						Paths.get("C:\\Users\\webアプリ開発\\Desktop\\log"))){

			Iterator<Path> ite = ds.iterator();
			Path path = null;
			while(ite.hasNext()){
				path = ite.next();
				if (pm.matches(path))
				System.out.println(path.normalize());
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		/* 通常ここでデータベースとのコネクションをとる */
//		try {
//			//接続するときに発生する例外はSQLException
//			Connection con = DriverManager.getConnection("url");
//			con.setAutoCommit(false);
//
//			Savepoint sp = con.setSavepoint("sv1");
//			con.rollback(sp);
//			con.getMetaData();
//
//			con.commit();
//			Statement stmt = con.createStatement();
//			ResultSet rs = stmt.executeQuery("");
//			CachedRowSet cachedRowSet = RowSetProvider.
//											newFactory().
//												createCachedRowSet();
//			cachedRowSet.populate(rs);
//
//		} catch (SQLException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}






	}

}
