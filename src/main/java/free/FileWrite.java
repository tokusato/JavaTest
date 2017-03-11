package free;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class FileWrite {

	/**
	 * @param args
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		/* try-with-resource文を用いてファイルストリームの取得を行う */
		/* 複数リソースを同時に記述するときには;を用いて記述を行う */
		try (DataOutputStream dos =
				new DataOutputStream(
						new FileOutputStream("C:\\Users\\webアプリ開発\\Desktop\\aaa.txt"));
			DataInputStream dis =
				new DataInputStream(
						new FileInputStream("C:\\Users\\webアプリ開発\\Desktop\\aaa.txt"))
			) {
			/* try文の中身 */
			dos.writeInt(100);
			dos.writeUTF("田中");
			System.out.println(dis.readInt());
		}


	}

}
