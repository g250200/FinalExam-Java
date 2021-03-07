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
public class Manager extends User {
	private int expInYear;
	
	/**
	 * Constructor for class Manager.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 6, 2021
	 */
	public Manager(int id,String fullname, String email, String passWord, Role role ,int exInYear) {
		super(id, fullname, email, passWord, role);
		this.expInYear = exInYear;
	}

	/**
	 * @return the expInYear
	 */
	public int getExpInYear() {
		return expInYear;
	}

	/**
	 * @param expInYear the expInYear to set
	 */
	public void setExpInYear(int expInYear) {
		this.expInYear = expInYear;
	}

	/* 
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Manager [expInYear=" + expInYear + ", getId()=" + getId() + ", getFullname()=" + getFullname()
				+ ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getRole()=" + getRole() + "]";
	}
	
}
