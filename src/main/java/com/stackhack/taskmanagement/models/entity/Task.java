package com.stackhack.taskmanagement.models.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long Id;
	
	@Column(name="task_name")
	private String taskName;
	
	@Column(name="task_desc")
	private String desciption;
	
	@Column(name="due_date")
	private Date dueDate;
	
	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;
	
}
