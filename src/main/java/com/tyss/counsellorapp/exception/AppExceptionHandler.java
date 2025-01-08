package com.tyss.counsellorapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(CounsellorNotFound.class)
	public ResponseEntity<String> catchCounsellorNotFound(CounsellorNotFound message) {
		return new ResponseEntity<String>(message.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(EnquiryNotFoundException.class)
	public HeadersBuilder<?> catchEnquiryNotFoundException() {
		return ResponseEntity.notFound();
	}

}
