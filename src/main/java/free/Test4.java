package free;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


public class Test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		new DataBaseTest().connect();

	}

}

class DataBaseTest{

	PreparedStatement pstmt;
	//	なお、MySQLの場合に文字列を使う場合は「'楽天(株)'」のように
//	シングルクオーテーション(')で括って記述していましたが、
//			プリペアドステートメントの「setString」メソッドを使う場合には、
//			自動的にデータベースで必要なエスケープ処理をしてくれます。

	public void connect(){
		String url = "jdbc:postgresql://localhost:5433/postgres";
        String user = "postgres";
        String password = "tonkin1090";

        /* 2種類のコネクション確立方法(Class.forName DriverManager) */
        try{
            /* Javaのクラスロードを行う。(差し込んだpostgresのjarを有効にする??) */
        	Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException cnfe){
        	/* 何もしない */
        }

        try (Connection con = DriverManager.getConnection(url, user, password);
        		Statement stmt = con.createStatement();
        		){

        	System.out.println(con.getMetaData().getDatabaseMajorVersion());;
        	System.out.println(con.getMetaData().getCatalogSeparator());;

        	stmt.execute("aaa");
//        	PreparedStatement pstmt = con.prepareStatement("");
//        	executeに引数がないのはpreparedStatementのみ。プリコンパイル時にsql(文字列)を定義しているから。

        	/* トランザクション系を司るのは全てConnectionオブジェクト */
        	con.setAutoCommit(false);
        	Savepoint sv = con.setSavepoint("tokumaru");
        	con.rollback(sv);
        	System.out.println(sv.getSavepointName());
        	con.commit();






        } catch (SQLException e) {
			e.printStackTrace();
		}

	}



}
