package com.stackhack.taskmanagement.models.response;

import java.util.Date;

import com.stackhack.taskmanagement.enums.TaskPriority;
import com.stackhack.taskmanagement.enums.TaskStatus;

public class TaskResponse {
	
	private long Id;
	private String taskName;
	private String description;
	private TaskStatus status;
	private TaskPriority priority;
	private Date dueDate;
	private Date completionDate;
	private Date creationDate;
	private CategoryResponse category;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TaskStatus getStatus() {
		return status;
	}
	public void setStatus(TaskStatus status) {
		this.status = status;
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
	public CategoryResponse getCategory() {
		return category;
	}
	public void setCategory(CategoryResponse category) {
		this.category = category;
	}
	public Date getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}
}
