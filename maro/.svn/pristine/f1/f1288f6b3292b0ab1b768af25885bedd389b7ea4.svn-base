package com.maro.manager.common.entity;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;
/**
 * 扩展MultipartFile类，实现文件上传功能
 * @see
 * @since v1.0,2018年3月29日
 * @author gongdaohai
 *
 */
public class CustomMultipartFile implements MultipartFile {
	// 内容
	private byte[] fileContent;

	// 目录
	private String fileDirectory;
	
	// 文件名
	private String fileName;

	private FileOutputStream fileOutputStream;

	public CustomMultipartFile(String fileDirectory,String fileName,byte[] fileData) {
		this.fileDirectory=fileDirectory;
		this.fileName=fileName;
		this.fileContent = fileData;
	}

	public void submit() {
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(fileDirectory);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			file = new File(fileDirectory+ fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(fileContent);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public void transferTo(File dest) throws IOException, IllegalStateException {
		// fileOutputStream = new FileOutputStream(dest);
		// fileOutputStream.write(fileContent);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public FileOutputStream getFileOutputStream() {
		return fileOutputStream;
	}

	public void setFileOutputStream(FileOutputStream fileOutputStream) {
		this.fileOutputStream = fileOutputStream;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public byte[] getBytes() throws IOException {
		return fileContent;
	}

	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(fileContent);
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOriginalFilename() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getContentType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public long getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getFileDirectory() {
		return fileDirectory;
	}

	public void setFileDirectory(String fileDirectory) {
		this.fileDirectory = fileDirectory;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

}
