package com.vti.backend.bussinesslayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
public interface IUserService {
	User login(String email, String passWord) throws Exception;
	List<User> getlistUserOfProject(int id) throws  Exception;
	List<User> getManager() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
}
