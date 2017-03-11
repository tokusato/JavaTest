package free;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


public class Test8_Dao {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ConnectionGetter cg = new ConnectionGetter();
		cg.loadClass();
//		cg.loadClassbyDriverManager();
	}

}


/**
 * Daoとのコネクションを確立するためのクラスです。
 * */
class ConnectionGetter{
	static String url = "jdbc:postgresql://localhost:5433/postgres";
    static String user = "postgres";
    static String password = "tonkin1090";

	/**
	 * JDBCドライバをロードするクラスです
	 * */
	public void loadClass(){
		try {
			/* このクラスロードがないとコネクションがはれない */
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		RowSetFactory rsf = null;
		try {
			rsf = RowSetProvider.newFactory();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try(Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet resultSet = stmt.executeQuery("select * from hobby");
			CachedRowSet crs = rsf.createCachedRowSet();
			) {
			/* try with resource文で宣言した変数が有効なのはこのブロックの中のみ */

			/* ResutSetの情報をキャッシュに残しておく */
			crs.populate(resultSet);
			/* DBとの接続が切れても */
			con.close();

			/* データがしっかり残ってる */
			while (crs.next()){
				System.out.printf("%10s , ",crs.getString(2));
				System.out.printf("%1$s \n",crs.getString(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	public void loadClassbyDriverManager() {
		/* このコネクションの確立方法はJDNC4.0より導入されました */
		try {
			DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}





}



