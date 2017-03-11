package free;

/* このクラスのstatic変数に対してアクセス可能とする(enum) */
import static java.nio.file.StandardWatchEventKinds.*;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.DosFileAttributeView;
import java.util.Iterator;

public class Test3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		FileSystem fs = FileSystems.getDefault();
		Iterable<FileStore> fileStore = fs.getFileStores();

		fs.getRootDirectories();

		for (Path p : fs.getRootDirectories()){
			/* ボリュームを出力 */
			System.out.println(p);
		}
		for (FileStore fstore : fs.getFileStores()){
			System.out.println(fstore);
			try {
				System.out.println(fstore.getTotalSpace());
				System.out.println(fstore.supportsFileAttributeView(DosFileAttributeView.class));
			} catch (IOException e) {
				System.out.println("IOException occured");
			}
		}

		System.out.println("############### DirectoryStream ###############");

		/* DirectoryStream */
		Path p = Paths.get("C:\\Users\\n\\Desktop\\dir");
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(p)){
			/* DirectorStreamで特徴的なメソッドはない。Pathをイテレータとして用いることができる */
			Iterator<Path> ite = ds.iterator();
			while (ite.hasNext()){
				System.out.println(ite.next().normalize());
			}
//			for (Path p : ds.iterator().){
//			}
		} catch (IOException ioe){
		}

		System.out.println("############### AutoClosable ###############");
		/* AutoClose のSuppressedWarningの確認 */
		try ( OriginalAutoClose oac = new OriginalAutoClose()){
			/* closeが呼び出されるのは、例外をcatchする直前 */
			throw new IOException();
		} catch (Exception e){
		Throwable t[] = e.getSuppressed();
		System.out.println(t[0]);


		/* ここのcatch節でとらえられないものは抑止例外の配列に入れることができない */
//		} catch (IOException ioe){
//			Throwable[] t = ioe.getSuppressed();
//			System.out.println(t[0]);
		}


		System.out.println("############### WatchService ###############");

		WatchService ws = null;
		try {
			ws = fs.newWatchService();
			/* p: C:\Users\n\Desktop\dir */
			p.register(ws, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY, OVERFLOW);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* mainスレッドに割込みを入れるための方法 */
		/* 匿名クラス内で用いることのできる変数(参照)はfinal修飾子が必要 */
		final Thread t_main = Thread.currentThread();
		/* タイマースレッドの作成 */
		Thread t_timer = new Thread(new Runnable() {
			int a = 0;
			@Override
			public void run() {
				int b = 0;
				// TODO 自動生成されたメソッド・スタブ
				try {
					Thread.sleep(3000);
					t_main.interrupt();
					System.out.println("from timer");
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		});

		t_timer.start();


		while (true){
			//この無限ループの中でイベントの発生を待つ
			WatchKey key = null;
			try {
				key = ws.take();
			} catch (InterruptedException ie){
				/* 割込みが入ってしまいました。 */
				System.out.println("割込みが入って終了しました。");
			} finally {

				try {
					ws.close();
				} catch (IOException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}

			for (WatchEvent<?> event : key.pollEvents()){
				System.out.println(event.context());
				System.out.println(event.kind());
				Kind<?> kind = event.kind();
				switch (kind.name()){


				case "ENTRY_CREATE":
				System.out.println("何か作られたよ!!");
					break;

				case "ENTRY_MODIFY":
					System.out.println("何か修正されたよ!!");
						break;
				}

				key.reset();

			}


		}










	}

}

class OriginalAutoClose implements AutoCloseable{

	@Override
//	public void close() throws Exception {
//		// TODO 自動生成されたメソッド・スタブ
//
//	}

	/* throwsを実装しないと抑制例外に入らないよ。 */
	public void close() throws OriginalException{
			throw new OriginalException();
	}

	class OriginalException extends Exception{
		/* このクラスで発生する例外を表すクラス */
	}

}
