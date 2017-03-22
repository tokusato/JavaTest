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
	 * aaa
	 *
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

		// Marshalするものは、beanでないといけない。
		// 標準出力へXML書き出し( for 動作確認 )
		JAXB.marshal(tb1, System.out);

		String xmlPath = CommonUtil.ROOT_PATH + "jaxb/bean.xml";

		try {
			JAXB.marshal(tb1, new FileOutputStream(new File(xmlPath)));
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