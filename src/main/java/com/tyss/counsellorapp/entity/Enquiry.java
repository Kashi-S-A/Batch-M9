package com.tyss.counsellorapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tyss.counsellorapp.enums.ClassMode;
import com.tyss.counsellorapp.enums.Course;
import com.tyss.counsellorapp.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;

	private String name;

	private Long phone;

	@Enumerated(EnumType.STRING)
	private Status status=Status.ACTIVE;

	@Enumerated(EnumType.STRING)
	private Course course;

	@Enumerated(EnumType.STRING)
	private ClassMode classMode=ClassMode.OFFLINE;

	@ManyToOne
	@JoinColumn(name = "counsellor_id")
	@JsonIgnore
	private Counsellor counsellor;
}
