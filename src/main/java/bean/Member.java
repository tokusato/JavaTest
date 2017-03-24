package bean;

/**
 * Simple POJO Class
 * */
public class Member {

	private int id;
	private String name;

	public Member(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id セットする id
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
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
