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
public class Employee extends User {
	private String proSkill;
	private Project project;
	
	
	/**
	 * Constructor for class Employee.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 6, 2021
	 */
	public Employee(int id,String fullname, String email, String passWord, Role role, String proSkill, Project project ) {
		super(id, fullname, email, passWord, role);
		this.proSkill = proSkill;
		this.project = project;
	}


	/**
	 * @return the proSkill
	 */
	public String getProSkill() {
		return proSkill;
	}


	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}


	/**
	 * @param proSkill the proSkill to set
	 */
	public void setProSkill(String proSkill) {
		this.proSkill = proSkill;
	}


	/**
	 * @param project the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}


	/* 
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return "Employee [proSkill=" + proSkill + ", project=" + project + ", getId()=" + getId() + ", getFullname()="
				+ getFullname() + ", getEmail()=" + getEmail() + ", getPassWord()=" + getPassWord() + ", getRole()="
				+ getRole() + "]";
	}
	
}
