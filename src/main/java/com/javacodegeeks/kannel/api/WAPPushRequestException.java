package com.javacodegeeks.kannel.api;

public class WAPPushRequestException extends Exception {
	
	private static final long serialVersionUID = 6722237267183091630L;

	public WAPPushRequestException() {
		super();
	}

	public WAPPushRequestException(String theMessage) {
		super(theMessage);
	}

	public WAPPushRequestException(String theMessage, Exception e) {
		super(theMessage, e);
	}

}
