package com.ty.EmployeeApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.EmployeeApp.responsestruct.ResponseStructure;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(EmpNotFound.class)
	public ResponseEntity<ResponseStructure<String>> catchEmpNotFound() {

		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("Employee Not found");

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}

	@ExceptionHandler({ NullPointerException.class, ArithmeticException.class })
	public ResponseEntity<ResponseStructure<String>> catchNullPointerException() {
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Cannot be null");

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class )
	public ResponseEntity<ResponseStructure<String>> catchException() {
		ResponseStructure<String> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage("Something went wrong please try again later");

		return new ResponseEntity<ResponseStructure<String>>(rs, HttpStatus.OK);
	}

}
