package com.vti.frontend;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.backend.presentationlayer.UserController;
import com.vti.entity.User;
import com.vti.ultis.ScannerUtils;

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
public class Function {
	private UserController uController;
	
	
	/**
	 * Constructor for class Function.
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 7, 2021
	 */
	public Function() {
		uController = new UserController();
	}
	
	public void getListManager() {
		List<User> users = null;
		try {
			users = uController.getManager();
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
		for (User user : users) {
			System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullname(),
					"*********", user.getRole());
		}
	}
	
	public void getListUserOfProject() {
		List<User> users = null;
			System.out.println("Mời nhập projectID");
			int projectID = ScannerUtils.inputPositiveInt("ID phải là số lớn hơn 0");
			try {
				users = uController.getlistUserOfProject(projectID);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", "ID", "Email", "Fullname", "Password", "Role");
			for (User user : users) {
				System.out.printf("%-15s %-25s %-25s %-25s %-25s\n", user.getId(), user.getEmail(), user.getFullname(),
						"*********", user.getRole());
			}
	}
	
	public User login() {
		while (true) {
			System.out.print("Mời bạn nhập vào Email của account: ");
			String email = ScannerUtils.inputEmail("Email chưa đúng định dạng.");

			System.out.print("Mời bạn nhập password: ");
			String password = ScannerUtils.inputPassword("Password phai dai tu 6--> 12 ki tu va co it nhat 1 chu viet hoa!");
			try {
				return uController.login(email, password);

			} catch (Exception e) {
				System.err.println(e.getMessage() + "\n");
			}
		}
	}
	
}
