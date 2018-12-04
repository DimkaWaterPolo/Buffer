package ru.sds.ProductVSCostumer;

public class Product implements Runnable{

	String name = "Product ";
	

	Integer elem ;
	Buffer buffer;
	
	
	public Product(String name, Integer elem, Buffer buffer) {
		super();
		this.name = name;
		this.elem = elem;
		this.buffer= buffer;
	}
	
	
	
	public void run() {
		
		while(true) {
		try {
				System.out.println("Product put "+buffer.put(elem++));
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}}
	
}
