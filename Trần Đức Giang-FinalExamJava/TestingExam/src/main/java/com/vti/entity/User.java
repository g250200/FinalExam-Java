package com.vti.entity;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TĐGiang
 * @create_date: Mar 6, 2021
 * @version: 1.0
 * @modifer: TĐGiang
 * @modifer_date: Mar 6, 2021
 */
public class User {
	private int id;
	private String fullname;
	private String email;
	private String passWord;
	private Role role;
	
	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 6, 2021
	 */
	public User(int id,String fullname, String email, String passWord, Role role ) {
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.passWord = passWord;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}

	/* 
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "User [id=" + id + ", fullname=" + fullname + ", email=" + email + ", passWord=" + passWord + ", role="
				+ role + "]";
	}
	
}
