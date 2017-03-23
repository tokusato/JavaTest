package jaxb;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import util.CommonUtil;

public class JaxbSample {
	/**
	 * testing the function of jaxb<br>
	 * <p>
	 * @author n
	 * @param execution
	 *            arguments
	 * @return nothing
	 * @throws nothing
	 * @since 1.0
	 */
	public static void main(String args[]) {
		new JaxbSample().marshal();
	}

	/**
	 * try to marshal some JavaObject -> xml
	 */
	private void marshal() {

		// generate Java Object
//		TestBean tb1 = new TestBean(1, "Tom");
		TestBean tb1 = new TestBean(1, null);
		OracleConnector oc = new OracleConnector("localhost", 1522, "pdborcl", "appuser", "apppass1234");

		// Marshalするものは、beanでないといけない。
		// 標準出力へXML書き出し( for 動作確認 )
		JAXB.marshal(tb1, System.out);

		String xmlPath = CommonUtil.ROOT_PATH + "jaxb/bean.xml";
		String oraXmlPath = CommonUtil.ROOT_PATH + "jaxb/oraBean.xml";

		try {
			JAXB.marshal(tb1, new FileOutputStream(new File(xmlPath)));
			JAXB.marshal(oc, new FileOutputStream(new File(oraXmlPath)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// これからunmarshal処理
		try {

			//BE CAREFUL!! BEAN CLASS NEEDS DEFAULT CONSTRUCTOR
			TestBean umBean = JAXB.unmarshal(new File(xmlPath), TestBean.class);
			System.out.println(umBean.getName());

		} catch (DataBindingException dbe) {
			// BE CAREFUL TO HANDLE EXCEPTION
			dbe.printStackTrace();
		}

	}
}

/**
 * memo
 * <p>XmlAccessType.FIELD -> フィールドのみXMLにバインドされる。
 * <p>XmlRootElement -> クラスをXMLタグへマッピングする。
 * <p>
 * */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="testBean",namespace="original.namespace")
class TestBean {


	//memo -> nillable means it allow user to set null to bean

	@XmlElement(name="id", nillable=true, required=true)
	private int id;
	@XmlElement(name="name", nillable=true, required=true)
	private String name;

	public TestBean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/** for unmarshal!! */
	public TestBean() {
		super();
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}

/**
 * Oracle DB との接続を表現するクラス
 * */
class OracleConnector{

	/** server name */
	private String serverName;
	/** port number */
	private int portNumber;
	/** sid */
	private String sid;
	/** user */
	private String user;
	/** password */
	private String password;

	/** constructor using all fields */
	public OracleConnector(String serverName, int portNumber, String sid, String user, String password) {
		super();
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.sid = sid;
		this.user = user;
		this.password = password;
	}
	/**
	 * @return serverName
	 */
	public String getServerName() {
		return serverName;
	}
	/**
	 * @param serverName セットする serverName
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	/**
	 * @return portNumber
	 */
	public int getPortNumber() {
		return portNumber;
	}
	/**
	 * @param portNumber セットする portNumber
	 */
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	/**
	 * @return sid
	 */
	public String getSid() {
		return sid;
	}
	/**
	 * @param sid セットする sid
	 */
	public void setSid(String sid) {
		this.sid = sid;
	}
	/**
	 * @return user
	 */
	public String getUser() {
		return user;
	}
	/**
	 * @param user セットする user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}


}