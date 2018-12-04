package ru.sds.ProductVSCostumer;

public class Buffer {

	

	Product product;
	Costumer costumer;
	
	Integer elem = null;
	
	public synchronized Integer put(Integer element) throws InterruptedException{
		
		while(elem != null ) {
			this.wait();
		}
		this.elem = element;
		this.notifyAll();
		
		return this.elem;
	}
	
	public synchronized  Integer get () throws InterruptedException {
		
		while(elem == null ) {
			this.wait();
		}
		int a = this.elem;
		this.elem=null;
		this.notifyAll();
		return a;
	
	}
	
	@Override
	public String toString() {
		return   product.name + " "+ product.elem;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Buffer buffer = new Buffer();
		
		Product product =  new Product("01", 1, buffer);
		Thread thread =  new Thread(product);
		thread.start();
		
		Product product1 =  new Product("01", 8, buffer);
		Thread thread1 =  new Thread(product1);
		thread1.start();
		
		Costumer costumer =  new Costumer(buffer);
		Thread thread2 = new Thread(costumer);
		thread2.start();
		
		
		
	}
}
