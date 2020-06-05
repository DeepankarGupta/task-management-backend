package com.stackhack.taskmanagement.models.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.stackhack.taskmanagement.enums.TaskPriority;

public class NewTaskRequest {
	
	@NotBlank(message = "Must not be blank")
	@Size(max = 30, message = "Maximum length is 30")
	private String taskName;
	
	@NotBlank(message = "Must not be blank")
	@Size(max = 100, message = "Maximum length is 100")
	private String description;
	
	@NotNull(message = "Must not be blank")
	private Date dueDate;
	
	@NotNull(message = "Must not be blank")
	private Long categoryId;
	
	@NotNull(message = "Must not be blank")
	private TaskPriority priority;
	
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public TaskPriority getPriority() {
		return priority;
	}
	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}
}
