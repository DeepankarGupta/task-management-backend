package com.stackhack.taskmanagement.models.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NewCategoryRequest {
	
	@NotBlank(message = "Must not be blank")
	@Size(max = 20, message = "Maximum length is 20")
	private String catrgoryName;
	
	@Size(max = 100, message = "Maximum length is 100")
	private String categoryDescription;
	
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
