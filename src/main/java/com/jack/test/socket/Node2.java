package com.jack.test.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class Node2 {
	private static int port =8000;
	private static String address="228.0.0.4";
	public static void main(String[] args) {
		try {
			InetAddress group=InetAddress.getByName(address);
			@SuppressWarnings("resource")
			MulticastSocket mss=new MulticastSocket(port);
			mss.joinGroup(group);
			byte[] buffer=new byte[1024];
			while(true) {
				DatagramPacket dp=new DatagramPacket(buffer, buffer.length);
				mss.receive(dp);
				String s=new String(dp.getData(),0,dp.getLength());
				System.out.println("receive from node1:"+s);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
