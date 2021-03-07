package com.vti.frontend;
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
public class Program {
	static Function function = new Function();
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TĐGiang
	 * @create_date: Mar 7, 2021
	 * @version: 1.0
	 * @modifer: TĐGiang
	 * @modifer_date: Mar 7, 2021
	 * @param args
	 */
	public static void main(String[] args) {
		program();

	}
	
	public static void program() {
		while (true) {
			System.out.println("Nhập lựa chọn");
			System.out.println("1: Login");
			System.out.println("2: thoát ra khỏi chương trình");
			int n = ScannerUtils.inputFunction(1, 2, "chọn 1 or 2");
			switch (n) {
			case 1:
				System.out.println("MỜI BẠN LOGIN");
				User user = function.login();
				System.out.println("Login successfull!");
				System.out.println("Chào mừng " + user.getFullname() + "!");
				menu();
				continue;

			default:
				return;
			}
		}
	}
	
	public static void menu() {
		boolean a = true;
		while (a) {
			System.out.println("Mời nhập chức năng");
			System.out.println("1: get list manager");
			System.out.println("2: get User of project");
			System.out.println("3: Đăng xuất");
			int chose = ScannerUtils.inputFunction(1, 3, "chọn 1 or 2 or 3");
			switch (chose) {
			case 1:
				function.getListManager();
				break;
			case 2:
				function.getListUserOfProject();
				break;
			default:
				System.out.println("Đăng xuất");
				a = false;
			}
		}
	}

}
