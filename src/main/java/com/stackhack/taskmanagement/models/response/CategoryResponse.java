package com.stackhack.taskmanagement.models.response;

public class CategoryResponse {
	
	private Long catrgoryId;
	private String catrgoryName;
	private String categoryDescription;

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

}
