package com.stackhack.taskmanagement.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long catrgoryId;
	
	@Column(nullable = false)
	private String catrgoryName;
	
	@Column
	private String categoryDescription;
	
	@Column
	@OneToMany(mappedBy = "category")
	private List<Task> tasks = new ArrayList<Task>();

	public Long getCatrgoryId() {
		return catrgoryId;
	}

	public void setCatrgoryId(Long catrgoryId) {
		this.catrgoryId = catrgoryId;
	}

	public String getCatrgoryName() {
		return catrgoryName;
	}

	public void setCatrgoryName(String catrgoryName) {
		this.catrgoryName = catrgoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
}
