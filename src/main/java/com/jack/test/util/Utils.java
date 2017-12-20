package com.jack.test.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class Utils {
	public static String propertyToColumn(String property,StringBuilder sb){
		sb.setLength(0);
		int i=0;
		boolean startUpperCase=false;
		while(i<property.length()){
			char c=property.charAt(i++);
			if(c>='A' && c<='Z'){
				if(i==1){
					startUpperCase=true;
				}
				if(!startUpperCase){
					sb.append('_');
				}
			}else{
				if(startUpperCase){
					startUpperCase=false;
				}
				if(c>='a'&& c<='z'){
					c=(char) (c-('a'-'A'));
				}
			}
			sb.append(c);
		}
		return sb.toString();
	}
	public static String columnToProperty(String alias,StringBuilder sb){
		sb.setLength(0);
		boolean underlineBefore=false;
		for(int i=0;i<alias.length();i++){
			char c=alias.charAt(i);
			if(c=='_'){
				underlineBefore=true;
				continue;
			}
			if(underlineBefore){
				if(c>='a'&& c<='z'){
					c=(char) (c-('a'-'A'));
				}
				underlineBefore=false;
			}else if(c>='A' && c<='Z'){
				c=(char) (c+('a'-'A'));
			}
			sb.append(c);
		}
		return sb.toString();
	}
	/**
	 * 从文件读text  UTF-8
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readText(File file) throws IOException{
		return readText(file, "UTF-8");
	}
	/**
	 * 从文件读text
	 * @param file
	 * @param charsetName 编码
	 * @return
	 * @throws IOException
	 */
	public static String readText(File file,String charsetName) throws IOException{
		BufferedInputStream in=null;
		try{
			in=new BufferedInputStream(new FileInputStream(file));
			return readText(in, charsetName);
		}finally{
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static String dataToParams(Map<String,?> data){
		StringBuilder sb=new StringBuilder();
		int i=0;
		for(Map.Entry<String,?> entry:data.entrySet()){
			if(i>0){
				sb.append("&");
			}
			sb.append(entry.getKey());
			sb.append("=");
			sb.append(entry.getValue());
			i++;
		}
		return sb.toString();
	}
	public static List<NameValuePair> dataToNameValuePairs(Map<String,?> data){
		List<NameValuePair> params=new ArrayList<NameValuePair>();
		for(Map.Entry<String,?> entry:data.entrySet()){
			NameValuePair pair=new BasicNameValuePair(entry.getKey(),entry.getValue().toString());
			params.add(pair);
		}
		return params;
	}
	/**
	 * 从输入流读text charsetName
	 * @param is
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static String readText(InputStream is) throws IOException {
		return readText(is,"UTF-8");
	}
	/**
	 * 从输入流读text charsetName
	 * @param is
	 * @param charsetName
	 * @return
	 * @throws IOException
	 */
	public static String readText(InputStream is,String charsetName) throws IOException {
		BufferedReader reader=null;
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			reader = new BufferedReader(new InputStreamReader(is,charsetName));
			while ((line = reader.readLine()) != null) {
				sb.append(line);
				sb.append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}  
}
