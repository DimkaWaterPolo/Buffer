package ru.sds.ProductVSCostumer;

public class Costumer implements Runnable {

	

	Buffer buffer;
	
	public Costumer(Buffer buffer) {
		super();
		this.buffer = buffer;
	}
	
	public void run() {
		
		while(true) {
		try {
			int a = buffer.get();
			System.out.println("Costumer get "+a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}
}
