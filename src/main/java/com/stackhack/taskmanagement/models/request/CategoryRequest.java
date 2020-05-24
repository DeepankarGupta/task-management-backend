package com.stackhack.taskmanagement.models.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryRequest {
	
	@NotNull(message = "Must not be blank")
	private Long categoryId;
	
	@NotBlank(message = "Must not be blank")
	@Size(max = 20, message = "Maximum length is 20")
	private String categoryName;
	
	@Size(max = 100, message = "Maximum length is 100")
	private String categoryDescription;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
}
