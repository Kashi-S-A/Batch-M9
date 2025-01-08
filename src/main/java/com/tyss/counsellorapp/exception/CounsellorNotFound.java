package com.tyss.counsellorapp.exception;

public class CounsellorNotFound extends RuntimeException {

	private String message;

	public CounsellorNotFound(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
