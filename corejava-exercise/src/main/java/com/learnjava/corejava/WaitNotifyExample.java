package com.learnjava.corejava;

public class WaitNotifyExample{

	public static void main(String[] args) {

		Data data = new Data();
		String[] packets = {"Packet1", "Packet2", "Packet3", "End"};
		//String[] packets = {"Packet1", "End"};
		
		Runnable sender = () -> {
				
			for(String packet: packets) {
				data.send(packet);
				//System.out.println("Sent " + packet);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable receiver = () -> {

			while(1==1) {
				String receivedPacket = data.receive();
				System.out.println("Received " + data.receive());
				/*
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (receivedPacket.equals("End")) {
					break;
				}*/
			}

		};
		
		new Thread(sender).start();
		new Thread(receiver).start();
		

	}

}


class Data {
	
	private String packet;
	
	private boolean transfer = true;
	
	public synchronized String receive() {
	
		while(transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Receive Thread may have been interrupted !!!");
				e.printStackTrace();
			}
		}
		transfer = true;
		String returnPacket = this.packet;
		System.out.println("Packet in receive " + this.packet);
		notify();
		return returnPacket;
		
	}
	
	public synchronized void send(String packet) {
		
		while(!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println("Transfer Thread may have been interrupted !!!");
				e.printStackTrace();
			}
		}
		transfer = false;
		this.packet = packet;
		System.out.println("Packet in send " + this.packet);
		notify();
	}
	
	
}
