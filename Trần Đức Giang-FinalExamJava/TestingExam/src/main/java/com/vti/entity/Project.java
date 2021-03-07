package com.vti.entity;

import java.util.List;

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
public class Project {
	private int id;
	private int teamSize;
	
	/**
	 * Constructor for class Project.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 6, 2021
	 */
	public Project() {
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the teamSize
	 */
	public int getTeamSize() {
		return teamSize;
	}

	/**
	 * @param teamSize the teamSize to set
	 */
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}


}
