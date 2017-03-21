/**
 *
 */
package design.abstractfctory;

/**
 * @author tokus
 */
abstract class DbFactory {

	//DB毎に異なるメソッドの実装は抽象化し、
	//本クラスを継承するサブクラスに実装を任せる。
	abstract Integer getDefaultPort();
	abstract String getExplamation();

	public static DbFactory getFactory(String dbName){
		//TODO implement this method
		return null;
	}

}
