package cn.test;

import javax.swing.filechooser.FileSystemView;
import java.io.File;

public class FileTest {
	public static void main(String[] args) {
		System.out.println(System.getProperties().getProperty("user.home"));

		File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
		String desktopPath = desktopDir.getAbsolutePath();
		File file1 = desktopDir.getAbsoluteFile();
		System.out.println(desktopPath);
		System.out.println(file1.getName());

		File file = getFile();
		System.out.println(file.getName());

		System.out.println(System.getProperty("user.dir"));
	}

	public static File getFile(){
		File file = new File(FileSystemView.getFileSystemView().getHomeDirectory().getAbsolutePath()+"/timg.jpg");
		return file;
	}

}
