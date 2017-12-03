package com.jack.test.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Doma1 {
	private static final int PORT=8888;
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(PORT);
			Socket socket=server.accept();
			DataOutputStream os=new DataOutputStream(socket.getOutputStream());
			DataInputStream is=new DataInputStream(socket.getInputStream());
			System.out.println("服务器接收到客户端的连接请求："+is.readUTF());
			os.writeUTF("接受连接请求，连接成功！");
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
