package com.stackhack.taskmanagement.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.stackhack.taskmanagement.enums.TaskPriority;
import com.stackhack.taskmanagement.enums.TaskStatus;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private long Id;
	
	@Column(name="task_name",nullable = false,length = 30)
	private String taskName;
	
	@Column(name="task_desc",nullable = false,length = 100)
	private String description;
	
	@Column(nullable = false)
	private TaskStatus status;
	
	@Column(nullable = false)
	private TaskPriority priority;
	
	@Column(name="due_date",nullable = false)
	private Date dueDate;
	
	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
