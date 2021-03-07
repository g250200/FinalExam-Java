package com.vti.backend.presentationlayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.bussinesslayer.IUserService;
import com.vti.backend.bussinesslayer.UserService;
import com.vti.entity.User;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TĐGiang
 * @create_date: Mar 7, 2021
 * @version: 1.0
 * @modifer: TĐGiang
 * @modifer_date: Mar 7, 2021
 */
public class UserController {
	private IUserService userService;
	
	/**
	 * Constructor for class UserController.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 7, 2021
	 */
	public UserController() {
		userService = new UserService();
	}
	
	public User login(String email, String passWord) throws Exception{
		return userService.login(email, passWord);
	}
	public List<User> getlistUserOfProject(int id) throws  Exception{
		return userService.getlistUserOfProject(id);
	}
	public List<User> getManager() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException{
		return userService.getManager();
	}
}
