package hibernate;

import static util.CommonUtil.*;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;

import oracle.OracleConnector;

/**
 * test to use hibernate framework
 *
 */
public class HibernateSample {

	public static void main(String[] args) {

		// 1. reading oracle connection configuration
		OracleConnector oc = getOracleConnectorionByJaxb();
		// 2. get Oracle Connection
		Connection con = getOracleConnction(oc);

	}

	private static OracleConnector getOracleConnectorionByJaxb() {

		String xmlPath = ROOT_PATH + "util/OracleConnectoror.xml";
		try {
			return JAXB.unmarshal(new File(xmlPath), OracleConnector.class);
		} catch (DataBindingException dbe) {
			dbe.printStackTrace();
		}
		return null;
	}

	private static Connection getOracleConnction(OracleConnector oc) {

		Connection con = null;

		try {
			// load driver class
			Class.forName(ORACLE_DRIVER_CLASS);
			// return Connection
			con = DriverManager.getConnection( oc.getConnectionString() );

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return con;
	}

}
