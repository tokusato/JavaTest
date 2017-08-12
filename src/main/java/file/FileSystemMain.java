package file;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

public class FileSystemMain {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		initialize();

		new FileSystemMain().exec();
	}

	/**
	 * 実行前の初期化処理
	 * */
	private static void initialize() {
		// TODO 自動生成されたメソッド・スタブ

	}

	/**
	 * ファイルシステムに関するAPIを試してみる
	 * */
	private void exec() {
		// TODO 自動生成されたメソッド・スタブ
		FileSystem fs = FileSystems.getDefault();
		System.out.println(fs.getClass().getName());
		System.out.println(fs.getClass().getSimpleName());
		System.out.println(fs.getClass().desiredAssertionStatus());
		//ファイルセパレータの出力
		System.out.println(fs.getSeparator());

		FileSystemProvider fp = fs.provider();

		Iterable<FileStore> fileStoreIterable = fs.getFileStores();

		for (FileStore fStore : fs.getFileStores()){
			try {
				System.out.println(fStore.getTotalSpace());
				System.out.println("volume : " + fStore.getAttribute("volume:vsn"));
				System.out.println("isRemovable : " + fStore.getAttribute("volume:isRemovable"));
				System.out.println("isCdrom : " + fStore.getAttribute("volume:isCdrom"));
				System.out.println(fStore.name());
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}


		Set<String> fileAttributeSet =  fs.supportedFileAttributeViews();

		//当該ファイルシステムで利用可能なファイル属性
		for (String attribute : fileAttributeSet){
			System.out.println(attribute);
		}

	}

}
