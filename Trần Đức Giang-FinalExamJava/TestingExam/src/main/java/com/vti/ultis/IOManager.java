package com.vti.ultis;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class IOManager {
	public static final String OBJECT_IS_NULL = "Error! Object is Null";
	public static String readFile(String pathFile) throws Exception {
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathFile);
			byte[] b = new byte[1024];
			int length = fileInputStream.read(b);
			String content = "";
			while (length>-1) {
				content = new String(b, 0, length);
				length = fileInputStream.read(b);
			}
			return content;
		} finally {
			fileInputStream.close();
		}
	}
	public static void writeFile(String pathFile, String content, boolean isContinuing) throws Exception{
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}
		FileOutputStream fileOutputStream = null;
		
		try {
			fileOutputStream = new FileOutputStream(pathFile, isContinuing);
			fileOutputStream.write(content.getBytes());;
		} finally {
			fileOutputStream.close();
		}
	}
	
	public static Object readObject(String pathFile) throws Exception {
		if (!FileManager.isFileExists(pathFile)) {
			throw new Exception(FileManager.FILE_NOT_EXISTS);
		}
		
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;
		
		try {
			fileInputStream = new FileInputStream(pathFile);
			objectInputStream = new ObjectInputStream(fileInputStream);
			return objectInputStream.readObject();
		} finally {
			fileInputStream.close();
			objectInputStream.close();
		}
	}
	
	public static void writeObject(String path,String fileName, Object object) throws Exception {
		if (object==null) {
			throw new Exception(OBJECT_IS_NULL);
		}
		
		if (!FileManager.isFolderExists(path)) {
			FileManager.createFolder(path);
		}
		String pathFile = path + "\\" + fileName;
		
		if (!FileManager.isFileExists(pathFile)) {
			FileManager.createFile(pathFile);
		}
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(pathFile, false);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(object);

		}
		
		
		finally {
			fileOutputStream.close();
			objectOutputStream.close();
		}

	}
}
