package com.jack.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DomaClient {
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost",8888);
			DataOutputStream os=new DataOutputStream(socket.getOutputStream());
			DataInputStream is=new DataInputStream(socket.getInputStream());
			os.writeUTF("我是客户端，请求连接");
			System.out.println(is.readUTF());
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
