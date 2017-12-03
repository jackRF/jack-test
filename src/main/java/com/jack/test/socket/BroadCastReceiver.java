package com.jack.test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class BroadCastReceiver {
	private static int port=8888;
	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket ds=new DatagramSocket(port);
			byte[] buf=new byte[5];
			DatagramPacket dp=new DatagramPacket(buf, buf.length);
			ds.receive(dp);
			System.out.println(new String(buf));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
