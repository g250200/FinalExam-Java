package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.datalayer.IUserRepository;
import com.vti.backend.datalayer.UserRepostitory;
import com.vti.entity.User;

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
public class UserService implements IUserService {
	private IUserRepository uRepository;
	
	/**
	 * Constructor for class UserService.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 6, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 6, 2021
	 */
	public UserService() {
		uRepository = new UserRepostitory();
	}
	/* 
	* @see com.vti.backend.bussinesslayer.IUserService#login(java.lang.String, java.lang.String)
	*/
	@Override
	public User login(String email, String passWord) throws Exception {
		// TODO Auto-generated method stub
		return uRepository.login(email, passWord);
	}

	/* 
	* @see com.vti.backend.bussinesslayer.IUserService#getlistUserOfProject(int)
	*/
	@Override
	public List<User> getlistUserOfProject(int id)
			throws Exception {
		if (!uRepository.isProjectIDExist(id)) {
			throw new Exception("project id is not exists");
		}
		return uRepository.getlistUserOfProject(id);
	}

	/* 
	* @see com.vti.backend.bussinesslayer.IUserService#getManager()
	*/
	@Override
	public List<User> getManager() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		
		return uRepository.getManager();
	}

}
