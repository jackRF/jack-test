package com.jack.test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class BroadCastSender {
	public static void main(String[] args) {
		try {
			InetAddress ip=InetAddress.getByName("192.168.1.255");
			DatagramSocket ds=new DatagramSocket();
			byte[] buf="hello".getBytes();
			DatagramPacket dp=new DatagramPacket(buf, buf.length,ip,8888);
			ds.send(dp);
			ds.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
