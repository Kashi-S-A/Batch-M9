package com.tyss.counsellorapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounsellorRequest {

	private String name;

	private String email;

	private Long phone;

	private String password;
}
