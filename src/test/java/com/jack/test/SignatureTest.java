package com.jack.test;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.jack.test.util.Utils;


public class SignatureTest extends BaseTest {
	private static char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	interface MessageStrategy{
		StringBuilder messageStrategy(Map<String,String> paramMap,String[] sortParamNames);
	}
	@Test
	public void testSH(){
		Map<String,String> req = new HashMap<String,String>();
		req.put("sorgcode", "30310105201605003");
		req.put("name", "孙妍妍");
		req.put("idCard", "411422198810245725");
		CloseableHttpClient httpClient=null;
		try {
			String hash = signatureForSH(req, "e3DydhHm6cHEP26");
			req.put("hash",hash);
			httpClient=HttpClientBuilder.create().build();
			HttpPost httpPost=new HttpPost("https://test.suanhua.org/cpcs/api/v2"+"/channel/3001");
			HttpEntity entity=new UrlEncodedFormEntity(Utils.dataToNameValuePairs(req),"UTF-8");
			httpPost.setEntity(entity);
			HttpResponse httpResponse=httpClient.execute(httpPost);
			entity=httpResponse.getEntity();
			System.out.println(Utils.readText(entity.getContent()));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(httpClient!=null){
				try {
					httpClient.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static StringBuilder buildDigestMessage(Map<String,String> map,MessageStrategy ms){
		List<String> list = new ArrayList<String>();
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		String[] arr = list.toArray(new String[list.size()]);
		// 将参数进行字典序排序
		Arrays.sort(arr);
		StringBuilder content =null;
		if(ms!=null){
			content=ms.messageStrategy(map, arr);
		}else{
			content = new StringBuilder();
			for (int i = 0; i < arr.length; i++) {
				if(null != map.get(arr[i])){
					content.append(arr[i] + "=" + map.get(arr[i])).append("&");
				}
			}
			content.deleteCharAt(content.length() - 1);
		}
		return content;
	}
	public static String signatureForSH(Map<String,String> map,final String secret) throws Exception {
		StringBuilder content=buildDigestMessage(map, new MessageStrategy(){

			@Override
			public StringBuilder messageStrategy(Map<String, String> paramMap,
					String[] sortParamNames) {
				StringBuilder sb=new StringBuilder();
				for(String paramName:sortParamNames){
					sb.append(paramMap.get(paramName));
				}
				sb.append(secret);
				return sb;
			}
		});
		return md5(content.toString().getBytes("utf-8"));
	}
	public static String md5(byte[] input) throws NoSuchAlgorithmException{
		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		byte[] digest = messageDigest.digest(input);
		String sign = byts2hexstr(digest);
		return sign;
	}
	private static String byts2hexstr(byte[] arrayBytes) {
        StringBuilder sb = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < arrayBytes.length; i++) {
            tmp = Integer.toHexString(arrayBytes[i] & 0xff);
            sb.append(tmp.length() == 1 ? "0" + tmp : tmp);
        }
        return sb.toString();
    }
	private static String byteToHexStr(byte mByte) {
		
		char[] tempArr = new char[2];
		tempArr[0] = digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
}
