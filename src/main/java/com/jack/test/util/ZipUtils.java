package com.jack.test.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipUtils {
	/**
	 * 解压缩zip
	 * @param zipFile
	 * @param extractDir
	 * @throws IOException 
	 * @throws ZipException 
	 */
	public static void unzip(File zipFile, File extractDir)
			throws ZipException, IOException {
		ZipFile zip = new ZipFile(zipFile);
		@SuppressWarnings("unchecked")
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();
		byte[] buffer = new byte[1024 * 2];
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			String name = entry.getName();
			int lastIndex=Utils.max( name.lastIndexOf("/"), name.lastIndexOf(File.separator));
			if (lastIndex > -1) {
				File fileDir = new File(extractDir,
						name.substring(0, lastIndex));
				if (!fileDir.exists()) {
					fileDir.mkdirs();
				}
			}
			OutputStream os = new BufferedOutputStream(new FileOutputStream(
					new File(extractDir, name)));
			InputStream is = new BufferedInputStream(zip.getInputStream(entry));
			int count = 0;
			while ((count = is.read(buffer, 0, buffer.length)) != -1) {
				os.write(buffer, 0, count);
			}
			os.flush();
			os.close();
			is.close();
		}
		zip.close();
	}
	/**
	 * 把文件压缩成zip
	 * @param destZip
	 * @param files
	 * @throws ZipException
	 * @throws IOException
	 */
	public static void zip(File destZip,File...files) throws ZipException, IOException{
		ZipOutputStream zipOut=new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(destZip)));
		try{
			zip(zipOut, new byte[1024*2], "", files);
		}finally{
			zipOut.flush();
			zipOut.close();
		}
	}
	private static void zip(ZipOutputStream zipOut,byte[] buffer,String base,File...files) throws ZipException, IOException{
		for(File file:files){
			if(file.isDirectory()){
				zip(zipOut, buffer,(base==null||base.isEmpty())?file.getName():base+File.separator+file.getName(), file.listFiles());
				continue;
			}
			zipCompress(zipOut, file, base, buffer);
		}
	}
	private static void zipCompress(ZipOutputStream zipOut, File file, String base,
			byte[] buffer) throws IOException {
		String name=(base==null||base.isEmpty())?file.getName():base+File.separator+file.getName();
		ZipEntry entry = new ZipEntry(name);
		zipOut.putNextEntry(entry);
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
				file));
		int count = 0;
		while ((count = bis.read(buffer, 0, buffer.length)) != -1) {
			zipOut.write(buffer, 0, count);
		}
		bis.close();
		zipOut.closeEntry();
	}
}
