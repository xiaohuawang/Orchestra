package com;

public class BrokenInstrumentException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BrokenInstrumentException() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return "Unable to play with a broken instrument";
	}
}
