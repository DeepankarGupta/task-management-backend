package com.stackhack.taskmanagement.services;

import java.util.List;

import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.entity.Category;
import com.stackhack.taskmanagement.models.request.CategoryRequest;
import com.stackhack.taskmanagement.models.request.NewCategoryRequest;
import com.stackhack.taskmanagement.models.response.CategoryResponse;
import com.stackhack.taskmanagement.models.response.CustomResponse;

public interface CategoryService {

	Long createCategory(NewCategoryRequest newCategoryRequest);

	CategoryResponse editCategory(CategoryRequest categoryRequest);

	Long deleteCategory(Long categoryId);

	CategoryResponse getCategoryById(Long categoryId);

	List<CategoryResponse> getCategoryList();

}