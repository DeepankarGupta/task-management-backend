package com.stackhack.taskmanagement.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackhack.taskmanagement.exceptions.ResourceNotFoundException;
import com.stackhack.taskmanagement.models.entity.Category;
import com.stackhack.taskmanagement.models.request.CategoryRequest;
import com.stackhack.taskmanagement.models.request.NewCategoryRequest;
import com.stackhack.taskmanagement.models.response.CategoryResponse;
import com.stackhack.taskmanagement.repositories.CategoryRepository;
import com.stackhack.taskmanagement.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Long createCategory(NewCategoryRequest newCategoryRequest) {
		Category category = modelMapper.map(newCategoryRequest, Category.class);
		category = categoryRepository.save(category);
		return category.getCatrgoryId();
	}
	
	@Override
	public CategoryResponse editCategory(CategoryRequest categoryRequest) {
		Category category = modelMapper.map(categoryRequest, Category.class);
		category = categoryRepository.save(category);
		return modelMapper.map(category, CategoryResponse.class);
	}
	
	@Override
	public Long deleteCategory(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		category.orElseThrow(() -> new ResourceNotFoundException("Category with ID: " + categoryId + " does not exist"));
		return category.get().getCatrgoryId();
	}
	
	@Override
	public CategoryResponse getCategoryById(Long categoryId) {
		Optional<Category> category = categoryRepository.findById(categoryId);
		category.orElseThrow(() -> new ResourceNotFoundException("Category with ID: " + categoryId + " does not exist"));
		return modelMapper.map(category.get(), CategoryResponse.class);
	}
	
	@Override
	public List<CategoryResponse> getCategoryList() {
		List<Category> categoryList = categoryRepository.findAll();
		List<CategoryResponse> categoryResponseList = categoryList.stream()
					.map((category) -> this.modelMapper.map(category, CategoryResponse.class))
					.collect(Collectors.toList());
		return categoryResponseList;
	}
	
}
