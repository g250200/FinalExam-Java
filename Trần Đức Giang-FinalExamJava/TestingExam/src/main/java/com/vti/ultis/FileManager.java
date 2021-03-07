package com.vti.ultis;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;


public class FileManager {
	public static final String FILE_EXISTS = "File is exits!";
	public static final String FILE_NOT_EXISTS = "Error! File Not Exist.";
	public static final String FOLDER_EXISTS = "Folder is exits!";
	public static final String FOLDER_NOT_EXISTS = "Folder is not exits!";
	public static final String PATH_NOT_FOLDER = "Error! Path is not folder.";

	public static final String SOURCE_FILE_NOT_EXISTS = "Source File is not exits!";
	public static final String DESTINATION_FILE_EXISTS = "Destination File is exits!";

	public static final String NEW_FILE_EXISTS = "Error! New File Exist.";
	public static final String CREATE_FILE_SUCCESS = "Create file success!";
	public static final String CREATE_FILE_FAIL = "Create file fail!";
	public static final String DELETE_FILE_SUCCESS = "Delete file success!";
	public static final String DELETE_FILE_FAIL = "Delete file fail!";

	public static boolean isFileExists(String pathFile) {
		File file = new File(pathFile);
		if (file.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isFolderExists(String pathFolder) {
		File file = new File(pathFolder);
		if (file.exists()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void createFile(String pathFile) throws Exception {
		if (isFileExists(pathFile)) {
			throw new Exception(FILE_EXISTS);
		}
		boolean result = new File(pathFile).createNewFile();
		if (result) {
			System.out.println(CREATE_FILE_SUCCESS);
		}
		else {
			System.out.println(CREATE_FILE_FAIL);
		}

	}
	public static void createFile(String path , String fileName) throws Exception {
		String pathFile = path + "\\"+fileName;
		createFile(pathFile);
	}
	
	public static void deleteFile(String pathFile) throws Exception {
		if (isFileExists(pathFile)) {
			boolean result = new File(pathFile).delete();
			if (result) {
				System.out.println(DELETE_FILE_SUCCESS);
			}
			else {
				System.out.println(DELETE_FILE_FAIL);
			}
		}
		else {
			throw new Exception(FILE_NOT_EXISTS);
		}
	}
	
	public static boolean isFolderOrFile(String path) {
		return new File(path).isDirectory();
	}
	
	public static List<String> getAllFileName(String path) throws Exception {
		File file = new File(path);
		if (!file.isDirectory()) {
			throw new Exception(PATH_NOT_FOLDER);
		}
		return Arrays.asList(file.list());
	}
	public static void copyFile(String sourceFile, String distinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		String[] strings = sourceFile.split("\\\\");
		String nameFile = strings[strings.length-1];
		String distinationFile = distinationPath +"\\"+nameFile;
		if (isFileExists(distinationFile)) {
			throw new Exception(DESTINATION_FILE_EXISTS);
		}
		
		File source = new File(sourceFile);
		File distination = new File(distinationFile);
		Files.copy(source.toPath(), distination.toPath());
	}
	public static void copyFile(String sourceFile, String destinationPath, String newName) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		String distinationFile = destinationPath +"\\"+newName;
		if (isFileExists(distinationFile)) {
			throw new Exception(DESTINATION_FILE_EXISTS);
		}
		File source = new File(sourceFile);
		File distination = new File(distinationFile);
		Files.copy(source.toPath(), distination.toPath());
	}
	
	public static void moveFile(String sourceFile, String destinationPath) throws Exception {
		if (!isFileExists(sourceFile)) {
			throw new Exception(SOURCE_FILE_NOT_EXISTS);
		}
		if (!isFolderExists(destinationPath)) {
			throw new Exception(FOLDER_NOT_EXISTS);
		}
		File source = new File(sourceFile);
		File distination = new File(destinationPath);
		Files.move(source.toPath(), distination.toPath());
	}
	
	public static void renameFile(String pathFile, String newName) throws Exception {

		if (!isFileExists(pathFile)) {
			throw new Exception(FILE_NOT_EXISTS);
		}
		String[] strings = pathFile.split("\\\\");
		String pathFolder = strings[0];
		for (int i = 1; i < strings.length-1; i++) {
			pathFolder = pathFolder + "\\" + strings[i]; 
		}
		String pathNewFile = pathFolder +"\\"+ newName;
		if (isFileExists(pathNewFile)){
			throw new Exception(NEW_FILE_EXISTS);
		}
		File oldFile = new File(pathFile);
		File newFile = new File(pathNewFile);

		oldFile.renameTo(newFile);
	}

	public static void createFolder(String pathFolder) throws Exception {
		if (isFolderExists(pathFolder)) {
			throw new Exception(FOLDER_EXISTS);
		}
		new File(pathFolder).mkdir();
	}
	
	public static void downloadFile(String fileLink, String pathFolder) throws Exception {
		if (!isFolderExists(pathFolder)) {
			createFolder(pathFolder);
		}
		
		String[] strings = fileLink.split("/");
		String name = strings[strings.length-1];
		String pathFile = pathFolder + "\\"+name;
		
		URL url = new URL(fileLink);
		URLConnection urlConnection = url.openConnection();
		int size = urlConnection.getContentLength();
		InputStream inputStream = urlConnection.getInputStream();
		FileOutputStream outputStream = new FileOutputStream(pathFile);
		int byteDownload = 0;
		byte[] b = new byte[1024];
		int length = inputStream.read(b);
		while (length != -1) {
			byteDownload += length;
			System.out.println(byteDownload * 100f / size + "%");
			// write content downloaded from 0 -> length to ouput
			outputStream.write(b, 0, length);
			length = inputStream.read(b);
		}
		inputStream.close();
		outputStream.close();
		System.out.println("Download success");
	}
}
