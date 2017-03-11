package free;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Test9_directory {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		/* ディレクトリに対する再帰的なメソッドの実行を行うメインスレッド */
		/* 各ファイルにアクセスしてreadロックをかけてからそのロックを外す。 */

		/* これはディレクトリストリーム作らなかった。 */
		FileSystem fileSystem = FileSystems.getDefault();
		/* watchService */
		try {
			WatchService watchService = fileSystem.newWatchService();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		/* watchserviceはそのクラス内にキューを持っており、poll や takeメソッドより */

		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get("C:\\Users\\n\\Desktop\\dir"))){
			/* そのディレクトリストリームの中のパスに対するiterator */
			Iterator<Path> ite = directoryStream.iterator();

			Path eachPath = null;
			/* DirectoryStreamのiteratorではそのさぶっディレクトリの直下のPath要素にしかアクセスしない */
			while (ite.hasNext()){
				eachPath = ite.next();
				Lock lock = new ReentrantLock();
				lock.tryLock();
				System.out.println("Lock の取得に成功しました。" + eachPath.toAbsolutePath());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
				}
				lock.unlock();
				System.out.println("Lock の解放に成功しました。" + eachPath.toAbsolutePath());
				if (Files.isDirectory(eachPath, LinkOption.NOFOLLOW_LINKS)){
					System.out.println("It's directory");
				}
			}
		} catch(IOException ieo ) {

		}

		System.out.println("これからWALKFILETREE!!Filesメソッドによる実行");
		/* Filesクラスを使ってPathに対する再帰的な処理を行うよ */
		Path initialPath = FileSystems.getDefault().getPath("C:\\Users\\n\\Desktop\\dir");

		SimpleFileVisitor<Path> fileVisitor = new SimpleFileVisitor<Path>(){
			/* 単純にnewすると失敗する */
			/* SimpleFileVisitorクラスを継承する匿名クラスならオッケー */

			/* ローカルでは使われない可能性があることを示唆する警告のアノテーション */
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
				throws IOException
				{
					System.out.println("ディレクトリに訪れた後だよ.");
					return FileVisitResult.CONTINUE;
				}
		};

		/* walkFileTreeを使うには、FilesクラスのwalkFileTreeメソッドを用いる。 */
		try {
			Files.walkFileTree(initialPath, fileVisitor);
		} catch (IOException e) {
			e.printStackTrace();
		}


		/* Fileの読み込みの練習 */
//		URI url = new URI
		Path p = Paths.get("C:\\Users\\n\\Desktop\\abcdef.txt");
		ByteBuffer bb = ByteBuffer.allocate(5024);
		try {
			byte[] byteArray = Files.readAllBytes(p);
			bb = ByteBuffer.wrap(byteArray);
			/* position,limit,capacity */
			final int BYTE = 1;
			System.out.println(bb.remaining());

			/* bb.remainingだと現在のpositionとlimitの差になるから半分までしかいかない */
			for (int i = 0 ; i < bb.capacity() ; i++){
				System.out.println((char)(bb.get()) + "  " + bb.remaining() + "  " +  i + " " + "limit = " + bb.limit() );
				Thread.sleep(10);
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} finally {
			/* 何のリソースを解放すればいいの?? */
		}

		/* Channelは従来のストリームベースの入出力を効率化するための機能 */
		/* SE7では、チャネルの位置を任意に指定することができるSeekableByteChannelインターフェースが導入される */
//		try (SeekableByteChannel seekableByteChannel =
//				Files.newByteChannel(p, StandardOpenOption.APPEND);){
////			 SeekableByteChannel seekableByteChannel2 =
////				Files.newByteChannel(p, StandardOpenOption.READ)){
//			seekableByteChannel.write(bb);
//
//			/* これから読みます */
//			bb.clear();
////			int a = 0;
////			while ((a = seekableByteChannel2.read(bb)) != -1){
////				System.out.println((char)a);
////				System.out.println("a");
////			}
////			System.out.println(seekableByteChannel2.read(bb));
//		} catch (IOException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}

		/* Object型のメソッドをオーバーライドしたインスタンス */
		Object obj = new Object() {

			@Override
			public String toString(){
				return "abcde";

			}
		};
		System.out.println(obj);

	}//mainの終わり



}
