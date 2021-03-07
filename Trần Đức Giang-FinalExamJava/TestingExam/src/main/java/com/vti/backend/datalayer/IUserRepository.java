package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.entity.Project;
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
public interface IUserRepository {
	
	boolean isProjectIDExist(int projectID) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	
	User login(String email, String passWord) throws Exception;
	List<User> getlistUserOfProject(int id) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException;
	List<User> getManager() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException;
}
