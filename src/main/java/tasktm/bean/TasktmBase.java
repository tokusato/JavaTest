package tasktm.bean;

import java.util.Date;
import java.util.Map;

/**
 * TASKTMの基本を表現するクラス
 * */
public class TasktmBase {

	private Date fDate;
	private long sqlMilliTime;
	private String transactiontype;


	//TODO implement this constructor
	public TasktmBase(Map<String, String> tasktmMap) {
	}
	/**
	 * @return fDate
	 */
	public Date getfDate() {
		return fDate;
	}
	/**
	 * @param fDate セットする fDate
	 */
	public void setfDate(Date fDate) {
		this.fDate = fDate;
	}
	/**
	 * @return sqlMilliTime
	 */
	public long getSqlMilliTime() {
		return sqlMilliTime;
	}
	/**
	 * @param sqlMilliTime セットする sqlMilliTime
	 */
	public void setSqlMilliTime(long sqlMilliTime) {
		this.sqlMilliTime = sqlMilliTime;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}



}
