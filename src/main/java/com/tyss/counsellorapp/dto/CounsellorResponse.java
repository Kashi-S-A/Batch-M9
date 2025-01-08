package com.tyss.counsellorapp.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CounsellorResponse {

	private Integer cid;

	private String name;

	private String email;

	private Long phone;

	private LocalDateTime updatedDate;
}
