package com.thkmon.encode.main;

import java.io.File;

import com.thkmon.encode.prototype.StringList;
import com.thkmon.encode.util.FileCharsetUtil;
import com.thkmon.encode.util.FileUtil;

public class MainClass {

	public static void main(String[] args) {
		String filePath = "C:\\Users\\gendev\\git\\BBNaverBlogParser\\BBNaverBlogParser\\src\\com\\thkmon\\blogparser\\util\\JsonUtil.java";
		
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				return;
			}
			
			if (!file.isFile()) {
				return;
			}
			
			String charset = FileCharsetUtil.detectCharset(file);
			System.out.println("filePath : " + file.getAbsolutePath());
			System.out.println("charset : " + charset);
			
			if (charset != null && !charset.equalsIgnoreCase("UTF-8")) {
				StringList fileContents = FileUtil.readFile(file, "MS949");
				FileUtil.writeFile(filePath, fileContents, "UTF-8", false);	
			}
			
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}