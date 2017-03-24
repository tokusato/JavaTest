package oracle;

import static util.CommonUtil.*;

/**
 * Oracle DB との接続を表現するクラス
 */
public class OracleConnector {

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
	 * @param serverName
	 *            セットする serverName
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
	 * @param portNumber
	 *            セットする portNumber
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
	 * @param sid
	 *            セットする sid
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
	 * @param user
	 *            セットする user
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
	 * @param password
	 *            セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * <p> this method returns null if someone set null to each member
	 * <p> after instanciation
	 * @return connection String
	 */
	public String getConnectionString() {

		// StringBuilder sb = new StringBuilder();
		// sb.append(THIN_DRIVER);
		// sb.append(COLON);
		// sb.append(String.valueOf(oc.getPortNumber()));
		// sb.append(SLASH);
		// sb.append(oc.getSid());
		// sb.append(oc.getSid());
		// return password;

		StringBuilder sb = new StringBuilder();
		if (this != null) {
			sb.append(THIN_DRIVER);
			sb.append(this.getUser());
			sb.append(SLASH);
			sb.append(this.getPassword());
			sb.append(ATMARK);
			sb.append(this.getServerName());
			sb.append(COLON);
			sb.append(String.valueOf(this.getPortNumber()));
			sb.append(SLASH);
			sb.append(this.getSid());
		}
		return sb.toString();

	}

}