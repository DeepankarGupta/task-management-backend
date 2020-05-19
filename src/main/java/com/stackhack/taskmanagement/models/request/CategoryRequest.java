package com.stackhack.taskmanagement.models.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CategoryRequest {
	
	@NotBlank(message = "Must not be blank")
	private Long catrgoryId;
	
	@NotBlank(message = "Must not be blank")
	@Size(max = 20, message = "Maximum length is 20")
	private String catrgoryName;
	
	@Size(max = 100, message = "Maximum length is 100")
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
