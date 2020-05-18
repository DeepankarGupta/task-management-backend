package com.stackhack.taskmanagement.models.response;

import java.util.Date;

public class TaskResponse {
	
	private long Id;
	private String taskName;
	private String description;
	private Date dueDate;
	private Date creationDate;
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
