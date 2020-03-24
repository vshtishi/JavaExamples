package com.github.vshtishi;

//Creating a Singleton class
public class Cookies {
   
	private int quantity=100;
	
	//Private constructor; The singleton class is effectively final
	private Cookies(){
		
	}
	/*Applying Lazy Instantiation:
	 * private static Cookies instance;
	 * public static Cookies getInstance(){
	 *    if(instance==null)
	 *      instance=new Cookies(); 
	 *   }
	 */
	private static final Cookies instance= new Cookies();
	
	public static Cookies getInstance(){
		return instance;
	}
	
	//Synchronized prevents two processes from running the same method at the same time
	public synchronized void addCookies(int amount){
		quantity+=amount;
	}
	
	public synchronized boolean takeCookies(int amount){
		if(quantity < amount)
			return false;
		quantity-=amount;
		return true;
	}
	
	public synchronized int getCookieNr(){
		return quantity;
	}
	
}
