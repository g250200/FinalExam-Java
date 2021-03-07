package com.vti.backend.datalayer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Project;
import com.vti.entity.Role;
import com.vti.entity.User;
import com.vti.ultis.JdbcUtils;

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
public class UserRepostitory implements IUserRepository{

	/* 
	* @see com.vti.backend.datalayer.IUserRepository#login(java.lang.String, java.lang.String)
	*/
	@Override
	public User login(String email, String passWord) throws Exception {
		Connection connection = JdbcUtils.connect();
		String sql = "SELECT * FROM user " + "WHERE Email = ? AND Password = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, passWord);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			int userId = resultSet.getInt("UserID");
			String fullName = resultSet.getString("FullName");
			Role role = Role.valueOf(resultSet.getString("Role"));

			User user = new User(userId, fullName, email, passWord, role);
			JdbcUtils.disconnect();
			return user;
		}
		else {
			JdbcUtils.disconnect();
			throw new Exception("User or password is not exists!");
		}
	}

	

	/* 
	* @see com.vti.backend.datalayer.IUserRepository#getManager()
	*/
	@Override
	public List<User> getManager() throws SQLException, FileNotFoundException, ClassNotFoundException, IOException {
		List<User> users = new ArrayList<User>();
		
		Connection connection = JdbcUtils.connect();
		Statement statement = connection.createStatement();
		String sql = "SELECT * FROM testingexam.user WHERE Role = 'Manager'; ";
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			int id = resultSet.getInt("UserID");
			String fullName = resultSet.getString("FullName");
			String email = resultSet.getString("Email");
			String password = resultSet.getString("Password");
			Role role = Role.valueOf(resultSet.getString("Role"));

			User user = new User(id, fullName, email, password, role);
			users.add(user);
		}
		JdbcUtils.disconnect();
		return users;
	}



	/* 
	* @see com.vti.backend.datalayer.IUserRepository#getlistUserOfProject(int)
	*/
	@Override
	public List<User> getlistUserOfProject(int projectId)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		List<User> users = new ArrayList<User>();
		
		Connection connection = JdbcUtils.connect();
		String sql = "SELECT * FROM testingexam.user WHERE projectID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, projectId);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			int id = resultSet.getInt("UserID");
			String fullName = resultSet.getString("FullName");
			String email = resultSet.getString("Email");
			String password = resultSet.getString("Password");
			Role role = Role.valueOf(resultSet.getString("Role"));

			User user = new User(id, fullName, email, password, role);
			users.add(user);
		}
		JdbcUtils.disconnect();
		return users;
	}



	/* 
	* @see com.vti.backend.datalayer.IUserRepository#isProjectIDExist(int)
	*/
	@Override
	public boolean isProjectIDExist(int projectID) throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Connection connection = JdbcUtils.connect();
		
		String sql = " SELECT * FROM project WHERE projectID = ? ";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, projectID);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (resultSet.next()) {
			return true;
		}
		return false;
	}

}
