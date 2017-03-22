package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnect {

	/**
	 * TESTING ORACLE CONNECTION <br>
	 * C:\app\n\product\12.1.0\dbhome_4\jdbc\lib <br>
	 */

	public static void main(String[] args) {

		try {
			new OracleConnect().connectAndSelect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void connectAndSelect() throws Exception {

		// ユーザ名
//		String user = "sys as sysdba";
		String user = "appuser";
		// パスワード
//		String pass = "tokusato0630";
		String pass = "apppass1234";
		// サーバ名
		String servername = "localhost";
//		String servername = "127.0.0.1";
		// SID
//		String sid = "myorcl";
		String sid = "pdborcl";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ResultSet rset2 = null;

		try {
			// JBBCドライバクラスのロード
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Connectionの作成
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1522:" + sid, user, pass);
			//*************************************************************************************************
			//ポート番号の後はスラッシュ!! -> CDBで接続できたコロンでは、PDBで接続できないので注意!!
			//*************************************************************************************************
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + servername + ":1522/" + sid, user, pass);

			// Statementの作成
			stmt = conn.createStatement();

			// Resultsetの作成
			rset = stmt.executeQuery("select * from dual");

			// 取得したデータを出力する
			while (rset.next()) {
				// this will return X
				System.out.println(rset.getString("DUMMY"));
			}

			// Resultsetの再利用⇒エラーにならない??
			rset2 = stmt.executeQuery("select * from appuser.test1");

			// 取得したデータを出力する
			while (rset2.next()) {
				// this will return X
				System.out.println(rset2.getString("id"));
			}

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Throwable e) {
			throw e;
		} finally {
			try {
				/* クローズ処理 */
				if (rset != null) {
					rset.close();
					rset = null;
				}

				if (stmt != null) {
					stmt.close();
					stmt = null;
				}

				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (Throwable e) {
				// nop
			}
		}
	}
}
