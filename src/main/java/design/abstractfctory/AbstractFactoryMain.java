package design.abstractfctory;

public class AbstractFactoryMain {

	//ソースは同じだが、実行環境の違いに対応できるプログラムの作成を目指す。
	//ある環境では、Postgresだが、ある環境はOracle
	public static void main(String[] args) {

		//引数の違いによってDBの違いを識別する。
		//ここでは簡易的にPostgresの場合を考えてみる。
		args[0] = "Postgres";
		//煩雑になるため、switch文などは利用しない。
//		DbFactory factory = Dbfactory.getFactory(args[0]);
		DbFactory factory = DbFactory.getFactory(args[0]);


	}

}
